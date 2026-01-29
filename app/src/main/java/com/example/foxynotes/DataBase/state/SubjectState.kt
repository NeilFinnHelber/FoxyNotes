package com.example.foxynotes.DataBase.state

import com.example.foxynotes.DataBase.Subject

data class SubjectState(
    val subjects: List<Subject> = emptyList(),

    val title: String = "",
    val description: String = "",
    val color: String = "",

    val isAddingSubject: Boolean = false
)

