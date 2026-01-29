package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Task_prerequisite_for_appearance_of_task
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskPrerequisiteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrerequisite(prerequisite: Task_prerequisite_for_appearance_of_task)

    @Query("SELECT * FROM task_prerequisite_for_appearance_of_task WHERE child_task_id = :taskId")
    fun getPrerequisitesForTask(taskId: Int): Flow<List<Task_prerequisite_for_appearance_of_task>>
}