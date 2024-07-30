// Retrieve data from session storage
const storedData = sessionStorage.getItem('movieDetails');
console.log(storedData);

// Data parses the movie by title and adds details
if (storedData) {
    const data = JSON.parse(storedData);

    document.getElementById("title").textContent = data.Title;
    document.getElementById('genre').textContent = data.Genre;
    document.getElementById("year").textContent = data.Year;
    document.getElementById('plot').textContent = data.Plot;
    document.getElementById("rating").textContent = data.Rating;
    document.getElementById('runtime').textContent = data.Runtime;
    document.getElementById('poster').src = data.Poster;
    document.getElementById('movie-title').value = data.Title;

}

// Clear the stored data after use (optional)
sessionStorage.removeItem('movieDetails');

// selectShowtime() takes in a showtime and shows up a pop-up window to book a showtime
function selectShowtime(showtime)
{   //Obtain the selected showtime
    fetch (`http://localhost:8080/MovieBooking-1.0/api/showtime/check?showtime=${showtime}`)
        .then(response => {
            if (!response.ok)
            {
                throw new Error("Error fetching showtime availability")

            }
            return response.json()
        })
        .then(result => {
            if (result.bookable) // Check if the showtime is bookable
            {
                // Show the booking form
                document.getElementById('showtimeForm').style.display = 'block';
                document.getElementById('message').textContent = '';
                document.getElementById('movie-form-booking').style.display = 'block';
                document.getElementById('popup').style.display = 'flex';
            }
            else
            {
                document.getElementById('message').textContent = 'Showtime not available for booking';
            }

        })
        .catch(error => {
            console.error('There was an error checking showtime availability: ', error);
            document.getElementById('message').textContent = 'Error checking showtime availability';
        });
}

// bookShowTime() shows a confirmation message when a showtime has been booked
function bookShowTime()
{

    document.getElementById('submitMessage').textContent = 'Showtime successfully booked!';

}

// closeBox() closes the box when the item has been booked
function closeBox(){
    document.getElementById('movie-form-booking').style.display = 'none';
    document.getElementById('popup').style.display = 'none';
}