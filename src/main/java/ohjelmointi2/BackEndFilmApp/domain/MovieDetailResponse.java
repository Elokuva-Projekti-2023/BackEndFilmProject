package ohjelmointi2.BackEndFilmApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailResponse {

	@JsonProperty("genre")
    private Genres[] genres;
    private Long id;
    private String overview;
    private String release_date;
    private String title;
    
    // getters and setters
    
	public Genres[] getGenres() {
		return genres;
	}
	public void setGenres(Genres[] genres) {
		this.genres = genres;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

    
	
}
