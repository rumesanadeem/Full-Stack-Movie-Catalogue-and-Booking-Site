package com.example.moviebooking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;


public class FetchMovies {
    /*
    This function allows us to use the search bar to search movies "by search" from our api
    The api we are using is OMDb, and this is where we fetch the movies and their data for the user to access
     */
    public List<Movie> getMoviesBySearch(String search_term) {
        //Url for accessing the api, which accepts the user search term
        String apiUrl = "http://www.omdbapi.com/?apikey=ae1982a4&s=" + search_term;
        List<Movie> movies = new ArrayList<>(); //Create the new list for our movie objects

        try {
            //Create URL object
            URL url = new URL(apiUrl);

            //Create HttpURLConnection object
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //Set request method
            conn.setRequestMethod("GET");

            //Get the response code
            int responseCode = conn.getResponseCode();

            //If response code is 200 (OK)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Create BufferedReader to read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                //Read response line by line
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //Parse JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());

                //Check if response contains 'Search' array (list of movies)
                if (jsonResponse.has("Search")) {
                    JSONArray moviesArray = jsonResponse.getJSONArray("Search");

                    //Iterate through movies array
                    for (int i = 0; i < moviesArray.length(); i++) {
                        JSONObject movieObject = moviesArray.getJSONObject(i);

                        // Extract movie details (Title, ID, Year, Type, PosterID)
                        String title = movieObject.getString("Title");
                        String ID = movieObject.getString("imdbID");
                        int year = Integer.parseInt(movieObject.getString("Year"));
                        String type = movieObject.getString("Type");
                        String posterLink = movieObject.getString("Poster");

                        // Create Movie object for each movie, add it to the list
                        Movie movie = new Movie(title, ID, year, type, posterLink);
                        movies.add(movie);
                    }
                } else {
                    System.out.println("No movies found.");
                }


            } else {
                //If response code is not OK
                System.out.println("GET request failed. Response code: " + responseCode);
            }

            //Close the connection
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return movies;
    }

    /*
    This function gets movies by ID from the api, it is used when the user clicks on a movie object
    It sends a request to the api to fetch the movie's info by ID, which is obtained from the created movie object
     */
    public List<Movie> getMoviesByID(String id) {

        List<Movie> singleMovie = new ArrayList<>();
        String apiUrl = "http://www.omdbapi.com/?apikey=ae1982a4&i=" + id;
        //JSONObject jsonResponse = getResponse(apiUrl);

        try {
            // Create URL object
            URL url = new URL(apiUrl);

            // Create HttpURLConnection object
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Set request method
            conn.setRequestMethod("GET");

            // Get the response code
            int responseCode = conn.getResponseCode();

            // If response code is 200 (OK)
            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Create BufferedReader to read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                // Read response line by line
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());

                if (jsonResponse.has("imdbID")) {
                    String title = jsonResponse.getString("Title");
                    String ID = jsonResponse.getString("imdbID");
                    int year = Integer.parseInt(jsonResponse.getString("Year"));
                    String runtime = jsonResponse.getString("Runtime");
                    double rating = Double.parseDouble(jsonResponse.getString("imdbRating"));
                    String genre = jsonResponse.getString("Genre");
                    String type = jsonResponse.getString("Type");
                    String plot = jsonResponse.getString("Plot");
                    String posterLink = jsonResponse.getString("Poster");

                    Movie movie = new Movie(title, ID, year, type, runtime, rating, genre, plot, posterLink);
                    singleMovie.add(movie);

                } else {
                    System.out.println("Movie not found");
                }
            } else {
                // If response code is not OK
                System.out.println("GET request failed. Response code: " + responseCode);
            }

            // Close the connection
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return singleMovie;
    }

}
