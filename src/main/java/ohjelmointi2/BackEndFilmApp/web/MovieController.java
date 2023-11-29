package ohjelmointi2.BackEndFilmApp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ohjelmointi2.BackEndFilmApp.domain.Genres;
import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.User;

@RestController
@RequestMapping("/api/tmdb")
public class MovieController {

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
    
    @GetMapping("/search/movie")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String searchTerm) {
        List<Movie> searchResults = tmdbService.searchMovies(searchTerm); // Implement this method in TmdbService
        return ResponseEntity.ok(searchResults);
    }
  
}
