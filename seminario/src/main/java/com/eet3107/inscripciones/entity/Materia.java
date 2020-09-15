package com.eet3107.inscripciones.entity;


import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Getter @Setter
@EqualsAndHashCode @NoArgsConstructor
public class Materia {

	
	@Column(name="id_materia") @Id @GeneratedValue
	private Integer idMateria;
	
	@Column
	@Length(max=30)
	private String nombre;
	


	
	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name="materia_curso",
			joinColumns=@JoinColumn(name="id_materia"),
			inverseJoinColumns=@JoinColumn(name="id_curso")
			)
	private Set<Curso> curso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private TrayectoriaAcademica pendiente;
	
	

	

	


	
	
}
