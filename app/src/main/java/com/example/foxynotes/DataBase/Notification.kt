package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(
    tableName = "notification",
    foreignKeys = [
        ForeignKey(
            entity = User_profile::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("user_id")]
)
data class Notification(
    @PrimaryKey(autoGenerate = true) val notification_id: Int,

    val user_id: Int,

    val notification_name: String,
    val notification_text: String,
    val notification_time: LocalTime
)
