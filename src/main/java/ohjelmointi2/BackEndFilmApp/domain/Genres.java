package ohjelmointi2.BackEndFilmApp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Genres {

	@Id
	@JsonProperty("id")
	private Long genre_id;
	
	@JsonProperty("name")
	private String genre_name;
	
	
	
	// getters and setters

	public Long getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(Long genre_id) {
		this.genre_id = genre_id;
	}

	public String getGenre_name() {
		return genre_name;
	}

	public void setGenre_name(String genre_name) {
		this.genre_name = genre_name;
	}
	
	// ToString

	@Override
	public String toString() {
		return "Genres [genre_id=" + genre_id + ", genre_name=" + genre_name + "]";
	}
	
	
	
}
