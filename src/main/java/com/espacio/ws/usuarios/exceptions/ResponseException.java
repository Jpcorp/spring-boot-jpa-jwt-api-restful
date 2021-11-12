package com.espacio.ws.usuarios.exceptions;

public class ResponseException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	 
	public ResponseException() {
		// TODO Auto-generated constructor stub
	}
	
	public ResponseException(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
