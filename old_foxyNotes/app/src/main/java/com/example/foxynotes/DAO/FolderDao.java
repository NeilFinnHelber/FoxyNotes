package com.example.foxynotes.DAO;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.foxynotes.database.Folder;

import java.util.List;

@Dao
public interface FolderDao {
    @Query("SELECT * FROM folder")
    List<Folder> getAll();

    @Query("SELECT * FROM folder WHERE uuid IN (:folderUUIDs)")
    List<Folder> loadAllByIds(int[] folderUUIDs);

    @Insert
    void insertAll(Folder... folders);

    @Delete
    void delete(Folder folder);
}
