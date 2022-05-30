package com.example.ashva.models;

public class MovieModel {
    private long id;
    private String title;
    private String language;
    private String overview;
    private String poster_path;
    private String release_date;
    private String rating;

    public MovieModel(long id, String title, String language, String overview, String poster_path, String release_date, String rating) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.overview = overview;
        this.poster_path = poster_path;
        this.release_date = release_date;
        this.rating = rating;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
