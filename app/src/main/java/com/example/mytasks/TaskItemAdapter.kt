package com.example.mytasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytasks.dataClasses.Task
import androidx.recyclerview.widget.ListAdapter
import com.example.mytasks.databinding.TaskItemBinding

class TaskItemAdapter(val clickListener:(taskId:Long)->Unit): ListAdapter<Task,TaskItemAdapter.TaskItemViewHolder>(TaskDiffItemCallBack()) {

    override fun onBindViewHolder(holder: TaskItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskItemViewHolder = TaskItemViewHolder.InflateFrom(parent)

    class TaskItemViewHolder(val binding: TaskItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:Task,clickListener:(taskId:Long)->Unit){
            binding.task = item
            binding.root.setOnClickListener { clickListener(item.taskId) }
        }
        companion object{
            fun InflateFrom(parent: ViewGroup):TaskItemViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TaskItemBinding.inflate(layoutInflater,parent,false)
                return TaskItemViewHolder(binding)
            }
        }
    }
}