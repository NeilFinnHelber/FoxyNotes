package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Daily_task_completion_chart
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyTaskCompletionChartDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChart(chart: Daily_task_completion_chart)

    @Query("SELECT * FROM daily_task_completion_chart WHERE user_id = :userId")
    fun getUserDailyCharts(userId: Int): Flow<List<Daily_task_completion_chart>>
}