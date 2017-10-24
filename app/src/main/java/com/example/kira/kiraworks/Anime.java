package com.example.kira.kiraworks;

public class Anime {

    private String image;
    private String title;
    private String jpntitle;
    private String studio;
    private String rating;
    private double score;

    public Anime(String image, String title, String jpntitle, String studio, String rating, double score) {
        this.image = image;
        this.title = title;
        this.jpntitle = jpntitle;
        this.studio = studio;
        this.rating = rating;
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

    public double getScore() {
        return score;
    }
}
