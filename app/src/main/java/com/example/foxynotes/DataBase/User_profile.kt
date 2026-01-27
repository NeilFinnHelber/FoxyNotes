package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalTime

@Entity(
    tableName = "user_profile",
    foreignKeys = [
        ForeignKey(
            entity = Theme::class,
            parentColumns = ["theme_id"],
            childColumns = ["theme_id"],
            onDelete = ForeignKey.RESTRICT
        ),
        ForeignKey(
            entity = Timer::class,
            parentColumns = ["timer_id"],
            childColumns = ["timer_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("theme_id"), Index("timer_id")]
)
data class User_profile(
    @PrimaryKey(autoGenerate = true) val user_id: Int,

    val theme_id: Int? = 0,
    val timer_id: Int?,

    val profile_image_url: String,
    val experience_points: Int,
    val active_task_amount: Int,
    val reroll_usage_amount_today: Int,
    val start_time_sending_notifications: LocalTime,
    val end_time_sending_notifications: LocalTime,
    val refresh_tasks_time_in_hours: Int,
    val refresh_item_costs_time_in_hours: Int
)
