package com.example.foxynotes.DataBase.state

import com.example.foxynotes.DataBase.Notification
import java.time.LocalTime

data class NotificationState(
    val notifications: List<Notification> = emptyList(),

    val notificationName: String = "",
    val notificationText: String = "",
    val notificationTime: LocalTime? = null,

    val isAddingNotification: Boolean = false
)

