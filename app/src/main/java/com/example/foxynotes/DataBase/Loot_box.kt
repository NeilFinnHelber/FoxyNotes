package com.example.foxynotes.DataBase

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "loot_box",
    foreignKeys = [
        ForeignKey(
            entity = Loot_box_rarity::class,
            parentColumns = ["loot_box_rarity_id"],
            childColumns = ["loot_box_rarity_id"],
            onDelete = ForeignKey.RESTRICT
        )
    ],
    indices = [Index("loot_box_rarity_id")]
)
data class Loot_box(
    @PrimaryKey(autoGenerate = true) val loot_box_id: Int,

    val loot_box_rarity_id: Int,
    val loot_box_art_image_url: String
)
