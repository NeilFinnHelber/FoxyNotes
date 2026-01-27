package com.example.foxynotes.database;

import static java.util.UUID.*;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.UUID;

@Entity(
        tableName = "Note_Normal",
        foreignKeys = @ForeignKey(
                entity = Folder.class,
                parentColumns = "uuid",
                childColumns = "folderUUID",
                onDelete = ForeignKey.CASCADE
        )
)
public class Note_Normal {

    @PrimaryKey
    @NonNull
    public UUID uuid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "text")
    public String text;

    @NonNull
    @ColumnInfo(name = "created_Date")
    private Date created_Date;

    @ColumnInfo(name = "changed_Date")
    private Date changed_Date;

    @ColumnInfo(name = "position")  //ordered position
    private int position;

    @ColumnInfo(name = "folderUUID")
    public UUID folderUUID;

    public Note_Normal(String title, String text, Date created_Date, Date changed_Date, int position, UUID folderUUID) {
        this.uuid = randomUUID();
        this.title = title;
        this.text = text;
        this.created_Date = created_Date;
        this.changed_Date = changed_Date;
        this.position = position;
        this.folderUUID = folderUUID;
    }
}
