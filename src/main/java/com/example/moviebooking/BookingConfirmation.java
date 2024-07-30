package com.example.moviebooking;

// BookingConfirmation class creates a booking confirmation object that sends a confirmation message
public class BookingConfirmation {
    private String message; // Data member

    // Constructor
    public BookingConfirmation(String message) { this.message = message; }

    // Return message
    public String getMessage() { return message; }
}