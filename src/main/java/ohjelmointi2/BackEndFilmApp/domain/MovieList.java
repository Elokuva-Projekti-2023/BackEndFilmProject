package ohjelmointi2.BackEndFilmApp.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MovieList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movielist_id;
    private User user;
    private List<Movie> movies;
    private String movielist_name;
    
    // getters ja setters
    
	public Long getMovielist_id() {
		return movielist_id;
	}
	public void setMovielist_id(Long movielist_id) {
		this.movielist_id = movielist_id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Movie> getMovies() {
		return movies;
	}
	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}
	public String getMovielist_name() {
		return movielist_name;
	}
	public void setMovielist_name(String movielist_name) {
		this.movielist_name = movielist_name;
	}
	
	// ToString
	
	@Override
	public String toString() {
		return "MovieList [movielist_id=" + movielist_id + ", user=" + user + ", movies=" + movies + ", movielist_name="
				+ movielist_name + "]";
	} 

    
    
}