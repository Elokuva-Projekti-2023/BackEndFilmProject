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
public class OnWatchList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long onWatchListId;
	
	@OneToOne
    @JoinColumn(name = "userId")
	@JsonIgnore
    private User user;

    @ManyToMany
    @JoinTable(
        name = "onwatchlist_movie",
        joinColumns = @JoinColumn(name = "onWatchListId"),
        inverseJoinColumns = @JoinColumn(name = "movie_id")
    )
    private List<Movie> movies = new ArrayList<>();
    
    
    // constructors

	public OnWatchList(Long onWatchListId, User user, List<Movie> movies) {
		
		this.onWatchListId = onWatchListId;
		this.user = user;
		this.movies = movies;
	}

	public OnWatchList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//getters and setters

	public Long getOnWatchListId() {
		return onWatchListId;
	}

	public void setOnWatchListId(Long onWatchListId) {
		this.onWatchListId = onWatchListId;
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

	// ToString
	
	@Override
	public String toString() {
		return "OnWatchList [onWatchListId=" + onWatchListId + ", user=" + user + ", movies=" + movies + "]";
	}

    
    
    
}
