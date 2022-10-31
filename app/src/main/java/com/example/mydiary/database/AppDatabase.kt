package com.example.mydiary.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [BlogEntity::class], version = 1)
 abstract class AppDatabase : RoomDatabase() {
    abstract fun blogDao(): BlogDao

    companion object {
        fun create(context: Context):AppDatabase {
                return Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "blog-database"
                ).build()
        }
    }
}
