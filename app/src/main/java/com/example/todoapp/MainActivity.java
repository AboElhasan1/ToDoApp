package com.example.todoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText etTask;
    private Button btnAddTask;
    private Button btnCompletedTasks;
    private RecyclerView recyclerViewTasks;

    public static ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTask = findViewById(R.id.etTask);
        btnAddTask = findViewById(R.id.btnAddTask);
        btnCompletedTasks = findViewById(R.id.btnCompletedTasks);
        recyclerViewTasks = findViewById(R.id.recyclerViewTasks);

        // Initialize the task list
        if (taskList == null) {
            taskList = new ArrayList<>();
        }

        // Set up RecyclerView
        taskAdapter = new TaskAdapter(taskList);
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);

        // Add task button listener
        btnAddTask.setOnClickListener(v -> {
            String taskName = etTask.getText().toString().trim();
            if (!taskName.isEmpty()) {
                taskList.add(new Task(taskName, false));
                taskAdapter.notifyDataSetChanged();
                etTask.setText(""); // Clear input
            }
        });

        // View completed tasks button listener
        btnCompletedTasks.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CompletedTasksActivity.class);
            startActivity(intent);
        });
    }
}
