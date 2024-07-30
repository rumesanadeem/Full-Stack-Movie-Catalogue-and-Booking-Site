package com.example.moviebooking;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/movies")
public class MovieResource {

    // Create a fetch movies object
    FetchMovies movies = new FetchMovies();

    // getMovieList() takes in a search term and returns a JSON file of movies
    @GET
    @Produces("application/json")
    @Path("list")
    public Response getMovieList(@QueryParam("search") String searchTerm) {

        // get test results
        List<Movie> moviesList = movies.getMoviesBySearch(searchTerm);

        if (searchTerm != null || !searchTerm.isEmpty())
        {
            moviesList.removeIf(movie -> !movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase()));
        }

        // return response with the test results
        return Response.status(200)
                .header("Content-Type", "application/json")
                .header("Access-Control-Allow-Origin", "http://localhost:63342")
                .entity(moviesList)
                .build();
    }

    // getIndividualMovie() takes in a search term and returns a JSON file of movies
    @GET
    @Produces("application/json")
    @Path("single")
    public Response getIndividualMovie(@QueryParam("id") String id) {

        // get test results
        List<Movie> movieSingle = movies.getMoviesByID(id);

        // return response with the test results
        return Response.status(200)
                .header("Content-Type", "application/json")
                .header("Access-Control-Allow-Origin", "http://localhost:63342")
                .entity(movieSingle)
                .build();
    }

}