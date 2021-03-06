package com.example.kira.kiraworks;


import android.support.annotation.Nullable;
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

import static android.content.ContentValues.TAG;

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

        public ArrayList<Anime> processResults(Response response) throws IOException {
            ArrayList<Anime> animes = new ArrayList<>();


        Log.d("inside array list", "fgdfgdfgd");

        try {

            String jsonData = response.toString();

            Log.d("inside array JSON", jsonData);

            JSONObject jikanJSON = new JSONObject(jsonData);
            JSONArray titlesJSON = jikanJSON.getJSONArray("title");

            Log.d("jsonData", jikanJSON+"");
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
        catch (JSONException e){
            e.printStackTrace();
            Log.d("JSONEXcept", e+"");
        }
//        catch (IOException e){
//            e.printStackTrace();
//            Log.d("IOExcept", e+"");
//        }
        return animes;
    }
}
