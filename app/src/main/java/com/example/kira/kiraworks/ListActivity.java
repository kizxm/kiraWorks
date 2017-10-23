package com.example.kira.kiraworks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.net.URL;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


public class ListActivity extends AppCompatActivity {
    public static final String TAG = ListActivity.class.getSimpleName();

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
        getAnime(number);
    }

    private void getAnime(String number) {
        JikanService jikanService = new JikanService();
        jikanService.findAnime(number, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
