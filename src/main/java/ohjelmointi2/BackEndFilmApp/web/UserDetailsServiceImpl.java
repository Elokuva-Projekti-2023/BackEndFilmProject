package ohjelmointi2.BackEndFilmApp.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ohjelmointi2.BackEndFilmApp.domain.User;
import ohjelmointi2.BackEndFilmApp.domain.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	private final UserRepository usersRepo;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository usersRepo) {
		this.usersRepo = usersRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		log.info("Load user by username: " + userName);
		User curruser = usersRepo.findByUserName(userName);
		log.info("Käyttäjä ID: " + curruser.getUser_id());
		
		log.info("Current user: " + curruser.toString());
		List<String> authorities = new ArrayList<>();
        authorities.add("ROLE_USER");
        authorities.add("ROLE_CUSTOM");

        // Create the UserDetails object with the authorities
        UserDetails user = new org.springframework.security.core.userdetails.User(userName, curruser.getUser_password(), AuthorityUtils.createAuthorityList(authorities.toArray(new String[0])));
		//UserDetails user = new org.springframework.security.core.userdetails.User(userName, curruser.getUser_password(), AuthorityUtils.createAuthorityList);
		log.info("user: " + user.toString());
		
		return user;
	}
}