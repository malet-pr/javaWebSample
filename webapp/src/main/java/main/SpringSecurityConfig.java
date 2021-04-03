package main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
			.antMatchers("/courses").hasAnyRole("ADMIN","STUDENT")
			.antMatchers("/admin-courses/**").hasAnyRole("ADMIN")
			.antMatchers("/admin-professors/**").hasAnyRole("ADMIN")
			.antMatchers("/admin-subjects/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
			.and()
			.logout().permitAll();
	}

	@Autowired
	public void ConfigurerGlobal(AuthenticationManagerBuilder build) throws Exception {	
		build.userDetailsService(userDetailsService)
			.passwordEncoder(passswordEncoder);
	}
	
}
