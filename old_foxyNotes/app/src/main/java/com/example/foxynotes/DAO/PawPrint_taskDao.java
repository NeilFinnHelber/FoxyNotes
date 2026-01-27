package com.example.foxynotes.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.foxynotes.database.PawPrint_task;

import java.util.List;

@Dao
public interface PawPrint_taskDao {

        @Query("SELECT * FROM PawPrint_task")
        List<PawPrint_task> getAll();

        @Query("SELECT * FROM PawPrint_task WHERE uuid IN (:pawPrint_taskUUIDs)")
        List<PawPrint_task> loadAllByIds(int[] pawPrint_taskUUIDs);

        @Insert
        void insertAll(PawPrint_task... tasks);

        @Delete
        void delete(PawPrint_task pawPrint_task);
    }

