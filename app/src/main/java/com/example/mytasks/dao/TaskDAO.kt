package com.example.mytasks.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mytasks.dataClasses.Task

@Dao
interface TaskDAO {
    @Insert
    suspend fun insert(task:Task)

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun delete(task: Task)

    @Query("SELECT * FROM task_table where taskId = :taskId")
    fun get(taskId: Long):LiveData<Task>

    @Query("SELECT * FROM task_table ORDER BY taskId desc")
    fun getAll():LiveData<List<Task>>
}