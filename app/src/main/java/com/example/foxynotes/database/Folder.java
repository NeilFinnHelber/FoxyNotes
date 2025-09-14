package com.example.foxynotes.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity(tableName = "Folder")
public class Folder {

    @PrimaryKey
    @NonNull
    public UUID uuid;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "created_Date")
    private Date created_Date;

    @ColumnInfo(name = "changed_Date")
    private Date changed_Date;

    @ColumnInfo(name = "position") //make ordered
    private int position;

    public Folder(String name, Date created_Date, Date changed_Date, int position) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.created_Date = created_Date;
        this.changed_Date = changed_Date;
        this.position = position;
    }
}
