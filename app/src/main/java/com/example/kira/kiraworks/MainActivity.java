package com.example.kira.kiraworks;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.findViewListButton) Button mFindViewListButton;
    @Bind(R.id.numberEditText) EditText mNumberText;
    @Bind(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Typeface lieFont = Typeface.createFromAsset(getAssets(), "fonts/lie.ttf");
        mAppNameTextView.setTypeface(lieFont);

        mFindViewListButton.setOnClickListener(this);
    }

        @Override
            public void onClick(View v) {
            if (v == mFindViewListButton) {
                String number = mNumberText.getText().toString();
                Intent intent = new Intent(MainActivity.this, ListActivity.class);
                intent.putExtra("number", number);
                startActivity(intent);
        }
    }
}

