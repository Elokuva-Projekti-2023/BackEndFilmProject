package ohjelmointi2.BackEndFilmApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ohjelmointi2.BackEndFilmApp.domain.AboutToWatchList;
import ohjelmointi2.BackEndFilmApp.domain.FavoritesList;
import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.MovieDetailResponse;
import ohjelmointi2.BackEndFilmApp.domain.MovieList;
import ohjelmointi2.BackEndFilmApp.domain.OnWatchList;
import ohjelmointi2.BackEndFilmApp.domain.User;
import ohjelmointi2.BackEndFilmApp.domain.UserRepository;
import ohjelmointi2.BackEndFilmApp.domain.UserMovieLists;

import java.util.List;

@RestController
@RequestMapping("/movielists")
public class MovieListController {

    @Autowired
    private MovieListService movieListService;
    
    @Autowired
    private TmdbService tmdbService; // Assuming you have a MovieService to fetch movie details
    
    @Autowired 
    private UserRepository userRepository;


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
    
    // Get all movielists of one user
    
    @GetMapping("/{userId}/movie-lists")
    public ResponseEntity<UserMovieLists> getUserMovieLists(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            UserMovieLists userMovieLists = new UserMovieLists();
            userMovieLists.setFavoritesList(user.getFavoritesList());
            userMovieLists.setOnWatchList(user.getOnWatchList());
            userMovieLists.setAboutToWatchList(user.getAboutToWatchList());
            return ResponseEntity.ok(userMovieLists);
        } else {
            return ResponseEntity.notFound().build();
        }
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

// Add a movie to a watched list
    
    @PostMapping("/{movieListId}/add-movie-to-watched/{movieId}")
    public ResponseEntity<OnWatchList> addMovieToOnWatchList(
            @PathVariable Long movieListId,
            @PathVariable Long movieId) {
        // Fetch the movie details from an external API using a MovieService
        MovieDetailResponse movie = tmdbService.getMovieDetails(movieId);

        if (movie != null) {
        	OnWatchList updatedOnWatchList = movieListService.addMovieToOnWatchList(movieListId, movie);
            if (updatedOnWatchList != null) {
                // Movie added successfully
                return ResponseEntity.ok(updatedOnWatchList);
            } else {
                // Handle the case where the movie list could not be found
                return ResponseEntity.notFound().build();
            }
        } else {
            // Handle the case where the movie details could not be fetched
            return ResponseEntity.notFound().build();
        }
    }
    
// Add a movie to about-to-watch-list
    
    @PostMapping("/{movieListId}/add-movie-to-about-to-watch/{movieId}")
    public ResponseEntity<AboutToWatchList> addMovieToAboutToWatchList(
            @PathVariable Long movieListId,
            @PathVariable Long movieId) {
        // Fetch the movie details from an external API using a MovieService
        MovieDetailResponse movie = tmdbService.getMovieDetails(movieId);

        if (movie != null) {
        	AboutToWatchList updatedAboutToWatchList = movieListService.addMovieToAboutToWatchList(movieListId, movie);
            if (updatedAboutToWatchList != null) {
                // Movie added successfully
                return ResponseEntity.ok(updatedAboutToWatchList);
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
