package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.foxynotes.DataBase.Item
import com.example.foxynotes.DataBase.ItemWithAmount
import com.example.foxynotes.DataBase.item_with_paw_print_types
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Query("SELECT * FROM item ORDER BY item_rarity_id ASC")
    fun getAllItems(): Flow<List<Item>>

    @Query("SELECT * FROM item WHERE item_id = :id")
    suspend fun getItemById(id: Int): Item?


    @Query("""
        SELECT item.*, user_item_inventory.amount 
        FROM item
        INNER JOIN user_item_inventory
        ON item.item_id = user_item_inventory.item_id
        WHERE user_item_inventory.user_id = :userId
    """)
    fun getUserItems(userId: Int): Flow<List<ItemWithAmount>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)
}
