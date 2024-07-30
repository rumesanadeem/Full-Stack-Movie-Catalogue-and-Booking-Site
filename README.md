# Final Project - Movie Catalogue and Booking Site
## Project Information:
For this project we decided to create a movie catalogue with a simple booking feature that allows users to view movies
at a particular time and location. Our site pulls movie data from an API (OMDb API) which contains hundreds of thousands
of movies for the user to search and choose from. We use two of the APIs search functionalities,
searching with a movie title search term, and searching by the movie's imdbID to display movie info and booking
times to user to choose from. We use heavy use of RESTful API in order to achieve
seamless backend and frontend compatability and display all the movie data the user requests.

### Screen-recording of the Website Functionality:

[Link to Video Of Movie Booking Site](https://www.youtube.com/watch?v=r3yqKDID_EY&feature=youtu.be)

### Link to the API we used

[The Open Movie Database](https://www.omdbapi.com/)

# How to run:
Step-by-step on how to successfully clone and run the website:

### 1. Locating the Directory in Terminal:
Open your terminal/command prompt and navigate to the directory where you want to clone
the repository using the "cd" command.
Example:
   ```bash
   cd path/to/your/directory
   ```
### 2. Cloning the Repository:
Clone the repository using the git clone command followed by the URL of the repository.
Example:
  ```bash
   git clone https://github.com/your-username/your-repo.git
   ```
### 3. Launching IntelliJ IDEA:
Open the project, in IntelliJ IDEA, by selecting "Open" from the File menu and navigate
to the directory where you cloned the repository. Now, choose the project folder, and click "Open".

### 4. Converting the Project into a Maven Project:
If the project is not recognized as a Maven project, you must convert it (if necessary) by navigating to the
project window,
Next, press Ctrl+Shift+A (Windows/Linux) or Cmd+Shift+A (Mac) to open the action
search. Then, type "Add Maven Project" to press Enter.

### 5. Configuring Project Settings:
Configure the project settings according to your environment.
This can include setting up a JDK version or other dependencies.

### 6. Launching Glassfish Server:
Start Glassfish Server in IntelliJ IDEA by clicking on the "Run" button
Then, select "Edit Configurations", and add a new Glassfish Server configuration.

### 7. Specify the Server Domain:
Keep in mind to set JRE to the latest version by setting the "Domain" option to "domain1".
Afterwards, click on the "Run" option to start the server.
Next, add an artifact and choose MovieBooking:war exploded.

### 8. Deploy the Application:
Once Glassfish Server is running, deploy the movie server by right-clicking on the project directory in
IntelliJ IDEA.
Once deployment is completed, use the URL provided by Glassfish to access the movie server.
The URL for access will be: `http://localhost:8080/MovieBooking-1.0/api/movies/list`

### 9. Run the Application:
In order to launch the website in your default web browser, navigate to index.html in the project structure,
right-click on it, then select "Run index.html".

### 10. Search for a Movie:
On the home page press the search button to access the catalogue and then enter your movie title into the search bar.

### 11. Select and book a Movie
From the list of titles that show up, choose which one you want and then click on View Details.
On the new page that opens select a valid time, a timestamp is used to allow users to only select movies after
the current time
Afterwards, select the date and location then click the submit button.

# Group Members and Contribution Report:

### Rosie Khurmi and Sanhith Amarathunge:
- FetchMovies.java
- Movie.java
- MovieResource.java
- MovieApplication.java
- BookableShow.java
- BookingConfirmation.java
- ShowtimeApplication.java
- ShowtimeResource.java
- User.java
- catalogue.js
- showtimes.js
- about.js
- README

### Rumesa Nadeem:
- index.html
- catalogue.html
- showtimes.html
- about.html
- index.css
- catalogue.css
- showtimes.css
- about.css
- catalogue.js
- showtimes.js
- main.js
- about.js

### Paul Joseph
- index.html
- index.css
- README