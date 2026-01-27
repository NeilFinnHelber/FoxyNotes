package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index

@Entity(
    tableName = "task_prerequisite_for_appearance_of_task",
    primaryKeys = ["prerequisite_task_id", "child_task_id"],
    foreignKeys = [
        ForeignKey(
            entity = Task::class,
            parentColumns = ["task_id"],
            childColumns = ["prerequisite_task_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Task::class,
            parentColumns = ["task_id"],
            childColumns = ["child_task_id"],
            onDelete = ForeignKey.CASCADE
        ),
    ],
    indices = [Index("prerequisite_task_id"), Index("child_task_id")]
)
data class Task_prerequisite_for_appearance_of_task(
    val prerequisite_task_id: Int,
    val child_task_id: Int
)
