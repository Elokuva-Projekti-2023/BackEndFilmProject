package ohjelmointi2.BackEndFilmApp.domain;

import jakarta.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String user_email;

    @JsonIgnore
    @Column(name = "user_password")
    private String user_password;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private FavoritesList favoritesList;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private OnWatchList onWatchList;
    
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private AboutToWatchList aboutToWatchList;

    public User(String userName, String user_email, String user_password) {
        this.userName = userName;
        this.user_email = user_email;
        setUser_password(user_password);

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

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = PASSWORD_ENCODER.encode(user_password);
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

	public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
