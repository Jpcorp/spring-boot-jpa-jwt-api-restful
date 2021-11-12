package com.espacio.ws.usuarios.services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.espacio.ws.usuarios.JwtRequest;
import com.espacio.ws.usuarios.ResponseUtils;
import com.espacio.ws.usuarios.exceptions.ResponseException;
import com.espacio.ws.usuarios.models.UsuarioModel;
import com.espacio.ws.usuarios.repositories.UsuarioRepository;
import com.espacio.ws.usuarios.security.jwt.JwtTokenUtil;

@Service
public class UsuarioService {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	public ArrayList<UsuarioModel> getAllUsuarios() throws Exception {
		
		ArrayList<UsuarioModel> response = new ArrayList<>();
		try {
			response = (ArrayList<UsuarioModel>) usuarioRepository.findAll();
		} catch (Exception e) {
			log.error("Exception: {}", e.getMessage(), e);
			throw new ResponseException(ResponseUtils.MSG_ERROR);
		}
		return response;
	}

	public UsuarioModel saveUsuario(UsuarioModel usuario) throws Exception {
		UsuarioModel response = null;

		try {
			JwtRequest jwtRequest = new JwtRequest(usuario.getUsername(), usuario.getPassword());			
			final UserDetails userDetails = loadUserByUsername(jwtRequest.getUsername(), usuario.getPassword());
			final String token = jwtTokenUtil.generateToken(userDetails);
			usuario.setToken(token);
			usuario.setUsername(jwtRequest.getUsername());
			usuario.setIsActive(true);
			
			response = usuarioRepository.save(usuario);

		} catch (DataIntegrityViolationException e) {
			log.error("Exception: {}", e.getMessage(), e);
			throw new ResponseException(ResponseUtils.MSG_EMAIL);
		}
		return response;
	}
	
	private UserDetails loadUserByUsername(String username, String password) {
		return new User(username, password, new ArrayList<>());
	}

	public boolean deleteById(Long id) {
		Boolean result = false;
		try {
			usuarioRepository.deleteById(id);
			result = true;

		} catch (Exception e) {
			log.error("Exception: {}", e.getMessage(), e);
			return result;
		}
		return result;
	}


}
