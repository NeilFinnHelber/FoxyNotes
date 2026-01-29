package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.foxynotes.DataBase.Paw_print_type_has_item_cross_ref

@Dao
interface PawPrintTypeItemCrossRefDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCrossRef(crossRef: Paw_print_type_has_item_cross_ref)
}