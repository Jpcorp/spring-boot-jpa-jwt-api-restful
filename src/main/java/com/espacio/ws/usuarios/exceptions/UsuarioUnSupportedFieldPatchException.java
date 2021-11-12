package com.espacio.ws.usuarios.exceptions;

import java.util.Set;

public class UsuarioUnSupportedFieldPatchException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsuarioUnSupportedFieldPatchException(Set<String> keys) {
		super("El campo " + keys.toString() + " no permite la modificacion");
	}

}
