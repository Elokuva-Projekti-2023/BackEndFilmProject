package ohjelmointi2.BackEndFilmApp.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long> {
	User findByUserId(Long userId);
	//User findByUser_email (String user_email); 
	
	User findByUserName(String userName);// tätä tarvitaan userdetailserviceen
}
