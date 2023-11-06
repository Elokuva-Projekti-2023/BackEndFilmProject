package ohjelmointi2.BackEndFilmApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ohjelmointi2.BackEndFilmApp.domain.FavoritesList;
import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.MovieDetailResponse;
import ohjelmointi2.BackEndFilmApp.domain.MovieList;
import ohjelmointi2.BackEndFilmApp.domain.User;

import java.util.List;

@RestController
@RequestMapping("/movielists")
public class MovieListController {

    @Autowired
    private MovieListService movieListService;
    
    @Autowired
    private TmdbService tmdbService; // Assuming you have a MovieService to fetch movie details


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

    // List all movie lists
    @GetMapping("/allfavorites")
    public ResponseEntity<List<FavoritesList>> getAllFavoritesList() {
        List<FavoritesList> movieLists = movieListService.getAllFavoritesMovieLists();
        return ResponseEntity.ok(movieLists);
    }
    
    // List all users
    @GetMapping("/allusers")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = movieListService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    
    // Add a movie to a favorites list
    
    @PostMapping("/{movieListId}/add-movie-to-favorites/{movieId}")
    public ResponseEntity<FavoritesList> addMovieToFavoritesList(
            @PathVariable Long movieListId,
            @PathVariable Long movieId) {
        // Fetch the movie details from an external API using a MovieService
        MovieDetailResponse movie = tmdbService.getMovieDetails(movieId);

        if (movie != null) {
        	FavoritesList updatedFavoritesList = movieListService.addMovieToFavoritesList(movieListId, movie);
            if (updatedFavoritesList != null) {
                // Movie added successfully
                return ResponseEntity.ok(updatedFavoritesList);
            } else {
                // Handle the case where the movie list could not be found
                return ResponseEntity.notFound().build();
            }
        } else {
            // Handle the case where the movie details could not be fetched
            return ResponseEntity.notFound().build();
        }
    }

    

}
