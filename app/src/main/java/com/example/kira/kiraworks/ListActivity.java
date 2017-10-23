package com.example.kira.kiraworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    private TextView mNumberTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        mNumberTextView = (TextView) findViewById(R.id.numberTextView);
        Intent intent = getIntent();
        String number = intent.getStringExtra("number");
        mNumberTextView.setText("Anime # " + number);
    }
}
