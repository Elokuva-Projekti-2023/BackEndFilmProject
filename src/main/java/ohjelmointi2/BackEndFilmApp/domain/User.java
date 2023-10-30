package ohjelmointi2.BackEndFilmApp.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
	@Column(name="user_password")
	private String user_password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MovieList> movieLists = new ArrayList<>();
    
	
    public User() {
		super();
	}
    
    /*
	public User(String user_name, String user_email, String user_password) {
		super();
		this.userName = userName;
		this.user_email = user_email;
		this.user_password = user_password;
	}

	*/
	

	public User(String userName, String user_email, String user_password) {
		super();
		this.userName = userName;
		this.user_email = user_email;
		setUser_password(user_password);
	}


	public User(String userName, String user_password) {
		super();
		this.userName = userName;
		this.user_password = user_password;
	}


	/*public User(String user_name, String user_password) {
		super();
		this.user_name = user_name;
		this.user_password = user_password;
	}*/


	// getters and setters 
    
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	/*
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}*/
	
	public String getUser_email() {
		return user_email;
	}
	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_password() {
		return user_password;
	}
	/*
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}*/
		
		public void setUser_password(String user_password) {
			this.user_password = PASSWORD_ENCODER.encode(user_password);
		}
		
	
	public void setMovieLists(List<MovieList> movieLists) {
		this.movieLists = movieLists;
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<MovieList> getMovieLists() {
	    return movieLists;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", userName=" + userName + ", user_email=" + user_email + ", user_password="
				+ user_password + "]";
	}

	
	//ToString
	/*
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_email=" + user_email
				+ ", user_password=" + user_password + "]";
	}*/
	
	
	
    
    
}
