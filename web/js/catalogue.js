/*
const homeMovie = sessionStorage.getItem('home-movie');
*/

function scrollHorizontally(direction, containerId) {
    let container = document.getElementById(containerId);
    let scrollAmount = 300; // Adjust scroll amount as needed

    // Calculate the new position
    let newScrollPosition = container.scrollLeft + (scrollAmount * direction);

    // Smoothly scroll to the new position
    container.scrollTo({
        top: 0,
        left: newScrollPosition,
        behavior: 'smooth'
    });
}

document.addEventListener('DOMContentLoaded', () => {
    fetchMovies();
});

function fetchMovies(search = "") {
    let url = `http://localhost:8080/MovieBooking-1.0/api/movies/list?search=${encodeURIComponent(search)}`;
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(movies => {
            displayMovies(movies);
        })
        .catch(error => {
            console.error("There was an error fetching the movies: ", error);
        });
}

// displayMovies() displays the movie list
function displayMovies(movies) {
    // Get container
    const movieList = document.getElementById("classics-container");
    movieList.innerHTML = ''; // Clear existing movies

    // For each movie
    movies.forEach(movie => {
        // Create movie element
        const movieItem = document.createElement('div');
        movieItem.className = 'movie-item';

        // Movie Title and Year
        const title = document.createElement('h3');
        title.textContent = `${movie.title} (${movie.year})`;

        // Poster
        const image = document.createElement('img');
        image.src = movie.moviePoster;
        image.alt = `Poster for ${movie.title}`;
        image.style.width = '100px';
        image.style.height = '150px';

        // Movie type
        const type = document.createElement('p');
        type.textContent = `Type: ${movie.type}`;

        // Get movie details
        const button = document.createElement('button');
        button.id = 'viewDetails';
        button.textContent = 'View Details';
        button.onclick = () => fetchMovieDetails(movie.ID);

        // Append items to HTML
        movieItem.appendChild(image);
        movieItem.appendChild(title);
        movieItem.appendChild(type);
        movieItem.appendChild(button);
        movieList.appendChild(movieItem);
    });
}

// Fetch movie details using the API search function
function fetchMovieDetails(imdbID) {
    let url = `http://www.omdbapi.com/?apikey=ae1982a4&i=${imdbID}`;

    // Fetch response
    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error("Error fetching movie details");
            }
            return response.json();
        })
        // Positive response
        .then(details => {
            displayMovieDetails(details);
            sessionStorage.setItem('movieDetails', JSON.stringify(details));
            window.location.href = "showtimes.html";
        })
        .catch(error => {
            console.error("There was an error fetching movie details: ", error);
        });
}

// displayMovieDetails() displays the details of the movie
function displayMovieDetails(details) {
    console.log("Movie Details: ", details);
    // Implement the display logic, possibly updating DOM elements or navigating
}

// search() searches for movies
function search() {
    const searchInput = document.getElementById("searchInput").value.trim();
    document.getElementById('left-scroll').classList.toggle('hidden');
    document.getElementById('right-scroll').classList.toggle('hidden');
    fetchMovies(searchInput);
}


/*
if (homeMovie) {
    console.log(homeMovie);
    fetchMovies(homeMovie);
}*/
