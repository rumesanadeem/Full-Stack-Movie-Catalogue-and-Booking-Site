package com.example.moviebooking;

import com.fasterxml.jackson.annotation.JsonProperty;

// Movie class creates a movie object
public class Movie {

    // Data members
    @JsonProperty("title")
    private String title; // Title

    @JsonProperty("id")
    private String ID; // IMDB ID

    @JsonProperty("year")
    private int year; // Year

    @JsonProperty("runtime")
    private String runtime; // Movie runtime

    @JsonProperty("rating")
    private double rating; // rating

    @JsonProperty("genre")
    private String genre; // genre

    @JsonProperty("type")
    private String type; // type

    @JsonProperty("plot")
    private String plot; // plot

    @JsonProperty("movie-poster")
    private String moviePoster; // picture of the poster

    // Parameterized Constructor - Movies by Title
    public Movie(String title, String ID, int year, String type, String runtime, double rating, String genre, String plot, String moviePoster)
    {
        this.title = title;
        this.ID = ID;
        this.year = year;
        this.runtime = runtime;
        this.rating = rating;
        this.genre = genre;
        this.type = type;
        this.plot = plot;
        this.moviePoster = moviePoster;
    }

    // Default Constructor
    public Movie() {
        this.title = "";
        this.ID = "";
        this.year = 0;
        this.runtime = "";
        this.rating = 0.0;
        this.genre = "";
        this.type = "";
        this.plot = "";
        this.moviePoster = "";
    }

    // Parameterized Constructor - Movies by Search
    public Movie(String title, String id, int year, String type, String moviePoster) {
        this.title = title;
        this.ID = id;
        this.year = year;
        this.type = type;
        this.moviePoster = moviePoster;
    }

    // Getters
    public String getTitle()
    {
        return this.title;
    }
    public String getID()
    {
        return this.ID;
    }
    public int getYear(){return this.year;};
    public String getRuntime() { return this.runtime; }
    public double getRating() { return this.rating; }
    public String getGenre() { return this.genre; }
    public String getType() { return this.type; }
    public String getPlot() { return this.plot; }
    public String getMoviePoster() { return this.moviePoster; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setID(String ID) { this.ID = ID; }
    public void setYear(int year) { this.year = year; }
    public void setRuntime(String runtime) { this.runtime = runtime; }
    public void setType(String type) { this.type = type; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setPlot(String type) { this.plot = plot; }
    public void setMoviePoster(String moviePoster) { this.moviePoster = moviePoster; }

}