package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Coffee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cofee);

        ImageView imageView = findViewById(R.id.imageView8);
        TextView detailTextView = findViewById(R.id.textView5);

        imageView.setImageResource(R.drawable.cofeee2);

        detailTextView.setText("Coffee's caffeine content can enhance alertness, boost physical performance, improve mood, and support cognitive function. While excessive caffeine can cause adverse effects, moderate coffee consumption offers a multitude of benefits.");
    }
}

