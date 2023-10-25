package ohjelmointi2.BackEndFilmApp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.MovieDetailResponse;
import ohjelmointi2.BackEndFilmApp.domain.MovieList;
import ohjelmointi2.BackEndFilmApp.domain.MovieListRepository;
import ohjelmointi2.BackEndFilmApp.domain.MovieRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieListService {

    private final MovieListRepository movieListRepository;
    
    private final MovieRepository movieRepository;


    @Autowired
    public MovieListService(MovieListRepository movieListRepository, MovieRepository movieRepository) {
        this.movieListRepository = movieListRepository;
        this.movieRepository = movieRepository;
    }


    public MovieList createMovieList(MovieList movieList) {
        return movieListRepository.save(movieList);
    }

    public MovieList getMovieListById(Long movieListId) {
        return movieListRepository.findById(movieListId).orElse(null);
    }

    public MovieList addMovieToMovieList(Long movieListId, MovieDetailResponse movieDetail) {
    	
        MovieList movieList = getMovieListById(movieListId);
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
            
            return movieListRepository.save(movieList);
        }
        return null;
    }
    public List<MovieList> getAllMovieLists() {
        return (List<MovieList>) movieListRepository.findAll();
    }

    // Other methods for updating, deleting, and managing movie lists
}
