package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Item_rarity
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemRarityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItemRarity(itemRarity: Item_rarity)

    @Query("SELECT * FROM item_rarity")
    fun getAllRarities(): Flow<List<Item_rarity>>
}