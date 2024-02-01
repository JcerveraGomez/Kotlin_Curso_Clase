package com.coki.kurso_kotlin_clase.databases.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date
import java.util.UUID

@Entity(tableName = "personas")
data class Persona(
    @PrimaryKey
    @ColumnInfo(name = "uuid") val uuid: String = UUID.randomUUID().toString(),

    @ColumnInfo(name = "nombre") var nombre: String? = "",
    @ColumnInfo(name = "sexo") var sexo: String? = "",
    @ColumnInfo(name = "fecha_nacimiento") val fechaNacimiento: Date? = Date(10 / 10 / 10),
    @ColumnInfo(name = "mail") var mail: String? = "",
    @ColumnInfo(name = "timestamp") val timestamp: Long = System.currentTimeMillis()



)