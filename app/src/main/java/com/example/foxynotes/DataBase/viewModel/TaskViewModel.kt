package com.example.foxynotes.DataBase.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foxynotes.DataBase.Task
import com.example.foxynotes.DataBase.dao.TaskDao
import com.example.foxynotes.DataBase.enums.TaskSortType
import com.example.foxynotes.DataBase.event.TaskEvent
import com.example.foxynotes.DataBase.state.TaskState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


@OptIn(ExperimentalCoroutinesApi::class)
class TaskViewModel(private val dao: TaskDao) : ViewModel() {

    private val _sortType = MutableStateFlow(TaskSortType.TITLE)
    private val _state = MutableStateFlow(TaskState())

    private val _tasks = _sortType
        .flatMapLatest { sortType ->
            when (sortType) {
                TaskSortType.TITLE -> dao.getTasksOrderedByTitle()
                TaskSortType.CREATION_DATE -> dao.getTasksOrderedById()
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(),
            emptyList()
        )

    val state = combine(_state, _sortType, _tasks) { state, sortType, tasks ->
        state.copy(
            tasks = tasks,
            sortType = sortType
        )
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        TaskState()
    )

    fun onEvent(event: TaskEvent) {
        when (event) {

            is TaskEvent.DeleteTask -> {
                viewModelScope.launch {
                    dao.deleteTask(event.task)
                }
            }

            TaskEvent.ShowDialog -> {
                _state.update {
                    it.copy(isAddingTask = true)
                }
            }

            TaskEvent.HideDialog -> {
                _state.update {
                    it.copy(isAddingTask = false)
                }
            }

            is TaskEvent.SetTitle -> {
                _state.update {
                    it.copy(title = event.title)
                }
            }

            is TaskEvent.SetDescription -> {
                _state.update {
                    it.copy(description = event.description)
                }
            }

            is TaskEvent.SetSortType -> {
                _sortType.value = event.sortType
            }

            TaskEvent.SaveTask -> {
                val title = state.value.title
                val description = state.value.description

                if (title.isBlank()) return

                val task = Task(
                    task_id = 0,
                    task_type_id = 1, // example default
                    subject_id = 1,   // example default
                    task_title = title,
                    task_description = description,
                    repeating_number = 0,
                    task_color = null,
                    neglected_total_probability_addition = null,
                    active_for_days_number = 0,
                    is_in_progress = false,
                    is_currently_to_do_task = false,
                    is_choosen_task = false,
                    percentage_of_completion = 0
                )

                viewModelScope.launch {
                    dao.insertTask(task)
                }

                _state.update {
                    it.copy(
                        title = "",
                        description = "",
                        isAddingTask = false
                    )
                }
            }
        }
    }
}
