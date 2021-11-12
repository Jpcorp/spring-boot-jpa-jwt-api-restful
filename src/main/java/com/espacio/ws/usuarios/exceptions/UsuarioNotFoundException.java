package com.espacio.ws.usuarios.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UsuarioNotFoundException(Long id)
	{
		super("El identificador del usuario no encontrado: " + id);
	}

}
