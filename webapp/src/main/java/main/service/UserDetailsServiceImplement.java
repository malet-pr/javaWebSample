package main.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import main.model.UserSys;
import main.model.Role;
import main.repository.UserSysRepository;

@Service
public class UserDetailsServiceImplement implements UserDetailsService {
	
	@Autowired
	private UserSysRepository userSysRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserSys userSys = userSysRepository.getByUsername(username);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role: userSys.getAuthorities()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		}		
		return new User(userSys.getUsername(), userSys.getPassword(),userSys.getEnabled(), true,true,true, authorities);
	}
}

/*
User(String username,
    String password,
    boolean enabled,
    boolean accountNonExpired,
    boolean credentialsNonExpired,
    boolean accountNonLocked,
    Collection<? extends GrantedAuthority> authorities)
*/