package ohjelmointi2.BackEndFilmApp.domain;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long movie_id;
	private String movie_title;
	private String movie_description;
	private String movie_genre;
	
	@ManyToMany(mappedBy = "movies")
	private List<MovieList> movieLists = new ArrayList<>();
	
	// getters and setters
	
	public Long getMovie_id() {
		return movie_id;
	}
	public void setMovie_id(Long movie_id) {
		this.movie_id = movie_id;
	}
	public String getMovie_title() {
		return movie_title;
	}
	public void setMovie_title(String movie_title) {
		this.movie_title = movie_title;
	}
	public String getMovie_description() {
		return movie_description;
	}
	public void setMovie_description(String movie_description) {
		this.movie_description = movie_description;
	}
	public String getMovie_genre() {
		return movie_genre;
	}
	public void setMovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}
	
	public List<MovieList> getMovieLists() {
		return movieLists;
	}
	public void setMovieLists(List<MovieList> movieLists) {
		this.movieLists = movieLists;
	}
	
	// ToString
	
	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", movie_title=" + movie_title + ", movie_description="
				+ movie_description + ", movie_genre=" + movie_genre + "]";
	}

	
	
	
}
