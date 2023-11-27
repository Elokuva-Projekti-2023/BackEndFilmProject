package ohjelmointi2.BackEndFilmApp.domain;

public class SignInRequest {

	private String idToken;
    private String email;
    private String password;
    private String firebaseUid;

	public String getIdToken() {
		return idToken;
	}

	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirebaseUid() {
		return firebaseUid;
	}

	public void setFirebaseUid(String firebaseUid) {
		this.firebaseUid = firebaseUid;
	}
	
	
}
