package com.example.foxynotes.DataBase.dao

import androidx.room.*
import com.example.foxynotes.DataBase.User_profile
import kotlinx.coroutines.flow.Flow

@Dao
interface UserProfileDao {

    @Query("SELECT * FROM user_profile LIMIT 1")
    fun getUser(): Flow<User_profile?>

    @Update
    suspend fun updateUser(user: User_profile)
}


