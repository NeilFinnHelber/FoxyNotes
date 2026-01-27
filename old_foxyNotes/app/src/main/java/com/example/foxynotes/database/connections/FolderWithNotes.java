package com.example.foxynotes.database.connections;


import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.foxynotes.database.Folder;
import com.example.foxynotes.database.Note_Normal;
import com.example.foxynotes.database.Note_PawPrint;

import java.util.List;

public class FolderWithNotes {
    @Embedded
    public Folder folder;

    @Relation(
            parentColumn = "uuid",
            entityColumn = "folderUUID",
            entity = Note_Normal.class
    )
    public List<Note_Normal> normalNotes;

    @Relation(
            parentColumn = "uuid",
            entityColumn = "folderUUID",
            entity = Note_PawPrint.class
    )
    public List<Note_PawPrint> pawPrintNotes;
}
