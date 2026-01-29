package com.example.foxynotes.DataBase.event

import com.example.foxynotes.DataBase.Item
import com.example.foxynotes.DataBase.Loot_box

sealed interface InventoryEvent {

    data class PurchaseItem(
        val itemId: Int,
        val amount: Int = 1
    ) : InventoryEvent

    data class OpenLootBox(
        val lootBoxId: Int
    ) : InventoryEvent

    object HideDialog : InventoryEvent
}

