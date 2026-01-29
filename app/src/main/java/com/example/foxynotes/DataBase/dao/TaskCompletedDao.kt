package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Task_completed
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskCompletedDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompletedTask(task: Task_completed)

    @Query("SELECT * FROM task_completed WHERE task_id = :taskId")
    fun getCompletedTasksForTask(taskId: Int): Flow<List<Task_completed>>
}
