package com.example.foxynotes.DataBase.state

import com.example.foxynotes.DataBase.Item
import com.example.foxynotes.DataBase.Loot_box
import com.example.foxynotes.DataBase.Unlocked_item

data class InventoryState(
    val items: List<Item> = emptyList(),
    val lootBoxes: List<Loot_box> = emptyList(),

    val selectedItem: Item? = null,
    val isDialogOpen: Boolean = false
)

