package com.example.foxynotes.DataBase.event

import com.example.foxynotes.DataBase.Task
import com.example.foxynotes.DataBase.enums.TaskSortType

sealed interface TaskEvent {

    object SaveTask : TaskEvent
    data class DeleteTask(val task: Task) : TaskEvent

    data class SetTitle(val title: String) : TaskEvent
    data class SetDescription(val description: String) : TaskEvent

    data class SetSortType(val sortType: TaskSortType) : TaskEvent

    object ShowDialog : TaskEvent
    object HideDialog : TaskEvent
}
