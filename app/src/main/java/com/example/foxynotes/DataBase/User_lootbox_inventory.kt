package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "user_lootbox_inventory",
    primaryKeys = ["user_id", "loot_box_id"],
    foreignKeys = [
        ForeignKey(
            entity = Loot_box::class,
            parentColumns = ["loot_box_id"],
            childColumns = ["loot_box_id"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User_profile::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("loot_box_id"), Index("user_id")]
)
data class User_lootbox_inventory(
    val loot_box_id: Int,
    val user_id: Int,

    val amount: Int
)
