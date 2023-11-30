package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Java extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java);

        ImageView imageView = findViewById(R.id.imageView15);
        TextView detailTextView = findViewById(R.id.textView12);

        imageView.setImageResource(R.drawable.java);

        //  detailTextView.setText("Details about Yoga Item");
    }
}

