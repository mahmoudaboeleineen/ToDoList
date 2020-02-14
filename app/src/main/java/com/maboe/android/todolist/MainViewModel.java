package com.maboe.android.todolist;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.maboe.android.todolist.database.AppDatabase;
import com.maboe.android.todolist.database.TaskEntry;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase databse = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Retriving DataBase .....");
        tasks = databse.taskDao().loadAllTasks();
    }
}
