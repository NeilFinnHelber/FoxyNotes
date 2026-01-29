package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.foxynotes.DataBase.User_item_inventory
import com.example.foxynotes.DataBase.User_lootbox_inventory
import com.example.foxynotes.DataBase.User_paw_print_inventory
import kotlinx.coroutines.flow.Flow

@Dao
interface UserInventoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserItem(userItem: User_item_inventory)

    @Update
    suspend fun updateUserItem(userItem: User_item_inventory)

    @Query("SELECT * FROM user_item_inventory WHERE user_id = :userId")
    fun getUserItems(userId: Int): Flow<List<User_item_inventory>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserLootBox(userLootBox: User_lootbox_inventory)

    @Query("SELECT * FROM user_lootbox_inventory WHERE user_id = :userId")
    fun getUserLootBoxes(userId: Int): Flow<List<User_lootbox_inventory>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserPawPrint(userPawPrint: User_paw_print_inventory)

    @Query("SELECT * FROM user_paw_print_inventory WHERE user_id = :userId")
    fun getUserPawPrints(userId: Int): Flow<List<User_paw_print_inventory>>
}
