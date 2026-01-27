package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    tableName = "user_item_inventory",
    primaryKeys = ["item_id","user_id"],
    foreignKeys = [
        ForeignKey(
            entity = Item::class,
            parentColumns = ["item_id"],
            childColumns = ["item_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User_profile::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("item_id"), Index("user_id")]
)
data class User_item_inventory(
    val user_id: Int,
    val item_id: Int,

    val purchased_date: LocalDate,
    val amount: Int? = 0
)
