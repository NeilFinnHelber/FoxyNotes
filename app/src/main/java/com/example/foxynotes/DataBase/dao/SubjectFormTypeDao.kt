package com.example.foxynotes.DataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.foxynotes.DataBase.Subject_form_type
import kotlinx.coroutines.flow.Flow


@Dao
interface SubjectFormTypeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubjectFormType(formType: Subject_form_type)

    @Query("SELECT * FROM subject_form_type")
    fun getAllFormTypes(): Flow<List<Subject_form_type>>
}