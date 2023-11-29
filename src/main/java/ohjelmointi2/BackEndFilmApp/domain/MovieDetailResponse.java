package ohjelmointi2.BackEndFilmApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDetailResponse {


    private Long id;
    private String overview;
    private String release_date;
    private String title;
	private String poster_path;
	private String original_title;
	private double vote_average;
	private int vote_count;
	
    // getters and setters
    

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

    
	
}
