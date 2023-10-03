package ohjelmointi2.BackEndFilmApp.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieListResponse {
	
    @JsonProperty("results")
    private List<Movie> results;

	public List<Movie> getResults() {
		return results;
	}

	public void setResults(List<Movie> results) {
		this.results = results;
	}

}
