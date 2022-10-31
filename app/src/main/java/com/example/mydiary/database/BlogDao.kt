package com.example.mydiary.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BlogDao {
    @Query("SELECT * FROM blogentity")
    fun all(): Flow<List<BlogEntity>>

//    @Query("SELECT * FROM blogentity WHERE id = :id")
//    fun findById(id:Long): Flowable<BlogEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(blog: BlogEntity)
}