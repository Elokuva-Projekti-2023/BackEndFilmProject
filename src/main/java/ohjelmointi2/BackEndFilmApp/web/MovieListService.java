package ohjelmointi2.BackEndFilmApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmointi2.BackEndFilmApp.domain.FavoritesList;
import ohjelmointi2.BackEndFilmApp.domain.FavoritesListRepository;
import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.MovieDetailResponse;
import ohjelmointi2.BackEndFilmApp.domain.MovieRepository;
import ohjelmointi2.BackEndFilmApp.domain.User;
import ohjelmointi2.BackEndFilmApp.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieListService {

    
    private final MovieRepository movieRepository;

    private final FavoritesListRepository favoritesListRepository;
    
    private final UserRepository userRepository;
    
    @Autowired
    public MovieListService(MovieRepository movieRepository,
    		FavoritesListRepository favoritesListRepository, UserRepository userRepository) {

        this.movieRepository = movieRepository;
		this.favoritesListRepository = favoritesListRepository;
		this.userRepository = userRepository;
    }
    
    // Favotites List Service
    
    
    public FavoritesList getFavoritesListById(Long movieListId) {
    	return favoritesListRepository.findById(movieListId).orElse(null);
    }

    public FavoritesList saveFavoritesList(FavoritesList favoritesList) {
        return favoritesListRepository.save(favoritesList);
    }
    
    public List<FavoritesList> getAllFavoritesMovieLists() {
        return (List<FavoritesList>) favoritesListRepository.findAll();
    }
    
    public FavoritesList addMovieToFavoritesList(Long movieListId, MovieDetailResponse movieDetail) {
    	
        FavoritesList movieList = getFavoritesListById(movieListId);
        if (movieList != null) {
            // Create a new Movie entity or class to represent the external API data
            // You may need to adapt this based on your actual Movie entity
            Movie movie = new Movie();
            movie.setMovie_id(movieDetail.getId());
            movie.setMovie_title(movieDetail.getTitle());
            movie.setMovie_description(movieDetail.getOverview());
            movie.setOriginal_title(movieDetail.getOriginal_title());
            movie.setPoster_path(movieDetail.getPoster_path());
            movie.setRelease_date(movieDetail.getRelease_date());
            movie.setVote_average(movieDetail.getVote_average());
            movie.setVote_count(movieDetail.getVote_count());
            
            // Tänne lisätään if else!!
            
            movieRepository.save(movie);
            
            // Set other relevant fields as needed

            // Ensure the movie list's "movies" field is initialized
            if (movieList.getMovies() == null) {
                movieList.setMovies(new ArrayList<>());
            }
            
            
            movieList.getMovies().add(movie);
            
            return favoritesListRepository.save(movieList);
        }
        return null;
    }
    
    // User Service
    
    
	 public List<User> getAllUsers() {
	        return (List<User>) userRepository.findAll();
	    }
    
}
