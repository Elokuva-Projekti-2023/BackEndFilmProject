package ohjelmointi2.BackEndFilmApp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ohjelmointi2.BackEndFilmApp.domain.GenreListResponse;
import ohjelmointi2.BackEndFilmApp.domain.Genres;
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
    
    public List<Genres> getGenres() {
        String genreUrl = "https://api.themoviedb.org/3/genre/movie/list?api_key=" + tmdbApiKey;
        ResponseEntity<GenreListResponse> genreResponse = restTemplate.exchange(
            genreUrl,
            HttpMethod.GET,
            null,
            GenreListResponse.class
        );

        if (genreResponse.getStatusCode() == HttpStatus.OK && genreResponse.getBody() != null) {
            return genreResponse.getBody().getGenres();
        } else {
            throw new RuntimeException("Failed to fetch genres from TMDb API.");
        }
    }
}
