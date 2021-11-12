package com.espacio.ws.usuarios.repositories;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espacio.ws.usuarios.models.UsuarioModel;

// CrudRepository
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

	UsuarioModel findByUsername(String username);
	
}
