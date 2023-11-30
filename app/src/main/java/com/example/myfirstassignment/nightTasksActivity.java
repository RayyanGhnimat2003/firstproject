package com.example.myfirstassignment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nightTasksActivity extends AppCompatActivity {
    private EditText newTaskEditText;
    private ArrayAdapter<Tasks> listAdapter;
    private List<Tasks> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_night_tasks);

        newTaskEditText = findViewById(R.id.editText);
        tasksList = new ArrayList<>();

        listAdapter = new ArrayAdapter<>(this, R.layout.listitem, tasksList);

        // Add initial items to the list
        tasksList.addAll(Arrays.asList(
                new Tasks("Read a book", false),
                new Tasks("Plan for tomorrow", false),
                new Tasks("Coding", false)

                ));

        ListView listView = findViewById(R.id.List_night);
        listView.setAdapter(listAdapter);

        Button deleteButton = findViewById(R.id.button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonAction();
            }
        });

        AdapterView.OnItemClickListener itemClickListener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tasks task = listAdapter.getItem(position);
                if (task != null) {
                    task.setStatues(!task.isStatues());
                    listAdapter.notifyDataSetChanged();

                    if (task.getTaskName().equals("Read a book")) {
                        // Log message for debugging
                        Log.d("morningTasksActivity", "Opening DetailActivity for 'Eat breakfast'");

                        // Open DetailActivity
                        openDetailActivity();}

                    else if (task.getTaskName().equals("Plan for tomorrow")) {
                        openDetailActivity2();
                    }
                    else if (task.getTaskName().equals("Coding")) {
                        openDetailActivity3();
                    }





                    viewDoneTasks();
                }
            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }
    private void openDetailActivity() {
        Intent intent = new Intent(this, Book.class);
        // Add any necessary data to the intent for DetailActivity
        startActivity(intent);
    }
    private void openDetailActivity2() {
        Intent intent = new Intent(this, Planes.class);
        // Add any necessary data to the intent for DetailActivity
        startActivity(intent);
    }
    private void openDetailActivity3() {
        Intent intent = new Intent(this, Coding.class);
        // Add any necessary data to the intent for DetailActivity
        startActivity(intent);
    }
    public void nightButton(View view) {
        String newTaskName = newTaskEditText.getText().toString().trim();

        if (!newTaskName.isEmpty()) {
            if (!isDuplicate(newTaskName)) {
                addNewItem(new Tasks(newTaskName, false));
                // Clear the EditText after adding the task
                newTaskEditText.getText().clear();
                listAdapter.notifyDataSetChanged(); // Notify adapter of the data set change
            } else {
                Toast.makeText(this, "Task already exists: " + newTaskName, Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter a task.", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleButtonAction() {
        String taskInput = newTaskEditText.getText().toString().trim();

        if (!taskInput.isEmpty()) {
            if (isDuplicate(taskInput)) {
                // Delete the task if it exists
                removeTaskByName(taskInput);
                listAdapter.notifyDataSetChanged();
                Toast.makeText(this, "Task deleted: " + taskInput, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Task not found: " + taskInput, Toast.LENGTH_SHORT).show();
            }

            // Clear the EditText after the operation
            newTaskEditText.getText().clear();
            viewDoneTasks(); // Call method to view done tasks
        } else {
            Toast.makeText(this, "Please enter a task.", Toast.LENGTH_SHORT).show();
        }
    }
    private void addNewItem(Tasks newItem) {
        tasksList.add(newItem);
        listAdapter.notifyDataSetChanged();
    }

    private boolean isDuplicate(String task) {
        for (Tasks taskItem : tasksList) {
            if (taskItem.getTaskName().equalsIgnoreCase(task)) {
                return true;
            }
        }
        return false;
    }

    public void printButton(View view) {
        viewDoneTasks(); // Call method to view done tasks
    }

    private void viewDoneTasks() {
        StringBuilder doneTasks = new StringBuilder("Done Tasks:\n");

        for (Tasks taskItem : tasksList) {
            if (taskItem.isStatues()) {
                doneTasks.append(taskItem.getTaskName()).append("\n");
            }
        }

        Toast.makeText(this, doneTasks.toString(), Toast.LENGTH_LONG).show();
    }
    private void removeTaskByName(String taskName) {
        for (Tasks task : tasksList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                tasksList.remove(task);
                return; // Exit the loop after removing the task
            }
        }}
}