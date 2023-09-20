package ohjelmointi2.BackEndFilmApp.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class MovieList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movielist_id;
	
	private String movielist_name;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(
        name = "movielist_movie",
        joinColumns = @JoinColumn(name = "movielist_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies = new ArrayList<>();
    
    
    
    // getters and setters
    
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