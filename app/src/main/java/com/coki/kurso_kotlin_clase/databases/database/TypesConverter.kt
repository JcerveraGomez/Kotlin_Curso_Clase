package com.coki.kurso_kotlin_clase.databases.database

import androidx.room.TypeConverter
import java.util.Date

class TypesConverter {
    @TypeConverter
    fun toDate(timestamp: Long?): Date? {
        return timestamp?.let { Date(it) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?): Long? {
        return date?.time
    }
}