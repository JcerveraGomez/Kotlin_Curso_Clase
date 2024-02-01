package com.coki.kurso_kotlin_clase.databases.database



import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.coki.kurso_kotlin_clase.databases.daos.PersonasDao
import com.coki.kurso_kotlin_clase.databases.entities.Persona



@Database(entities = [Persona::class], version = 1)
@TypeConverters(TypesConverter::class) // Add this annotation
abstract class AppDatabase : RoomDatabase() {
    abstract fun PersonasDao(): PersonasDao

    // Implementación del patrón Singleton para la instancia de la base de datos
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "personas_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}