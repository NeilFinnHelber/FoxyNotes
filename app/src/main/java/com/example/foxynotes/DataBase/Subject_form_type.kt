package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "subject_form_type"
)
data class Subject_form_type(
    @PrimaryKey val subject_form_type_id: Int,
    val form_type_name: String
)
