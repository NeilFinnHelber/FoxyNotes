package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Timer
import kotlinx.coroutines.flow.Flow


@Dao
interface TimerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTimer(timer: Timer)

    @Query("SELECT * FROM timer")
    fun getAllTimers(): Flow<List<Timer>>
}