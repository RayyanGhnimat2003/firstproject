package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Python extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.python);

        ImageView imageView = findViewById(R.id.imageView14);
        TextView detailTextView = findViewById(R.id.textView8);

        imageView.setImageResource(R.drawable.python);

        //  detailTextView.setText("Details about Yoga Item");
    }
}

