package com.example.foxynotes.DataBase.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foxynotes.DataBase.Subject
import com.example.foxynotes.DataBase.dao.SubjectDao
import com.example.foxynotes.DataBase.event.SubjectEvent
import com.example.foxynotes.DataBase.state.SubjectState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class SubjectViewModel(private val dao: SubjectDao) : ViewModel() {

    private val _state = MutableStateFlow(SubjectState())

    private val _subjects = dao.getSubjects()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    val state = combine(_state, _subjects) { state, subjects ->
        state.copy(subjects = subjects)
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        SubjectState()
    )

    fun onEvent(event: SubjectEvent) {
        when (event) {

            SubjectEvent.ShowDialog -> {
                _state.update { it.copy(isAddingSubject = true) }
            }

            SubjectEvent.HideDialog -> {
                _state.update { it.copy(isAddingSubject = false) }
            }

            is SubjectEvent.SetTitle -> {
                _state.update { it.copy(title = event.title) }
            }

            is SubjectEvent.SetDescription -> {
                _state.update { it.copy(description = event.description) }
            }

            is SubjectEvent.SetColor -> {
                _state.update { it.copy(color = event.color) }
            }

            SubjectEvent.SaveSubject -> {
                val stateValue = state.value
                if (stateValue.title.isBlank()) return

                viewModelScope.launch {
                    dao.insertSubject(
                        Subject(
                            subject_id = 0,
                            paw_print_type_id = 1,
                            subject_form_type_id = 1,
                            subject_title = stateValue.title,
                            subject_description = stateValue.description,
                            subject_color = stateValue.color,
                            is_active = true,
                            subject_appearance_proability_multiplier = 1,
                            goal_of_the_subject = ""
                        )
                    )
                }

                _state.update {
                    it.copy(
                        title = "",
                        description = "",
                        color = "",
                        isAddingSubject = false
                    )
                }
            }

            is SubjectEvent.DeleteSubject -> {
                viewModelScope.launch {
                    dao.deleteSubject(event.subject)
                }
            }
        }
    }
}
