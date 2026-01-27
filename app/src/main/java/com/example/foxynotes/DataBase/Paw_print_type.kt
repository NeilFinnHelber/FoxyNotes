package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "paw_print_type"
)
data class Paw_print_type(
    @PrimaryKey val paw_print_type_id: Int,
    val type_name: String,
    val type_color: String

)
