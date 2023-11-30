package com.example.myfirstassignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class lectures extends AppCompatActivity {

    private ListView lecturesListView;
    private ArrayAdapter<String> adapterLecture;
    private ArrayList<String> lectureList;
    private EditText newLectureEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lectures);

        lecturesListView = findViewById(R.id.Lectures);
        newLectureEditText = findViewById(R.id.editTextNewLecture);

        // Initialize lecture list
        lectureList = new ArrayList<>();
        lectureList.add("Android");
        lectureList.add("Java");
        lectureList.add("Python");

        // Set up the adapter
        adapterLecture = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lectureList);
        lecturesListView.setAdapter(adapterLecture);

        lecturesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected item
                String selectedLecture = lectureList.get(position);

                // Example: Navigate to another activity
                if (selectedLecture.equals("Android")) {
                    Intent intent = new Intent(lectures.this, Android.class);
                    startActivity(intent);
                }
                else if (selectedLecture.equals("Java")) {
                    Intent intent = new Intent(lectures.this, Java.class);
                    startActivity(intent);
                }
                else if (selectedLecture.equals("Python")) {
                    Intent intent = new Intent(lectures.this, Python.class);
                    startActivity(intent);
                }

                // You can add similar conditions for other lectures if needed
            }
        });

    }


    public void addButton(View view) {
        String newLecture = newLectureEditText.getText().toString().trim();

        if (!newLecture.isEmpty()) {
            String lowerCaseNewLecture = newLecture.toLowerCase();

            // Check if the lecture already exists (case-insensitive)
            if (!containsIgnoreCase(lectureList, lowerCaseNewLecture)) {
                // Lecture does not exist, add it to the list
                lectureList.add(newLecture);
                adapterLecture.notifyDataSetChanged();
                newLectureEditText.getText().clear(); // Clear the EditText after adding the lecture
                Toast.makeText(this, "Added: " + newLecture, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Lecture already exists.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter a lecture.", Toast.LENGTH_SHORT).show();
        }
    }

    // Helper method to check if a list contains a given string (ignoring case)


    public void deleteButton(View view) {
        String deleteLecture = newLectureEditText.getText().toString().trim();

        if (!deleteLecture.isEmpty()) {
            String lowerCaseDeleteLecture = deleteLecture.toLowerCase();

            // Check if the entered lecture exists in the list (case-insensitive)
            int index = indexOfIgnoreCase(lectureList, lowerCaseDeleteLecture);

            if (index != -1) {
                // Lecture exists, remove it from the list
                lectureList.remove(index);
                adapterLecture.notifyDataSetChanged();
                newLectureEditText.getText().clear(); // Clear the EditText after deleting the lecture
                Toast.makeText(this, "Deleted: " + deleteLecture, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Lecture not found.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please enter a lecture to delete.", Toast.LENGTH_SHORT).show();
        }
    }
    private int indexOfIgnoreCase(ArrayList<String> list, String str) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1; // Return -1 if the string is not found in the list
    }

    // Helper method to check if a list contains a given string (ignoring case)
    private boolean containsIgnoreCase(ArrayList<String> list, String str) {
        for (String item : list) {
            if (item.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }


    public void printButton(View view) {
        // Your existing code for printing lectures
    }
}
