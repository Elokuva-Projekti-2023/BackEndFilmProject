package ohjelmointi2.BackEndFilmApp.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
<<<<<<< HEAD
=======
	User findByUserId(Long userId);
	//User findByUser_email (String user_email); 
>>>>>>> 111f4a2170d9b1a73ad7190228c03671d0fb8607
	
	
	Optional<User> findByfirebaseUid(String firebaseUid);
	//User findByUser_email (String user_email); 


}
