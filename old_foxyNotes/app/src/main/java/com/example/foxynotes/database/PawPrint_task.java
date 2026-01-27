package com.example.foxynotes.database;

import static java.util.UUID.randomUUID;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.sql.Date;
import java.util.Map;
import java.util.UUID;

@Entity(
        tableName = "PawPrint_task",
        foreignKeys = @ForeignKey(
                entity = Folder.class,
                parentColumns = "uuid",
                childColumns = "PawPrint_PageUUID",
                onDelete = ForeignKey.CASCADE
        )
)
public class PawPrint_task {
    @PrimaryKey
    @NonNull
    public UUID uuid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "hours")
    public int hours;

    @ColumnInfo(name = "additional_description")
    public String additional_description;

    @NonNull
    @ColumnInfo(name = "created_Date")
    public Date created_Date;

    @ColumnInfo(name = "completed_Date")
    public Date completed_Date;

    @ColumnInfo(name = "position") //ordered
    public int position;

    @ColumnInfo(name = "paws_awarded")
    public Map<String, Integer> paws_awarded;

    @ColumnInfo(name = "checked")
    public char checked;

    @ColumnInfo(name = "PawPrint_PageUUID")
    public UUID PawPrint_PageUUID;


    public PawPrint_task(String title, String description, int hours, String additional_description, Date created_Date, Date completed_Date, int position, Map<String, Integer> paws_awarded, char checked, UUID PawPrint_PageUUID) {
        this.uuid = randomUUID();
        this.title = title;
        this.description = description;
        this.hours = hours;
        this.additional_description = additional_description;
        this.created_Date = created_Date;
        this.completed_Date = completed_Date;
        this.position = position;
        this.paws_awarded = paws_awarded;
        this.checked = checked;
        this.PawPrint_PageUUID = PawPrint_PageUUID;
    }
}
