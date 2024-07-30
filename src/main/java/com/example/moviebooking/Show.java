package com.example.moviebooking;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

// Show class creates a show object
// This is for a future implementation
public class Show {

    // Parameters
    private Movie movie;
    private HashMap<String, LocalTime[]> theater; // <theater_room, show_times>
    private final int totalSeats = 150;
    private int availableSeats;
    private List<User> people;
    private LocalTime currentTime = LocalTime.now();


}