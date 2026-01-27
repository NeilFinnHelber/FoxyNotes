package com.example.foxynotes.DataBase.converters

import androidx.room.TypeConverter
import java.time.Duration
import java.time.LocalDate
import java.time.LocalTime

class AppTypeConverters {
    //for localDateTime 1.jan.2026 13:00
    @TypeConverter
    fun durationToSeconds(duration: Duration?): Long? =
        duration?.seconds

    @TypeConverter
    fun secondsToDuration(seconds: Long?): Duration? =
        seconds?.let { Duration.ofSeconds(it) }



    //time converters 15:00
    @TypeConverter
    fun localTimeToString(time: LocalTime?): String? =
        time?.toString()   // "15:00"

    @TypeConverter
    fun stringToLocalTime(value: String?): LocalTime? =
        value?.let { LocalTime.parse(it) }


    //localdate 2026-01.08
    @TypeConverter
    fun localDateToString(date: LocalDate?): String? =
        date?.toString()   // "2025-01-16"

    @TypeConverter
    fun stringToLocalDate(value: String?): LocalDate? =
        value?.let { LocalDate.parse(it) }

}
