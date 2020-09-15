package com.eet3107.inscripciones.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;

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
	//@Size(max=2,message="error en nombrecurso size")
	private String nombreCurso;
	
	
	@Column
	//@Size(max=2,message="error en division size")
	private String division;
	
	@Column
	private Character turno;
	
	@Column
	//@Size(max=10,message="error en ciclo size")
	private String ciclo;
	
	@Column
	private Integer edadMax;
	
	@Column
	private Integer edadIdeal;

	@ManyToMany(mappedBy="curso")
	private List<Materia>planDeEstudios;
	
	@Column
	private  Integer cupoMax=25;
	
	
	




	
	

}
