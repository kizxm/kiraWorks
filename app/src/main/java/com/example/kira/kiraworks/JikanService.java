package com.example.kira.kiraworks;


import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.ResponseCache;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JikanService {

    public static void findAnime(String number, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://jikan.me/api/anime/" + number).newBuilder();
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
        Log.d("url", url);
    }

    public ArrayList<Anime> processResults(Response response) {
        ArrayList<Anime> animes = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            JSONObject jikanJSON = new JSONObject(jsonData);
            JSONArray titlesJSON = jikanJSON.getJSONArray("titles");
            for (int i = 0; i < titlesJSON.length(); i++) {
                JSONObject animeJSON = titlesJSON.getJSONObject(i);
                String image = animeJSON.optString("image", "NO IMAGE");
                String title = animeJSON.getString("title");
                String jpntitle = animeJSON.getString("jpntitle");
                String studio = animeJSON.getString("studio");
                String rating = animeJSON.getString("rating");
                double episodes = animeJSON.getDouble("episodes");

                ArrayList<String> score = new ArrayList<>();
                JSONArray scoreJSON = animeJSON.getJSONArray("score");
                for (int y = 0; y < scoreJSON.length(); y++) {
                    score.add(scoreJSON.getJSONObject(y).getString("SCORES"));
                }

                Anime anime = new Anime(image, title, jpntitle, studio, rating, episodes, score);
                animes.add(anime);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return animes;
    }
}
