package com.example.kira.kiraworks;

public class Anime {

    private String image;
    private String title;
    private String jpntitle;
    private String studio;
    private String rating;
    private int episodes;
    private double score;

    public Anime(String image, String title, String jpntitle, String studio, String rating, int episodes, double score) {
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

    public int getEpisodes() {
        return episodes;
    }

    public double getScore() {
        return score;
    }
}
