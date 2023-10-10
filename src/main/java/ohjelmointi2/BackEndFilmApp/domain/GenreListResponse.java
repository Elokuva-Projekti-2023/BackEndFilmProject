package ohjelmointi2.BackEndFilmApp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GenreListResponse {
	
    @JsonProperty("genres")
    private List<Genres> genres;
    
    //getters and setters

	public List<Genres> getGenres() {
		return genres;
	}

	public void setGenres(List<Genres> genres) {
		this.genres = genres;
	}

    
}
