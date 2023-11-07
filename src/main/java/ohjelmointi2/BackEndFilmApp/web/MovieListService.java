package ohjelmointi2.BackEndFilmApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmointi2.BackEndFilmApp.domain.AboutToWatchList;
import ohjelmointi2.BackEndFilmApp.domain.AboutToWatchListRepository;
import ohjelmointi2.BackEndFilmApp.domain.FavoritesList;
import ohjelmointi2.BackEndFilmApp.domain.FavoritesListRepository;
import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.MovieDetailResponse;
import ohjelmointi2.BackEndFilmApp.domain.MovieRepository;
import ohjelmointi2.BackEndFilmApp.domain.OnWatchList;
import ohjelmointi2.BackEndFilmApp.domain.OnWatchListRepository;
import ohjelmointi2.BackEndFilmApp.domain.User;
import ohjelmointi2.BackEndFilmApp.domain.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieListService {

    
    private final MovieRepository movieRepository;

    private final FavoritesListRepository favoritesListRepository;
    
    private final UserRepository userRepository;
    
    private final OnWatchListRepository watchedListRepository;
    
    private final AboutToWatchListRepository aboutToWatchListRepository;
    
    @Autowired
    public MovieListService(MovieRepository movieRepository,
    		FavoritesListRepository favoritesListRepository, UserRepository userRepository,OnWatchListRepository watchedListRepository, AboutToWatchListRepository aboutToWatchListRepository ) {

        this.movieRepository = movieRepository;
		this.favoritesListRepository = favoritesListRepository;
		this.userRepository = userRepository;
		this.watchedListRepository = watchedListRepository;
		this.aboutToWatchListRepository = aboutToWatchListRepository;
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
    
    // OnWatch List Service
    
    public OnWatchList getOnWatchListById(Long movieListId) {
    	return watchedListRepository.findById(movieListId).orElse(null);
    }

    public OnWatchList saveOnWatchList(OnWatchList onwatchList) {
        return watchedListRepository.save(onwatchList);
    }
    
    public List<OnWatchList> getAllWatchedMovieLists() {
        return (List<OnWatchList>) watchedListRepository.findAll();
    }
    
    // ToBeWatched List Service
    
    public AboutToWatchList getAboutToWatchListById(Long movieListId) {
    	return aboutToWatchListRepository.findById(movieListId).orElse(null);
    }

    public AboutToWatchList saveAboutToWatchList(AboutToWatchList aboutToWatchList) {
        return aboutToWatchListRepository.save(aboutToWatchList);
    }
    
    public List<AboutToWatchList> getAllAboutToWatchMovieLists() {
        return (List<AboutToWatchList>) aboutToWatchListRepository.findAll();
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
    
    
    //addMovieToOnWatchList
    
public OnWatchList addMovieToOnWatchList(Long movieListId, MovieDetailResponse movieDetail) {
    	
        OnWatchList movieList = getOnWatchListById(movieListId);
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
            
            return watchedListRepository.save(movieList);
        }
        return null;
    }
    

//addMovieToAboutToWatchList

public AboutToWatchList addMovieToAboutToWatchList(Long movieListId, MovieDetailResponse movieDetail) {
  	
      AboutToWatchList movieList = getAboutToWatchListById(movieListId);
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
          
          return aboutToWatchListRepository.save(movieList);
      }
      return null;
  }
  
    
    // User Service
    
    
	 public List<User> getAllUsers() {
	        return (List<User>) userRepository.findAll();
	    }
    
}
