package com.example.foxynotes.DataBase

import android.R
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "timer"
)
data class Timer(
    @PrimaryKey(autoGenerate = true) val timer_id: Int,

    val timer_name: String,
    val duration_seconds: Long
)
