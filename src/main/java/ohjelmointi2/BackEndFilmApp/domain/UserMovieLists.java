package ohjelmointi2.BackEndFilmApp.domain;

public class UserMovieLists {
	private FavoritesList favoritesList;
    private AboutToWatchList aboutToWatchList;
    private OnWatchList onWatchList;
	public FavoritesList getFavoritesList() {
		return favoritesList;
	}
	public void setFavoritesList(FavoritesList favoritesList) {
		this.favoritesList = favoritesList;
	}
	public AboutToWatchList getAboutToWatchList() {
		return aboutToWatchList;
	}
	public void setAboutToWatchList(AboutToWatchList aboutToWatchList) {
		this.aboutToWatchList = aboutToWatchList;
	}
	public OnWatchList getOnWatchList() {
		return onWatchList;
	}
	public void setOnWatchList(OnWatchList onWatchList) {
		this.onWatchList = onWatchList;
	}
	public UserMovieLists(FavoritesList favoritesList, AboutToWatchList aboutToWatchList, OnWatchList onWatchList) {
		super();
		this.favoritesList = favoritesList;
		this.aboutToWatchList = aboutToWatchList;
		this.onWatchList = onWatchList;
	}
	
	
	public UserMovieLists() {
		super();
	}
	@Override
	public String toString() {
		return "UserMovieLists [favoritesList=" + favoritesList + ", aboutToWatchList=" + aboutToWatchList
				+ ", onWatchList=" + onWatchList + "]";
	}
	
    
    
    
}
