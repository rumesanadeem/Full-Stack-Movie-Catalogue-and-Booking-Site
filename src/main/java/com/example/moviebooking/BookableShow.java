package com.example.moviebooking;

// BookableShow determines whether a show is bookable and returns a boolean value
public class BookableShow {
    private boolean bookable; // Data Member

    // Constructor
    public BookableShow(boolean bookable) { this.bookable = bookable; }
    public boolean isBookable() { return bookable; }
}