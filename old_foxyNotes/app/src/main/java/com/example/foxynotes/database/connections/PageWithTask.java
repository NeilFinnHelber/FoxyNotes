package com.example.foxynotes.database.connections;

import androidx.room.Embedded;
import androidx.room.Relation;


import com.example.foxynotes.database.PawPrint_Page;
import com.example.foxynotes.database.PawPrint_task;

import java.util.List;

public class PageWithTask {
    @Embedded
    public PawPrint_Page pawPrint_Page;

    @Relation(
            parentColumn = "uuid",
            entityColumn = "PawPrint_PageUUID",
            entity = PawPrint_Page.class
    )
    public List<PawPrint_task> pawPrintTasks;

}
