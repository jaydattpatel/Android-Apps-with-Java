package com.example.todoenhanced;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<String> {

    private ArrayList<String> tasks;
    private Activity context;

    // Constructor to initialize the adapter
    public TaskAdapter(Activity context, ArrayList<String> tasks) {
        super(context, R.layout.list_item, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the list item view
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        // Get the task and set it to the TextView
        String task = tasks.get(position);
        TextView textViewTask = convertView.findViewById(R.id.textViewTask);
        textViewTask.setText(task);

        // Set the Delete button functionality
        Button buttonDelete = convertView.findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tasks.remove(position);  // Remove the task from the list
                notifyDataSetChanged();  // Notify adapter to refresh the list
                Toast.makeText(context, "Task deleted", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
