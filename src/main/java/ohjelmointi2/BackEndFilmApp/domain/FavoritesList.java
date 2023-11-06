package ohjelmointi2.BackEndFilmApp.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class FavoritesList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movielist_id;
	
	@OneToOne
    @JoinColumn(name = "user_id")
	@JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(
        name = "movielist_movie",
        joinColumns = @JoinColumn(name = "movielist_id"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies = new ArrayList<>();
    
    
    // constructors
    
	public FavoritesList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FavoritesList(Long movielist_id, User user, List<Movie> movies) {

	this.movielist_id = movielist_id;
	this.user = user;
	this.movies = movies;
}

    
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
    
    
}
