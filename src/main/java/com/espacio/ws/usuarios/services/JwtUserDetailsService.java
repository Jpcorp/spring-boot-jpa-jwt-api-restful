package com.espacio.ws.usuarios.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.espacio.ws.usuarios.models.UsuarioModel;
import com.espacio.ws.usuarios.repositories.UsuarioRepository;
import com.espacio.ws.usuarios.security.UpdatableBCrypt;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Value("${spring.security.user.name}")
	private String secret;
	
	@Value("${spring.security.user.password}")
	private String secretPassword;
	
	private static final UpdatableBCrypt bcrypt = new UpdatableBCrypt(11);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails credential;
		
		UsuarioModel user = usuarioRepository.findByUsername(username);
		if (user == null) {
			
			if (secret.equals(username)) {
				credential =  new User(secret, secretPassword, new ArrayList<>());
			} else {
				throw new UsernameNotFoundException("User not found with username: " + username);
			}
			
		} else {
			String passwdBcrypt = bcrypt.hash(user.getPassword());
			user.setLastLogin(LocalDateTime.now());
			usuarioRepository.findById(user.getID());
			credential = new User(user.getUsername(), passwdBcrypt, new ArrayList<>());
		}
		return credential;
	}

}