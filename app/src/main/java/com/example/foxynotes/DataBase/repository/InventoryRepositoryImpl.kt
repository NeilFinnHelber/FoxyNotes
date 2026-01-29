package com.example.foxynotes.DataBase.repository

import com.example.foxynotes.DataBase.Item
import com.example.foxynotes.DataBase.Loot_box
import com.example.foxynotes.DataBase.User_item_inventory
import com.example.foxynotes.DataBase.dao.ItemDao
import com.example.foxynotes.DataBase.dao.LootBoxDao
import com.example.foxynotes.DataBase.dao.UserItemInventoryDao
import kotlinx.coroutines.flow.Flow

class InventoryRepositoryImpl(
    private val itemDao: ItemDao,
    private val lootBoxDao: LootBoxDao,
    private val userItemInventoryDao: UserItemInventoryDao
) : InventoryRepository {

    override fun getItems(): Flow<List<Item>> =
        itemDao.getAllItems()

    override fun getLootBoxes(): Flow<List<Loot_box>> =
        lootBoxDao.getAllLootBoxes()


    override suspend fun purchaseItem(
        userId: Int,
        itemId: Int,
        amount: Int
    ) {
        val existing = userItemInventoryDao.getItem(userId, itemId)

        if (existing == null) {
            userItemInventoryDao.insert(
                User_item_inventory(
                    user_id = userId,
                    item_id = itemId,
                    amount = amount
                )
            )
        } else {
            userItemInventoryDao.updateAmount(
                userId,
                itemId,
                existing.amount!! + amount
            )
        }
    }


    override suspend fun openLootBox(
        userId: Int,
        lootBoxId: Int
    ) {
        // 🔮 Placeholder logic
        // Later you will:
        // 1. Roll rarity
        // 2. Pick item
        // 3. Add to inventory
        // 4. Remove lootbox

        lootBoxDao.decreaseAmount(userId, lootBoxId)
    }
}
