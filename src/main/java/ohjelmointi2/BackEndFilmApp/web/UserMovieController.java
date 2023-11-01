package ohjelmointi2.BackEndFilmApp.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.User;
import ohjelmointi2.BackEndFilmApp.domain.UserMovie;



@RestController
@RequestMapping("/usermovies")
public class UserMovieController {
	
	@Autowired
    private UserMovieService userMovieService;
	

 	@PostMapping("/addtowatchlist")
	public ResponseEntity<UserMovie> addMovieToWatclist(@RequestBody UserMovie userMovie) {
		User user = userMovie.getUser();
		Movie movie = userMovie.getMovie();
		
		if (user == null || movie == null) {
			return ResponseEntity.badRequest().build();
		}
		
		UserMovie usermovie = userMovieService.AddMovieToWatchlist(user, movie);
		
		return ResponseEntity.ok(usermovie);
	}  
}
