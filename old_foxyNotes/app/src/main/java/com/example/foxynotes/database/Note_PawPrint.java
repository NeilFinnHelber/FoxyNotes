package com.example.foxynotes.database;

import static java.util.UUID.randomUUID;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Entity(
        tableName = "Note_PawPrint",
        foreignKeys = @ForeignKey(
        entity = Folder.class,
        parentColumns = "uuid",
        childColumns = "folderUUID",
        onDelete = ForeignKey.CASCADE
       )
)
public class Note_PawPrint {

    @PrimaryKey
    @NonNull
    public UUID uuid;

    @ColumnInfo(name = "position") //ordered
    public int position;

    @ColumnInfo(name = "title")
    public String title;

    @NonNull
    @ColumnInfo(name = "created_Date")
    private Date created_Date;

    @ColumnInfo(name = "changed_Date")
    private Date changed_Date;

    @ColumnInfo(name = "daily_PawPrints")
    public Map<String, Integer> daily_PawPrints;

    @ColumnInfo(name = "holidays")
    public List<Date> holidays;

    @ColumnInfo(name = "folderUUID")
    public UUID folderUUID;

    public Note_PawPrint(int position, String title, Date created_Date, Date changed_Date, Map<String, Integer> daily_PawPrints, List<Date> holidays, UUID folderUUID) {
        this.uuid = randomUUID();
        this.position = position;
        this.title = title;
        this.created_Date = created_Date;
        this.changed_Date = changed_Date;
        this.daily_PawPrints = daily_PawPrints;
        this.holidays = holidays;
        this.folderUUID = folderUUID;
    }
}
