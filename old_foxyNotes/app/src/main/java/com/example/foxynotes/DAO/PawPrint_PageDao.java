package com.example.foxynotes.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.foxynotes.database.PawPrint_Page;

import java.util.List;

@Dao
public interface PawPrint_PageDao {

        @Query("SELECT * FROM PawPrint_Page")
        List<PawPrint_Page> getAll();

        @Query("SELECT * FROM PawPrint_Page WHERE uuid IN (:pawPrint_pageUUIDs)")
        List<PawPrint_Page> loadAllByIds(int[] pawPrint_pageUUIDs);

        @Insert
        void insertAll(PawPrint_Page... pages);

        @Delete
        void delete(PawPrint_Page pawPrint_page);
    }

