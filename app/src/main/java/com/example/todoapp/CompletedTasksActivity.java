package com.example.todoapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class CompletedTasksActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCompleted;
    private TaskAdapter taskAdapter;
    private ArrayList<Task> completedTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_tasks);

        recyclerViewCompleted = findViewById(R.id.recyclerViewCompleted);

        // Ensure MainActivity.taskList is not null
        if (MainActivity.taskList == null) {
            MainActivity.taskList = new ArrayList<>();
        }

        // Filter completed tasks
        completedTasks = new ArrayList<>();
        for (Task task : MainActivity.taskList) {
            if (task.isCompleted()) {
                completedTasks.add(task);
            }
        }

        // Set up RecyclerView for completed tasks
        taskAdapter = new TaskAdapter(completedTasks);
        recyclerViewCompleted.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCompleted.setAdapter(taskAdapter);
    }
}
