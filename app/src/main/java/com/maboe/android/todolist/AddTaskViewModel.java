package com.maboe.android.todolist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.maboe.android.todolist.database.AppDatabase;
import com.maboe.android.todolist.database.TaskEntry;

public class AddTaskViewModel extends ViewModel {

    private LiveData<TaskEntry> task;

    public LiveData<TaskEntry> getTask() {
        return task;
    }

    public AddTaskViewModel(AppDatabase database, int taskId) {
        task = database.taskDao().loadTaskById(taskId);
    }
}
