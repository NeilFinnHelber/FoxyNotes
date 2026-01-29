package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Loot_box_rarity
import kotlinx.coroutines.flow.Flow

@Dao
interface LootBoxRarityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLootBoxRarity(rarity: Loot_box_rarity)

    @Query("SELECT * FROM loot_box_rarity")
    fun getAllLootBoxRarities(): Flow<List<Loot_box_rarity>>
}