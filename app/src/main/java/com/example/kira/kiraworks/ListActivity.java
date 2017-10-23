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


import butterknife.Bind;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {
    @Bind(R.id.numberTextView) TextView mNumberTextView;
    @Bind(R.id.listView) ListView mListView;

    private String[] shows = new String[] {"title1", "title2", "title3", "title4", "title5", "title6",
                                           "title7", "title8", "title9", "title10", "title11", "title12"};
    private String[] info = new String[] {"desc1", "desc2", "desc3", "desc4", "desc5", "desc6",
                                          "desc7", "desc8", "desc9", "desc10", "desc11", "desc12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ButterKnife.bind(this);

        MyListArrayAdapter adapter = new MyListArrayAdapter(this, android.R.layout.simple_list_item_1, shows, info);
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
