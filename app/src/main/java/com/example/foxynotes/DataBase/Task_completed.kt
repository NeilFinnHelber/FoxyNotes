package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "task_completed",
    foreignKeys = [
        ForeignKey(
            entity = User_profile::class,
            parentColumns = ["task_id"],
            childColumns = ["task_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("task_id")]
)
data class Task_completed(
    @PrimaryKey(autoGenerate = true) val task_completed_id: Int,

    val task_id: Int,

    val completion_date: LocalDate,
    val task_completion_imageURL: String?
)
