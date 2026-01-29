package com.example.foxynotes.DataBase.event

sealed interface UserEvent {
    data class ChangeTheme(val themeId: Int) : UserEvent
    data class ChangeTimer(val timerId: Int) : UserEvent

    object ShowProfile : UserEvent
    object HideProfile : UserEvent
}

