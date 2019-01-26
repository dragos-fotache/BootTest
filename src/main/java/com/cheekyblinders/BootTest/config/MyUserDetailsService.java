package com.cheekyblinders.BootTest.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MyUserDetailsService implements UserDetailsService {

	@Value("${security.user}")
	private String user;

	@Value("${security.password}")
	private String password;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (StringUtils.equals(username, user)) {
			return User.withUsername(user)
					   .password(password)
					   .roles("READ")
					   .build();
		}
		throw new UsernameNotFoundException(username);
	}

}
