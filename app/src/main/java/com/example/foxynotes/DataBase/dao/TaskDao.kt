package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.foxynotes.DataBase.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task ORDER BY task_title ASC")
    fun getTasksOrderedByTitle(): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY task_id DESC")
    fun getTasksOrderedById(): Flow<List<Task>>
}
