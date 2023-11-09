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
	private Long favoritesListId;
	
	@OneToOne
    @JoinColumn(name = "userId")
	@JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(
        name = "favoriteslist_movie",
        joinColumns = @JoinColumn(name = "favoritesListId"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies = new ArrayList<>();
    
    
    // constructors
    
	public FavoritesList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FavoritesList(Long favoritesListId, User user, List<Movie> movies) {

	this.favoritesListId = favoritesListId;
	this.user = user;
	this.movies = movies;
}

    
	// getters and setters


	public Long getMovielist_id() {
		return favoritesListId;
	}

	public void setMovielist_id(Long favoritesListId) {
		this.favoritesListId = favoritesListId;
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
