package com.eet3107.inscripciones.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

//@Entity
public class ContactoDeEmergencia extends Persona {

	@Column
	private String parentezco;
	
	public String getParentezco() {
		return parentezco;
	}

	public void setParentezco(String parentezco) {
		this.parentezco = parentezco;
	}

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	@ManyToMany(cascade= {CascadeType.ALL},mappedBy="contactosEm")
	private Set<Alumno>alumnos;

	public ContactoDeEmergencia() {
	}
	
	
}
