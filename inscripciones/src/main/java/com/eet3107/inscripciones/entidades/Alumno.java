package com.eet3107.inscripciones.entidades;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "alumno")
@Getter@Setter@ToString
@NoArgsConstructor @EqualsAndHashCode
public class Alumno extends Persona {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "idTutor")
	private Tutor tutor;

	@Temporal(TemporalType.DATE)
	private Date nacimiento;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private Legajo legajo;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "alumno_contactoEm", joinColumns = { @JoinColumn(name = "id_alumno") }, inverseJoinColumns = {
//			@JoinColumn(name = "id_contactoEm") })
//	private Set<ContactoDeEmergencia> contactosEm;


}
