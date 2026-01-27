package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(
    tableName = "daily_task_completion_chart",
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
data class Daily_task_completion_chart(
    @PrimaryKey(autoGenerate = true) val completion_chart_id: Int,
    val user_id: Int,

    val paw_print_amount: Int,
    val date_time: LocalDateTime

)
