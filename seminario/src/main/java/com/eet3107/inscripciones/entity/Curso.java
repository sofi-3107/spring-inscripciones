package com.eet3107.inscripciones.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity @EqualsAndHashCode
@Getter @Setter @NoArgsConstructor
@ToString
public class Curso {
	


	@Id @Column(length=5)
	private String idCurso;
	
	@Column(name="curso")
	@Size(max=2)
	private String nombreCurso;
	
	
	@Column
	@Size(max=2)
	private String division;
	
	@Column
	private Character turno;
	
	@Column
	@Length(min=6,max=8)
	private String ciclo;
	
	@Column
	private Integer edadMax;

	@ManyToMany(mappedBy="curso")
	private Set<Materia>planDeEstudios;
	
	@Column
	private  Integer cupoMax=25;
	
	
	




	
	

}
