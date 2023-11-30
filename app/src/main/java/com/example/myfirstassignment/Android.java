package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Android extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android);

        ImageView imageView = findViewById(R.id.imageView12);
        TextView detailTextView = findViewById(R.id.textView8);

        imageView.setImageResource(R.drawable.android);

        //  detailTextView.setText("Details about Yoga Item");
    }
}

