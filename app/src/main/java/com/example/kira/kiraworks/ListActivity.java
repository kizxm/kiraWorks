package com.example.kira.kiraworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {
    private TextView mNumberTextView;
    private ListView mListView;
    private String[] shows = new String[] {"title1", "title2", "title3", "title4", "title5", "title6",
                                           "title7", "title8", "title9", "title10", "title11", "title12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mListView = (ListView) findViewById(R.id.listView);
        mNumberTextView = (TextView) findViewById(R.id.numberTextView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shows);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String show = ((TextView)view).getText().toString();
                Toast.makeText(ListActivity.this, show, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        mNumberTextView.setText("Anime # " + number);
    }
}
