package com.example.kira.kiraworks;

import java.util.ArrayList;

public class Anime {

    private String image;
    private String title;
    private String jpntitle;
    private String studio;
    private String rating;
    private double episodes;
    private ArrayList<String> score = new ArrayList<>();

    public Anime(String image, String title, String jpntitle, String studio, String rating, double episodes, ArrayList<String> score) {
        this.image = image;
        this.title = title;
        this.jpntitle = jpntitle;
        this.studio = studio;
        this.rating = rating;
        this.episodes = episodes;
        this.score = score;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getJpntitle() {
        return jpntitle;
    }

    public String getStudio() {
        return studio;
    }

    public String getRating() {
        return rating;
    }

    public double getEpisodes() {
        return episodes;
    }

    public ArrayList<String> getScore() {
        return score;
    }
}
