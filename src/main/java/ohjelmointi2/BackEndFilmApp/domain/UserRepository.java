package ohjelmointi2.BackEndFilmApp.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
	
	
	Optional<User> findByfirebaseUid(String firebaseUid);
	//User findByUser_email (String user_email); 


}
