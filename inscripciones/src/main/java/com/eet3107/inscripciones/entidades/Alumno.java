package com.eet3107.inscripciones.entidades;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Alumno {
	
	@Column
	@Id 
	@GeneratedValue
	private int id;
	
	@Column
	@NotBlank(message="Este campo es obligatorio")
	private String nombre;
	
	@Column
	@NotBlank(message="Este campo es obligatorio")
	private String apellido;
	
	@Column
	@NotBlank(message="Este campo es obligatorio")
	private String dni;
	
	@Column
	private String telefono;
	
	@Column
	@Email(message="Introduce un correo valido")
	private String mail;
	
	@Column 
	@Temporal(TemporalType.DATE)
	private Date nacimiento;

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public Alumno() {
		
	}


}
