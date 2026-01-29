package com.example.foxynotes.DataBase.event

import com.example.foxynotes.DataBase.Subject

sealed interface SubjectEvent {

    object SaveSubject : SubjectEvent
    data class DeleteSubject(val subject: Subject) : SubjectEvent

    data class SetTitle(val title: String) : SubjectEvent
    data class SetDescription(val description: String) : SubjectEvent
    data class SetColor(val color: String) : SubjectEvent

    object ShowDialog : SubjectEvent
    object HideDialog : SubjectEvent
}
