package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

//lookup table
@Entity(
    tableName = "loot_box_rarity"
)
data class Loot_box_rarity(
    @PrimaryKey val loot_box_rarity_id: Int,

    val rarity_name: String,
    val appearance_percentage: Int,
    val rarity_color: String
)
