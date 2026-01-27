package com.example.foxynotes.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.sql.Time;
import java.util.UUID;

@Entity(tableName = "User")
public class User {

    @ColumnInfo(name = "colormode")
    public String colormode;

    @ColumnInfo(name = "sleeptime")
    public Time sleeptime;
}
