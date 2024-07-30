package com.example.moviebooking;

import jakarta.ejb.Local;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import java.time.LocalTime;

import java.util.List;

@Path("/showtime")
public class ShowtimeResource {

    // check() takes in a showtime and returns if a showtime can be booked
    @GET
    @Path("/check")
    public Response check(@QueryParam("showtime") String showTime)
    {
        // Compare local time and next showtime and create a BookableShow object
        LocalTime now = LocalTime.now();
        LocalTime selectedTime = LocalTime.parse(showTime);

        boolean isBookable = now.isBefore(selectedTime);

        // return response
        return Response.status(200)
                .header("Content-Type", "application/json")
                .header("Access-Control-Allow-Origin", "http://localhost:63342")
                .entity(new BookableShow(isBookable))
                .build();
    }

    // Response bookShowTime() shows a message when a show is booked
    @POST
    @Path("/book")
    public Response bookShowTime()
    {
        //Add user logic
        System.out.println("Showtime booked for user: ");
        return Response.status(200)
                .header("Content-Type", "application/json")
                .header("Access-Control-Allow-Origin", "http://localhost:63342")
                .entity(new BookingConfirmation("Showtime Booked"))
                .build();
    }
}
