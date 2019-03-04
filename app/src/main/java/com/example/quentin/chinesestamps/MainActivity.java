package com.example.quentin.chinesestamps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] strs = new String[28];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(2019 - i);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, strs);
        ListView list_test = findViewById(R.id.list_test);
        list_test.setAdapter(adapter);
    }

}
