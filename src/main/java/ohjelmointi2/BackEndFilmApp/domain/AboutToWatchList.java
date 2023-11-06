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
public class AboutToWatchList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aboutToWatchListId;
	
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

	public AboutToWatchList(Long aboutToWatchListId, User user, List<Movie> movies) {
		super();
		this.aboutToWatchListId = aboutToWatchListId;
		this.user = user;
		this.movies = movies;
	}

	public AboutToWatchList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// getters and setters

	public Long getAboutToWatchListId() {
		return aboutToWatchListId;
	}

	public void setAboutToWatchListId(Long aboutToWatchListId) {
		this.aboutToWatchListId = aboutToWatchListId;
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
		return "AboutToWatchList [AboutToWatchListId=" + aboutToWatchListId + ", user=" + user + ", movies=" + movies
				+ "]";
	}
    
	
    
}
