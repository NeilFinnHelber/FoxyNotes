package com.example.foxynotes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.foxynotes.DAO.FolderDao;
import com.example.foxynotes.DAO.Note_NormalDao;
import com.example.foxynotes.DAO.Note_PawPrintDao;
import com.example.foxynotes.DAO.PawPrint_PageDao;
import com.example.foxynotes.DAO.PawPrint_taskDao;
import com.example.foxynotes.DAO.UserDao;
import com.example.foxynotes.database.Folder;
import com.example.foxynotes.database.Note_Normal;
import com.example.foxynotes.database.Note_PawPrint;
import com.example.foxynotes.database.PawPrint_Page;
import com.example.foxynotes.database.PawPrint_task;
import com.example.foxynotes.database.User;

@Database(entities = {Folder.class, Note_Normal.class, Note_PawPrint.class, PawPrint_Page.class, PawPrint_task.class, User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract FolderDao folderDao();
    public abstract Note_NormalDao note_normalDao();
    public abstract Note_PawPrintDao note_pawPrintDao();
    public abstract PawPrint_PageDao pawPrint_pageDao();
    public abstract PawPrint_taskDao pawPrint_taskDao();
}
