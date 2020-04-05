package com.eet3107.inscripciones.services;

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

import com.eet3107.inscripciones.entidades.Usuario;
import com.eet3107.inscripciones.repositorios.UsuarioRepository;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UsuarioRepository rep;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user=rep.findByUserName(username);
		List<GrantedAuthority>roles=new ArrayList();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		return new User(user.getUserName(),user.getPassword(),roles);
	}

}
	