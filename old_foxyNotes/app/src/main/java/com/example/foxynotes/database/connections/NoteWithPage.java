package com.example.foxynotes.database.connections;

import androidx.room.Embedded;
import androidx.room.Relation;


import com.example.foxynotes.database.Note_PawPrint;
import com.example.foxynotes.database.PawPrint_Page;

import java.util.List;

public class NoteWithPage {
    @Embedded
    public Note_PawPrint note_pawPrint;

    @Relation(
            parentColumn = "uuid",
            entityColumn = "Note_PawPrintUUID",
            entity = PawPrint_Page.class
    )
    public List<PawPrint_Page> pawPrintPages;

}