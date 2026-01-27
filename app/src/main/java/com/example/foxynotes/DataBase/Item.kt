package com.example.foxynotes.DataBase

import android.R
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "item",
    foreignKeys = [
        ForeignKey(
            entity = Item_rarity::class,
            parentColumns = ["item_rarity_id"],
            childColumns = ["item_rarity_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("item_rarity_id")]
)
data class Item(
    @PrimaryKey(autoGenerate = true) val item_id: Int = 0,
    val item_rarity_id: Int,

    val is_unlocked: Boolean,
    val base_cost: Int,
    val art_url: String,
    val vaucher_cost: Int?
)
