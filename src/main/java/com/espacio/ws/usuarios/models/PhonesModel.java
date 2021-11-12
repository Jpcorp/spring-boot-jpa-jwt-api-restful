package com.espacio.ws.usuarios.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "phones")
public class PhonesModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false )
	private Long id;
	
	private int number; 
	private int citycode;
	private int countrycode;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "usuarios_id")
	private UsuarioModel usuarioModel;
	
	@CreationTimestamp
	private LocalDateTime created;
	
	@UpdateTimestamp
    private LocalDateTime modified;
	
	public PhonesModel() {
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getCitycode() {
		return citycode;
	}
	
	public void setCitycode(int citycode) {
		this.citycode = citycode;
	}
	
	public int getCountrycode() {
		return countrycode;
	}
	
	public void setCountrycode(int countrycode) {
		this.countrycode = countrycode;
	}
	
	public UsuarioModel getUsuarioModel() {
		return usuarioModel;
	}

	public void setUsuarioModel(UsuarioModel usuarioModel) {
		this.usuarioModel = usuarioModel;
	}
	
}
