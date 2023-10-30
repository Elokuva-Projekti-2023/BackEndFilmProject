package ohjelmointi2.BackEndFilmApp.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usermovie")
public class UserMovie {

	@ManyToOne
    private Movie movie;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userMovieId;
	
	@Column(name = "is_favorite")
	private boolean isFavorite;
	
	@Column(name = "is_on_watchlist")
	private boolean isOnWatchlist;
	
	@Column(name = "is_watched")
	private boolean isWatched;
	

	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Long getUserMovieId() {
		return userMovieId;
	}
	public void setUserMovieId(Long userMovieId) {
		this.userMovieId = userMovieId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isFavorite() {
		return isFavorite;
	}
	public void setFavorite(boolean isFavorite) {
		this.isFavorite = isFavorite;
	}
	public boolean isOnWatchlist() {
		return isOnWatchlist;
	}
	public void setOnWatchlist(boolean isOnWatchlist) {
		this.isOnWatchlist = isOnWatchlist;
	}
	public boolean isWatched() {
		return isWatched;
	}
	public void setWatched(boolean isWatched) {
		this.isWatched = isWatched;
	}

	
}
