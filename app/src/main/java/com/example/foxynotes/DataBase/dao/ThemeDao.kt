package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Theme
import kotlinx.coroutines.flow.Flow

@Dao
interface ThemeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTheme(theme: Theme)

    @Query("SELECT * FROM theme")
    fun getAllThemes(): Flow<List<Theme>>
}