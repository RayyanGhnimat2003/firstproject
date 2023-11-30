package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Planes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planes);

        ImageView imageView = findViewById(R.id.imageView10);
        TextView detailTextView = findViewById(R.id.textView9);

        imageView.setImageResource(R.drawable.planes);

       // detailTextView.setText("Details about Yoga Item");
    }
}

