package ohjelmointi2.BackEndFilmApp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ohjelmointi2.BackEndFilmApp.domain.FavoritesList;
import ohjelmointi2.BackEndFilmApp.domain.User;
import ohjelmointi2.BackEndFilmApp.domain.UserRepository;


@SpringBootApplication
public class BackEndFilmAppApplication {
	private static final Logger log = LoggerFactory.getLogger(BackEndFilmAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackEndFilmAppApplication.class, args);
	}
	
	
}
