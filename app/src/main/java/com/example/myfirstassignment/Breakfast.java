package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Breakfast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakfast);

        ImageView imageView = findViewById(R.id.imageView6);
        TextView detailTextView = findViewById(R.id.textView2);

        // Load the image (replace R.drawable.your_image_resource with your actual resource)
        imageView.setImageResource(R.drawable.rayanbreakfast);

        // Set the text (replace "Details about Breakfast Item" with your actual details)
       // detailTextView.setText("Details about Breakfast Item");
    }
}

