package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.User_item_inventory

@Dao
interface UserItemInventoryDao {

    @Query("""
        SELECT * FROM user_item_inventory
        WHERE user_id = :userId AND item_id = :itemId
    """)
    suspend fun getItem(userId: Int, itemId: Int): User_item_inventory?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: User_item_inventory)

    @Query("""
        UPDATE user_item_inventory
        SET amount = :amount
        WHERE user_id = :userId AND item_id = :itemId
    """)
    suspend fun updateAmount(userId: Int, itemId: Int, amount: Int)
}
