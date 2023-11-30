package com.example.myfirstassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class morningTasksActivity extends AppCompatActivity {
    private EditText newTaskEditText;
    private ArrayAdapter<Tasks> listAdapter;
    private List<Tasks> tasksList;

    private static final String PREF_KEY_TASKS = "tasks";
    private SharedPreferences preferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning_tasks);

        newTaskEditText = findViewById(R.id.editText);
        tasksList = new ArrayList<>();

        // Initialize Gson and SharedPreferences
        gson = new Gson();
        preferences = getPreferences(Context.MODE_PRIVATE);

        // Load tasks from SharedPreferences
        loadTasksFromPreferences();

        listAdapter = new ArrayAdapter<>(this, R.layout.listitem, tasksList);
        ListView listView = findViewById(R.id.List_morning);
        listView.setAdapter(listAdapter);

        // Add initial items to the list if it's empty
        if (tasksList.isEmpty()) {
            tasksList.addAll(Arrays.asList(
                    new Tasks("Eat breakfast", false),
                    new Tasks("Do yoga", false),
                    new Tasks("Drink coffee", false),
                    new Tasks("Study Lectures", false)
            ));
            saveTasksToPreferences(); // Save initial items to SharedPreferences
        }

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

                    // Check if the clicked task is "Eat breakfast"
                    if (task.getTaskName().equals("Eat breakfast")) {
                        // Log message for debugging
                        Log.d("morningTasksActivity", "Opening DetailActivity for 'Eat breakfast'");

                        // Open DetailActivity
                        openDetailActivity();
                    } else if (task.getTaskName().equals("Do yoga")) {
                        openDetailActivity2();
                    } else if (task.getTaskName().equals("Drink coffee")) {
                        openDetailActivity3();
                    } else if (task.getTaskName().equals("Study Lectures")) {
                        openDetailActivity4();
                    }

                    viewDoneTasks();
                }
            }
        };
        listView.setOnItemClickListener(itemClickListener);
    }

    private void openDetailActivity() {
        Intent intent = new Intent(this, Breakfast.class);
        // Add any necessary data to the intent for DetailActivity
        startActivity(intent);
    }

    private void openDetailActivity3() {
        Intent intent = new Intent(this, Coffee.class);
        // Add any necessary data to the intent for DetailActivity
        startActivity(intent);
    }

    private void openDetailActivity4() {
        Intent intent = new Intent(this, lectures.class);
        // Add any necessary data to the intent for DetailActivity
        startActivity(intent);
    }

    private void openDetailActivity2() {
        Intent intent = new Intent(this, Yoga.class);
        // Add any necessary data to the intent for DetailActivity
        startActivity(intent);
    }

    private boolean isDuplicate(String task) {
        for (Tasks taskItem : tasksList) {
            if (taskItem.getTaskName().equalsIgnoreCase(task)) {
                return true;
            }
        }
        return false;
    }

    public void morningButton(View view) {
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

    // Method to remove a task by its name
    private void removeTaskByName(String taskName) {
        for (Tasks task : tasksList) {
            if (task.getTaskName().equalsIgnoreCase(taskName)) {
                tasksList.remove(task);
                saveTasksToPreferences(); // Save after removing the task
                return; // Exit the loop after removing the task
            }
        }
    }

    // Method to add a new item to the list
    private void addNewItem(Tasks newItem) {
        tasksList.add(newItem);
        saveTasksToPreferences(); // Save after adding the task
        listAdapter.notifyDataSetChanged();
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

    private void loadTasksFromPreferences() {
        String tasksJson = preferences.getString(PREF_KEY_TASKS, "");
        Type type = new TypeToken<List<Tasks>>() {}.getType();
        tasksList = gson.fromJson(tasksJson, type);

        if (tasksList == null) {
            tasksList = new ArrayList<>();
        }
    }

    private void saveTasksToPreferences() {
        String tasksJson = gson.toJson(tasksList);
        preferences.edit().putString(PREF_KEY_TASKS, tasksJson).apply();
    }
}
