package com.example.kira.kiraworks;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.findAddFriendButton) Button mAddFriendButton;
    @Bind(R.id.findViewListButton) Button mViewListButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mViewListButton.setOnClickListener(this);
        mAddFriendButton.setOnClickListener(this);

    }
        @Override
            public void onClick(View v) {
            if(v == mViewListButton) {
                Intent intentView = new Intent(MainActivity.this, ListActivity.class);
                startActivity(intentView);
            }
            else if(v == mAddFriendButton) {
                Toast.makeText(MainActivity.this, "New Friend Added", Toast.LENGTH_LONG).show();
            }
    }
}
