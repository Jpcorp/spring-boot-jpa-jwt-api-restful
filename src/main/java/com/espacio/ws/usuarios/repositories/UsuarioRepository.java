package com.espacio.ws.usuarios.repositories;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.espacio.ws.usuarios.models.UsuarioModel;

// CrudRepository
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioModel, Long> {

    @Query(value="SELECT ID, CREATED, EMAIL, IS_ACTIVE, MODIFIED, NAME, LAST_LOGIN TOKEN, USERNAME, PASSWORD "
    		+ "FROM USUARIOS  WHERE USERNAME = :username",nativeQuery=true)
	UsuarioModel findByUsername(String username);

}
