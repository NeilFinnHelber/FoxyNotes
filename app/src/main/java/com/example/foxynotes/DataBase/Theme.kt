package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

//lookup table
@Entity(
    tableName = "theme"
)
data class Theme(
    @PrimaryKey val theme_id: Int,

    val theme_dominant_color: String,
    val theme_secondary_color: String,
    val theme_accent_color: String,
    val theme_name: String
)
