package com.example.kira.kiraworks;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class JikanService {

    public static void findAnime(String number, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.JIKAN_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.JIKAN_NUMBER_QUERY_PARAMETER, number);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
