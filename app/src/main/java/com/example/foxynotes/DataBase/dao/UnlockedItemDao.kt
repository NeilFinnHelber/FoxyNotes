package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Unlocked_item
import kotlinx.coroutines.flow.Flow

@Dao
interface UnlockedItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUnlockedItem(unlockedItem: Unlocked_item)

    @Query("SELECT * FROM unlocked_item WHERE user_id = :userId")
    fun getUnlockedItems(userId: Int): Flow<List<Unlocked_item>>
}