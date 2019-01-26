package com.cheekyblinders.BootTest.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		if ("user".equals(authentication.getPrincipal()) && "1234".equals(authentication.getCredentials())) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new GrantedAuthority() {
				@Override
				public String getAuthority() {
					return "ROLE_READ";
				}
			});
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken("user", "1234", authorities);
			
			return auth;
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}

}
