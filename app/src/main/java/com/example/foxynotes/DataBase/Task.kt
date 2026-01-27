package com.example.foxynotes.DataBase

import android.R
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "task",
    foreignKeys = [
        ForeignKey(
            entity = Task_type::class,
            parentColumns = ["task_type_id"],
            childColumns = ["task_type_id"],
            onDelete = ForeignKey.CASCADE
        ),
            ForeignKey(
                entity = Subject::class,
                parentColumns = ["subject_id"],
                childColumns = ["subject_id"],
                onDelete = ForeignKey.CASCADE
            )
    ],
    indices = [Index("subject_id"), Index("task_type_id")]
)
data class Task(
    @PrimaryKey(autoGenerate = true) val task_id: Int,

    val task_type_id: Int,
    val subject_id: Int,

    val task_title: String,
    val task_description: String?,
    val repeating_number: Int,
    val task_color: String?,
    val neglected_total_probability_addition: Float?,
    val active_for_days_number: Int,
    val is_in_progress: Boolean,
    val is_currently_to_do_task: Boolean,
    val is_choosen_task: Boolean,
    val percentage_of_completion: Int
)
