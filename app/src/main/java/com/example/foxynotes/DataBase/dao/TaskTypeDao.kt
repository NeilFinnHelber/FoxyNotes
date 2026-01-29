package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Task_type
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTaskType(taskType: Task_type)

    @Query("SELECT * FROM task_type")
    fun getAllTaskTypes(): Flow<List<Task_type>>
}