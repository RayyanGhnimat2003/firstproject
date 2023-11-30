package com.example.myfirstassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
public class MainActivity extends AppCompatActivity {
 //SharedPreferences preference = PreferenceManager.getDefaultSharedPreferences(this);
 //SharedPreferences.Editor editor = preference.edit();@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<Tasks> listAdapter = new ArrayAdapter<Tasks>(this,
                android.R.layout.simple_list_item_1,
                Tasks.tasks);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view,
                                    int position,
                                    long id) {
                if(position == 0){
                    Intent intent = new Intent(MainActivity.this,morningTasksActivity .class);
                    startActivity(intent);
                }
                   else  if(position == 1){
                        Intent intent = new Intent(MainActivity.this,nightTasksActivity .class);
                        startActivity(intent);
                    }
            }
        };
        ListView listView = (ListView)findViewById(R.id.tasks_list);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(itemClickListener);


    }
}



