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

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Button mViewListButton;
    private EditText mNumberText;
    private TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberText = (EditText) findViewById(R.id.locationEditText);
        mAppNameTextView = (TextView) findViewById(R.id.appNameTextView);
        Typeface lieFont = Typeface.createFromAsset(getAssets(), "fonts/lie.ttf");
        mAppNameTextView.setTypeface(lieFont);

        mViewListButton = (Button) findViewById(R.id.findViewListButton);
        mViewListButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String number = mNumberText.getText().toString();
                    Intent intent = new Intent(MainActivity.this, ListActivity.class);
                    intent.putExtra("number", number);
                    startActivity(intent);
                }
            });

    }
}
