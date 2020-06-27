package com.eet3107.inscripciones.entidades;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name="legajo")
@Entity
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
public class Legajo {


	@Column(name="id_legajo")
	@Id
	@GeneratedValue
	private Integer idLegajo;
	
	

//	@OneToOne(mappedBy="legajo" )
//	@PrimaryKeyJoinColumn
//	private Alumno alumno;
	
	@Column
	private String curso;



}
