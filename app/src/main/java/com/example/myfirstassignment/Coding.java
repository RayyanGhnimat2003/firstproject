package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Coding extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coding);

        ImageView imageView = findViewById(R.id.imageView9);
        TextView detailTextView = findViewById(R.id.textView7);

        imageView.setImageResource(R.drawable.codes);

     //   detailTextView.setText("Details about Yoga Item");
    }
}

