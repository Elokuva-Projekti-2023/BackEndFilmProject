package ohjelmointi2.BackEndFilmApp.domain;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Movie {
	
	@Id
	@JsonProperty("id")
	private Long movie_id;
	
	@JsonProperty("title")
	private String movie_title;
	
	@JsonProperty("overview")
	private String movie_description;
	
	@JsonProperty("genre_ids")
	private String[] movie_genre;
	
	@JsonProperty("poster_path")
	private String poster_path;
	
	@JsonProperty("original_title")
	private String original_title;
	
	@JsonProperty("release_date")
	private String release_date;

	@JsonProperty("vote_average")
	private double vote_average;
	
	@JsonProperty("vote_count")
	private int vote_count;
	
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
	public String[] getMovie_genre() {
		return movie_genre;
	}
	public void setMovie_genre(String[] movie_genre) {
		this.movie_genre = movie_genre;
	}
	
	public List<MovieList> getMovieLists() {
		return movieLists;
	}
	public void setMovieLists(List<MovieList> movieLists) {
		this.movieLists = movieLists;
	}
	
	
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public double getVote_average() {
		return vote_average;
	}
	public void setVote_average(double vote_average) {
		this.vote_average = vote_average;
	}
	public int getVote_count() {
		return vote_count;
	}
	public void setVote_count(int vote_count) {
		this.vote_count = vote_count;
	}
	
	
	// ToString 
	
	@Override
	public String toString() {
		return "Movie [movie_id=" + movie_id + ", movie_title=" + movie_title + ", movie_description="
				+ movie_description + ", movie_genre=" + Arrays.toString(movie_genre) + ", poster_path=" + poster_path
				+ ", original_title=" + original_title + ", release_date=" + release_date + ", vote_average="
				+ vote_average + ", vote_count=" + vote_count + ", movieLists=" + movieLists + "]";
	}
	

	
}
