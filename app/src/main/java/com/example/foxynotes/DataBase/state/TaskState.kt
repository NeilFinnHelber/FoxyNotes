package com.example.foxynotes.DataBase.state

import com.example.foxynotes.DataBase.Task
import com.example.foxynotes.DataBase.enums.TaskSortType

data class TaskState(
    val tasks: List<Task> = emptyList(),

    val title: String = "",
    val description: String = "",

    val isAddingTask: Boolean = false,
    val sortType: TaskSortType = TaskSortType.TITLE
)

