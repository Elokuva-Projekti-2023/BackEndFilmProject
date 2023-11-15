package ohjelmointi2.BackEndFilmApp.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

   // public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    
    
    @Column(name = "firebase_uid", unique = true)  // Firebase
    private String firebaseUid;

    

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String user_email;


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private FavoritesList favoritesList;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private OnWatchList onWatchList;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private AboutToWatchList aboutToWatchList;
    
    // constructors

    public User(String firebaseUid, String userName, String user_email) {
    	this.firebaseUid = firebaseUid;
        this.userName = userName;
        this.user_email = user_email;

        // Create a new FavoritesList and associate it with the user
        this.favoritesList = new FavoritesList();
        this.favoritesList.setUser(this);
        
        // Create a new OnWatchList and associate it with the user
        this.onWatchList = new OnWatchList();
        this.onWatchList.setUser(this);
        
        // Create a new AboutToWatchList and associate it with the user
        this.aboutToWatchList = new AboutToWatchList();
        this.aboutToWatchList.setUser(this);
    }


	public User() {
        super();
    }

	
	
    public String getFirebaseUid() {
		return firebaseUid;
	}


	public void setFirebaseUid(String firebaseUid) {
		this.firebaseUid = firebaseUid;
	}


	public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    
    public FavoritesList getFavoritesList() {
        return favoritesList;
    }

    public void setFavoritesList(FavoritesList favoritesList) {
        this.favoritesList = favoritesList;
    }
    

    public OnWatchList getOnWatchList() {
		return onWatchList;
	}

	public void setOnWatchList(OnWatchList onWatchList) {
		this.onWatchList = onWatchList;
	}

	public AboutToWatchList getAboutToWatchList() {
		return aboutToWatchList;
	}

	public void setAboutToWatchList(AboutToWatchList aboutToWatchList) {
		this.aboutToWatchList = aboutToWatchList;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
