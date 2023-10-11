package ohjelmointi2.BackEndFilmApp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.User;

@RestController
@RequestMapping("/api/tmdb")
public class UserMovieListController {

	@Autowired
    private TmdbService tmdbService;

    public void TmdbController(TmdbService tmdbService) {
        this.tmdbService = tmdbService;
    }

    @GetMapping("/now-playing")
    public ResponseEntity<List<Movie>> getNowPlayingMovies() {
        List<Movie> nowPlayingMovies = tmdbService.getNowPlayingMovies();
        return ResponseEntity.ok(nowPlayingMovies);
    }
    
    @GetMapping("/popular")
    public ResponseEntity<List<Movie>> getPopularMovies() {
    	List<Movie> popularMovies = tmdbService.getPopularMovies();
    	return ResponseEntity.ok(popularMovies);
    }
    
    @GetMapping("/toprated")
    public ResponseEntity<List<Movie>> getTopRatedMovies() {
    	List<Movie> topRatedMovies = tmdbService.getTopRatedMovies();
    	return ResponseEntity.ok(topRatedMovies);
    }
    
    @GetMapping("/upcoming")
    public ResponseEntity<List<Movie>> getUpcomingMovies() {
    	List<Movie> upcomingMovies = tmdbService.getUpcomingMovies();
    	return ResponseEntity.ok(upcomingMovies);
    }

 /*   @PostMapping("/save-to-watched/{userId}/{movieId}")
    public ResponseEntity<String> saveToWatched(@PathVariable Long userId, @PathVariable Long movieId) {
        // Fetch the user from your database (userService.getUserById(userId))
        User user = userService.getUserById(userId);

        // Save the movie to the user's "Watched List"
        tmdbService.saveToWatched(user, movieId);

        return ResponseEntity.ok("Movie saved to Watched List.");
    }

    @PostMapping("/save-to-to-watch/{userId}/{movieId}")
    public ResponseEntity<String> saveToToWatch(@PathVariable Long userId, @PathVariable Long movieId) {
        // Fetch the user from your database (userService.getUserById(userId))
        User user = userService.getUserById(userId);

        // Save the movie to the user's "To Watch List"
        tmdbService.saveToToWatch(user, movieId);

        return ResponseEntity.ok("Movie saved to To Watch List.");
    } 
    */
}
