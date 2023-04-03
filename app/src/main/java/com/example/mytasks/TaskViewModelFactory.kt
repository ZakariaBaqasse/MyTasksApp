package com.example.mytasks

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mytasks.dao.TaskDAO

class TaskViewModelFactory(private val taskDAO: TaskDAO):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TaskViewModel::class.java)){
            return TaskViewModel(taskDAO) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}