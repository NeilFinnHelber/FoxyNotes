package com.example.foxynotes.DataBase.repository

import com.example.foxynotes.DataBase.Item
import com.example.foxynotes.DataBase.Loot_box
import kotlinx.coroutines.flow.Flow

interface InventoryRepository {

    fun getItems(): Flow<List<Item>>
    fun getLootBoxes(): Flow<List<Loot_box>>

    suspend fun purchaseItem(
        userId: Int,
        itemId: Int,
        amount: Int = 1
    )

    suspend fun openLootBox(
        userId: Int,
        lootBoxId: Int
    )
}
