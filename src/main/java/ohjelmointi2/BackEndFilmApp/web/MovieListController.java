package ohjelmointi2.BackEndFilmApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.MovieDetailResponse;
import ohjelmointi2.BackEndFilmApp.domain.MovieList;

import java.util.List;

@RestController
@RequestMapping("/movielists")
public class MovieListController {

    @Autowired
    private MovieListService movieListService;
    
    @Autowired
    private TmdbService tmdbService; // Assuming you have a MovieService to fetch movie details


    // Create a new movie list
    @PostMapping("/create")
    public ResponseEntity<MovieList> createMovieList(@RequestBody MovieList movieList) {
        MovieList createdMovieList = movieListService.createMovieList(movieList);
        return ResponseEntity.ok(createdMovieList);
    }

    // Get a movie list by ID
    @GetMapping("/{movieListId}")
    public ResponseEntity<MovieList> getMovieListById(@PathVariable Long movieListId) {
        MovieList movieList = movieListService.getMovieListById(movieListId);
        return ResponseEntity.ok(movieList);
    }

 // Show one movie by Id
    @GetMapping("/movie/{movieId}")
    public ResponseEntity<MovieDetailResponse> getMovieById(@PathVariable Long movieId) {
        MovieDetailResponse movie = tmdbService.getMovieDetails(movieId);
        
        if (movie != null) {
            return ResponseEntity.ok(movie);
        } else {
            // Handle the case where the movie with the specified ID is not found
            return ResponseEntity.notFound().build();
        }
    }

 // Add a movie to a movie list
    @PostMapping("/{movieListId}/add-movie/{movieId}")
    public ResponseEntity<MovieList> addMovieToMovieList(
            @PathVariable Long movieListId,
            @PathVariable Long movieId) {
        // Fetch the movie details from an external API using a MovieService
        MovieDetailResponse movie = tmdbService.getMovieDetails(movieId);

        if (movie != null) {
            MovieList updatedMovieList = movieListService.addMovieToMovieList(movieListId, movie);
            if (updatedMovieList != null) {
                // Movie added successfully
                return ResponseEntity.ok(updatedMovieList);
            } else {
                // Handle the case where the movie list could not be found
                return ResponseEntity.notFound().build();
            }
        } else {
            // Handle the case where the movie details could not be fetched
            return ResponseEntity.notFound().build();
        }
    }


    // List all movie lists
    @GetMapping("/all")
    public ResponseEntity<List<MovieList>> getAllMovieLists() {
        List<MovieList> movieLists = movieListService.getAllMovieLists();
        return ResponseEntity.ok(movieLists);
    }

    // Other methods for updating, deleting, and managing movie lists
}
