package com.example.foxynotes.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.foxynotes.database.Note_Normal;

import java.util.List;

@Dao
public interface Note_NormalDao {
    @Query("SELECT * FROM Note_Normal")
    List<Note_Normal> getAll();

    @Query("SELECT * FROM folder WHERE uuid IN (:note_normalUUIDs)")
    List<Note_Normal> loadAllByIds(int[] note_normalUUIDs);

    @Insert
    void insertAll(Note_Normal... normals);

    @Delete
    void delete(Note_Normal note_normal);
}
