package com.example.myfirstassignment;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class Software extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.software);

        ImageView imageView = findViewById(R.id.imageView13);
        TextView detailTextView = findViewById(R.id.textView10);

        imageView.setImageResource(R.drawable.software);

        //  detailTextView.setText("Details about Yoga Item");
    }
}

