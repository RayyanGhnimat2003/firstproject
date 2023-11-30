package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Book extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book);

        ImageView imageView = findViewById(R.id.imageView7);
        TextView detailTextView = findViewById(R.id.textView6);

        imageView.setImageResource(R.drawable.books);

       // detailTextView.setText("Coffee's caffeine content can enhance alertness, boost physical performance, improve mood, and support cognitive function. While excessive caffeine can cause adverse effects, moderate coffee consumption offers a multitude of benefits.");
    }
}

