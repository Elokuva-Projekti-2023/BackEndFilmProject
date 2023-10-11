package ohjelmointi2.BackEndFilmApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;
import ohjelmointi2.BackEndFilmApp.web.UserDetailsServiceImpl;



@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {
	
	@Autowired
    private UserDetailsServiceImpl userDetailsService;	
	
    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Exception {
      http
      .cors()
      .and()  
      .authorizeHttpRequests()
      .requestMatchers(toH2Console()).permitAll()
      .anyRequest().authenticated()
      .and()
      .csrf().ignoringRequestMatchers(toH2Console())
      .and()
      .headers().frameOptions().disable()
      .and()
		      .formLogin()
		          .defaultSuccessUrl("/api/tmdb/now-playing", true)
		          
		          .permitAll()
		          .and()
		      .logout()
		      
		          .permitAll()
		          .and()
		      .httpBasic()
		      .and()
		      .csrf().disable();
	      return http.build();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
    
    @Bean
	CorsConfigurationSource corsConfigurationSource()
	{
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("https://example.com"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}
}