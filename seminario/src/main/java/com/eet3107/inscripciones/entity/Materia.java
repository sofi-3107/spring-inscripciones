package com.eet3107.inscripciones.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@EqualsAndHashCode @NoArgsConstructor
public class Materia {

	
	@Column @Id @GeneratedValue
	private Integer id;
	
	@Column
	private String nombre;
	
	
	//@ManyToOne
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idPe")
	private PlanDeEstudios planDeEstudios;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TrayectoriaAcademica pendiente;
	
	@OneToMany(mappedBy="materia",cascade=CascadeType.ALL)
	private List<NotaTrimestral>notas;


	
	
}
