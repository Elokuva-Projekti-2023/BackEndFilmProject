package ohjelmointi2.BackEndFilmApp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ohjelmointi2.BackEndFilmApp.domain.Movie;
import ohjelmointi2.BackEndFilmApp.domain.MovieListResponse;

@Service
public class TmdbService {
	
	@Value("${apiKey}")
	private String tmdbApiKey;


    private final RestTemplate restTemplate;

    public TmdbService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Movie> getNowPlayingMovies() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=" + tmdbApiKey;
        ResponseEntity<MovieListResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            MovieListResponse.class
        );

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody().getResults();
        } else {
            throw new RuntimeException("Failed to fetch now playing movies from TMDb API.");
        }
    }
    
    public List<Movie> getPopularMovies() {
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + tmdbApiKey;
        ResponseEntity<MovieListResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            MovieListResponse.class
        );

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody().getResults();
        } else {
            throw new RuntimeException("Failed to fetch popular movies from TMDb API.");
        }
    }
    
    public List<Movie> getTopRatedMovies() {
        String url = "https://api.themoviedb.org/3/movie/top_rated?api_key=" + tmdbApiKey;
        ResponseEntity<MovieListResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            MovieListResponse.class
        );

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody().getResults();
        } else {
            throw new RuntimeException("Failed to fetch top rated movies from TMDb API.");
        }
    }
    
    public List<Movie> getUpcomingMovies() {
        String url = "https://api.themoviedb.org/3/movie/upcoming?api_key=" + tmdbApiKey;
        ResponseEntity<MovieListResponse> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            null,
            MovieListResponse.class
        );

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return response.getBody().getResults();
        } else {
            throw new RuntimeException("Failed to fetch upcoming movies from TMDb API.");
        }
    }
    
    
}
