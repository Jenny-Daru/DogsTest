package com.example.dogs;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewAdapter = new ListViewAdapter();

        listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(listViewAdapter);

        listViewAdapter.addItem(R.drawable.dog1,"멍뭉이1");
        listViewAdapter.addItem(R.drawable.dog2,"멍뭉이2");
    }

}
