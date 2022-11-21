package com.espacio.ws.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class UsuariosApplication implements CommandLineRunner {
	
	
	
	@Autowired
	JdbcTemplate template;

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		template.execute("INSERT INTO USUARIOS (NAME, EMAIL, PASSWORD, CREATED, MODIFIED, IS_ACTIVE, LAST_LOGIN ) "
				+ "VALUES ('Juan Pablo', 'ju.pablo@juan.org', 'hunter2', '2021-10-08 21:00:23', '2021-11-08 22:00:00', 1, '2021-11-08 22:00:00') ");
		
		template.execute("INSERT INTO PHONES (NUMBER, CITYCODE, COUNTRYCODE, USUARIOS_ID, CREATED) "
				+ "VALUES (1234567, 1, 57, 1, '2021-10-08 22:12:23') ");
		
		template.execute("INSERT INTO PHONES (NUMBER, CITYCODE, COUNTRYCODE, USUARIOS_ID, CREATED, MODIFIED) "
				+ "VALUES (7654321, 21, 5, 1, '2021-11-08 23:10:23', '2021-10-08 22:00:00') ");
		
		
		
	}

}
