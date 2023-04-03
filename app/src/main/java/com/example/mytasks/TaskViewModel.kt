package com.example.mytasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mytasks.dao.TaskDAO
import com.example.mytasks.dataClasses.Task
import kotlinx.coroutines.launch

class TaskViewModel(val dao: TaskDAO):ViewModel() {
    var taskName = ""
    val tasks = dao.getAll()
    private val _navigateToTask = MutableLiveData<Long?>()
    val navigateToTask:LiveData<Long?>
        get() = _navigateToTask

    fun addTask(){
        viewModelScope.launch {
            val task = Task()
            task.taskName = taskName
            dao.insert(task)
        }
    }

    fun onTaskClicked(taskId:Long){
        _navigateToTask.value = taskId
    }

    fun onTaskNavigated(){
        _navigateToTask.value = null
    }
}