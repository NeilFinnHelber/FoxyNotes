package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

//lookup table
@Entity(
    tableName = "task_type"
)
data class Task_type(
    @PrimaryKey val task_type_id: Int,

    val task_type_scope: String,
    val type_description: String,
    val experience_multiplier: Int
)
