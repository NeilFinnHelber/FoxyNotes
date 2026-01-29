package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Item
import com.example.foxynotes.DataBase.Loot_box
import kotlinx.coroutines.flow.Flow

@Dao
interface LootBoxDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLootBox(box: Loot_box)

    @Query("SELECT * FROM loot_box WHERE loot_box_id = :id")
    fun getLootBoxById(id: Int): Flow<Loot_box>

    @Query("SELECT * FROM loot_box ORDER BY loot_box_rarity_id ASC")
    fun getAllLootBoxes(): Flow<List<Loot_box>>

    @Query("""
    UPDATE user_lootbox_inventory
    SET amount = amount - 1
    WHERE user_id = :userId AND loot_box_id = :lootBoxId
""")
    suspend fun decreaseAmount(userId: Int, lootBoxId: Int)

}