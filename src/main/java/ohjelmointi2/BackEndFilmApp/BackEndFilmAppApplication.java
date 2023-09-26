package ohjelmointi2.BackEndFilmApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ohjelmointi2.BackEndFilmApp.domain.User;
import ohjelmointi2.BackEndFilmApp.domain.UserRepository;


@SpringBootApplication
public class BackEndFilmAppApplication {
	private static final Logger log = LoggerFactory.getLogger(BackEndFilmAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackEndFilmAppApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner ticketapplication(UserRepository userrepository) {
		return (args) -> {
			log.info("save a user");
			User user1 = new User("usernameAnna","anna@mail.com", "password");
			userrepository.save(user1);
			User user2 = new User("usernameMatti","matti@mail.com", "password");
			userrepository.save(user2);
			User user3 = new User("usernameTiina","tiina@mail.com", "password");
			userrepository.save(user3);
			
			for (User appuser : userrepository.findAll()) {
				log.info(appuser.toString());
			}

};
	}
}
