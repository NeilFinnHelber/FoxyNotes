package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "item_rarity"
)
data class Item_rarity(
@PrimaryKey val item_rarity_id: Int,
    val rarity_type: String,
    val rarity_appearance_probabilities: Int?,
    val rarity_color: String?
)
