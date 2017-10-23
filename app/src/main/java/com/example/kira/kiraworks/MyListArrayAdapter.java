package com.example.kira.kiraworks;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyListArrayAdapter extends ArrayAdapter{
    private Context mContext;
    private String[] mShows;
    private String[] mInfo;

    public MyListArrayAdapter(Context mContext, int resource, String[] mShows, String[] mInfo) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mShows = mShows;
        this.mInfo = mInfo;
    }

    @Override
    public Object getItem(int position) {
        String shows = mShows[position];
        String info = mInfo[position];
        return String.format("%s \nDescription: %s", shows, info);
    }

    @Override
    public int getCount() {
        return mShows.length;
    }
}
