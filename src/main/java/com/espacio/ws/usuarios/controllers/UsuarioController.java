package com.espacio.ws.usuarios.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.User;

import com.espacio.ws.usuarios.JwtRequest;
import com.espacio.ws.usuarios.Response;
import com.espacio.ws.usuarios.ResponseUtils;
import com.espacio.ws.usuarios.exceptions.ResponseException;
import com.espacio.ws.usuarios.models.UsuarioModel;
import com.espacio.ws.usuarios.security.jwt.JwtTokenUtil;
import com.espacio.ws.usuarios.services.UsuarioService;

import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("usuario")
@Validated // class level
@CrossOrigin
public class UsuarioController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UsuarioService usuarioService;

	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> obtenerUsuarios() throws Exception {
		log.debug("Entrando endpoint obtener usuarios ");
		try {
			
			ArrayList<UsuarioModel> usuarios = usuarioService.getAllUsuarios();
			return new ResponseEntity<>(usuarios, HttpStatus.OK);

		} catch (ResponseException e) {
			log.error("problemas al obtener usuarios, message: {}", e.getMensaje());
			return new ResponseEntity<>(e, HttpStatus.CONFLICT);
		}
	}

	@PostMapping()
	public ResponseEntity<Object> guardarUsuario(@Valid @RequestBody UsuarioModel usuario) throws Exception {
		log.debug("Entrando endpoint guardar usuarios ");
		
		try {
			return new ResponseEntity<>(usuarioService.saveUsuario(usuario), HttpStatus.OK);

		} catch (ResponseException e) {
			log.error("problemas al guardar usuario, message: {}", e.getMensaje(), e);
			Response response = new Response(e.getMensaje());
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUsuario(@PathVariable Long id) {
		return null; 
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteUsuario(@PathVariable Long id) {
		log.debug("Entrando endpoint eliminar usuarios ");
		boolean result = usuarioService.deleteById(id);
		Response response = new Response();
		if (!result) {
			response.setMensaje(ResponseUtils.MSG_NOT_DELETE);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
		log.info("Usuario ID {} fue eliminado", id);
		response.setMensaje(ResponseUtils.MSG_OK_DELETE);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
