package com.example.foxynotes.database;

import static java.util.UUID.randomUUID;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity(
        tableName = "PawPrint_Page",
        foreignKeys = @ForeignKey(
        entity = Folder.class,
        parentColumns = "uuid",
        childColumns = "Note_PawPrintUUID",
        onDelete = ForeignKey.CASCADE
)
)
public class PawPrint_Page {
    @PrimaryKey
    @NonNull
    public UUID uuid;

    @ColumnInfo(name = "position") //ordered
    private int position;

    @ColumnInfo(name = "title")
    private String title;

    @NonNull
    @ColumnInfo(name = "created_Date")
    private Date created_Date;

    @ColumnInfo(name = "changed_Date")
    private Date changed_Date;

    @ColumnInfo(name = "pawColor")
    private String pawColor;

    @ColumnInfo(name = "tasks")
    private List<PawPrint_task> tasks;

    @ColumnInfo(name = "Note_PawPrintUUID")
    public UUID Note_PawPrintUUID;

    public PawPrint_Page(String title, Date created_Date, Date changed_Date, String pawColor, UUID Note_PawPrintUUID) {
        this.uuid = randomUUID();
        this.title = title;
        this.created_Date = created_Date;
        this.changed_Date = changed_Date;
        this.pawColor = pawColor;
        this.Note_PawPrintUUID = Note_PawPrintUUID;
    }
}
