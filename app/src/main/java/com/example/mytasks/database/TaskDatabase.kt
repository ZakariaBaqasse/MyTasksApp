package com.example.mytasks.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mytasks.dao.TaskDAO
import com.example.mytasks.dataClasses.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase:RoomDatabase() {
    abstract val taskDAO:TaskDAO
    companion object{
        @Volatile
        private var INSTANCE:TaskDatabase? = null
        fun getInstance(context: Context):TaskDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TaskDatabase::class.java,
                        "task_database"
                    ).build()
                    INSTANCE =instance
                }
                return instance
            }
        }
    }
}