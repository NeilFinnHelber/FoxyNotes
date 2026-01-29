package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.foxynotes.DataBase.Paw_print_type
import com.example.foxynotes.DataBase.paw_print_type_with_items
import kotlinx.coroutines.flow.Flow

@Dao
interface PawPrintTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPawPrintType(pawPrintType: Paw_print_type)

    @Query("SELECT * FROM paw_print_type")
    fun getAllPawPrintTypes(): Flow<List<Paw_print_type>>

    @Transaction
    @Query("SELECT * FROM paw_print_type WHERE paw_print_type_id = :id")
    fun getPawPrintTypeWithItems(id: Int): Flow<paw_print_type_with_items>
}
