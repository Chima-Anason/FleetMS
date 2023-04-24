package com.anagraceTech.FleetMS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .csrf().disable()
         .authorizeRequests()
         .antMatchers("/login", "/resources/**", "/assets/**", "/css/**", "/img/**", "/vendor/**").permitAll()
         .antMatchers("/register", "/resources/**", "/assets/**", "/css/**", "/img/**", "/js/**", "/vendor/**").permitAll()
         .antMatchers("/users/addNew").permitAll()
         .antMatchers("/security/user/Edit/**").hasAuthority("ADMIN")
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/login").permitAll()
         .defaultSuccessUrl("/index")
         .and()
         .logout().invalidateHttpSession(true)
         .clearAuthentication(true)
         .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
         .logoutSuccessUrl("/login").permitAll()
         .and()
         .exceptionHandling().accessDeniedPage("/accessDenied")
 ;
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		
		provider.setPasswordEncoder(passwordEncoder());
		
		return provider;
	}
	
	
	
	
	

}
