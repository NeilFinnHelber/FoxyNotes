package com.example.foxynotes.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.foxynotes.database.Note_PawPrint;

import java.util.List;

@Dao
public interface Note_PawPrintDao {
    @Query("SELECT * FROM Note_PawPrint")
    List<Note_PawPrint> getAll();

    @Query("SELECT * FROM Note_PawPrint WHERE uuid IN (:notePawPrintUUIDs)")
    List<Note_PawPrint> loadAllByIds(int[] notePawPrintUUIDs);

    @Insert
    void insertAll(Note_PawPrint... pawPrints);

    @Delete
    void delete(Note_PawPrint note_pawPrint);
}
