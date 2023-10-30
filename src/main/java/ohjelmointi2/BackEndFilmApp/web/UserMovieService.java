package ohjelmointi2.BackEndFilmApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.User;
import ohjelmointi2.BackEndFilmApp.domain.UserMovie;
import ohjelmointi2.BackEndFilmApp.domain.UserMovieRepository;


@Service
public class UserMovieService {

	private final UserMovieRepository userMovieRepository;
    
    @Autowired
    public UserMovieService(UserMovieRepository userMovieRepository) {
        this.userMovieRepository = userMovieRepository;
    }
   
    
    public UserMovie createUserMovie(UserMovie userMovie) {
        return userMovieRepository.save(userMovie);
    }
    
    public UserMovie AddMovieToWatchlist(User user, Movie movie) {
    	UserMovie userMovie = new UserMovie();
    	userMovie.setUser(user);
    	userMovie.setMovie(movie);
    	userMovie.setOnWatchlist(true);
    	return userMovieRepository.save(userMovie);
    }
    


}
