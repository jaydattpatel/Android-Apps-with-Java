package com.example.todoenhanced;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTask;
    private Button buttonAdd;
    private ListView listViewTasks;
    private ArrayList<String> tasks;
    private TaskAdapter adapter;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        listViewTasks = findViewById(R.id.listViewTasks);
        tasks = new ArrayList<>();
        adapter = new TaskAdapter(this, R.layout.list_item, tasks);

        listViewTasks.setAdapter(adapter);

        buttonAdd.setOnClickListener(v -> {
            String task = editTextTask.getText().toString();
            if (!task.isEmpty()) {
                tasks.add(task);
                adapter.notifyDataSetChanged(); // Refresh the ListView
                editTextTask.setText(""); // Clear the EditText
            }

        });
    }

}
