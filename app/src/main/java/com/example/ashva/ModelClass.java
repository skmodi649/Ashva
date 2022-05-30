package com.example.ashva;

public class ModelClass {
    String movie_name;
    String rating;
    int image;

    public ModelClass(String movie_name, String rating, int image) {
        this.movie_name = movie_name;
        this.rating = rating;
        this.image = image;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public String getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }
}
