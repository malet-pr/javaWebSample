package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import main.service.UserDetailsServiceImplement;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private BCryptPasswordEncoder passswordEncoder;
	
	@Autowired
	private UserDetailsServiceImplement userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/","/home","/css/**","/js/**","/img/**").permitAll()
			.antMatchers("/new-course").hasAnyRole("ADMIN")
			.antMatchers("/edit-courses").hasAnyRole("ADMIN")
			.antMatchers("/professors").hasAnyRole("ADMIN")
			.antMatchers("/subjects").hasAnyRole("ADMIN")
			.antMatchers("/select-professor").hasAnyRole("ADMIN")
			.antMatchers("/select-subject").hasAnyRole("ADMIN")
			.antMatchers("/courses").hasAnyRole("ADMIN","STUDENT")
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
			.and()
			.logout().permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/error_403");
	}

	@Autowired
	public void ConfigurerGlobal(AuthenticationManagerBuilder build) throws Exception {	
		build.userDetailsService(userDetailsService)
			.passwordEncoder(passswordEncoder);
	}
	
}
