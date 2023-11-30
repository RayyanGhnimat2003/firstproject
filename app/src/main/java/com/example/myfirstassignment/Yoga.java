package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Yoga extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yoga);

        ImageView imageView = findViewById(R.id.imageView5);
        TextView detailTextView = findViewById(R.id.textView3);

        imageView.setImageResource(R.drawable.yoga2);

      //  detailTextView.setText("Details about Yoga Item");
    }
}

