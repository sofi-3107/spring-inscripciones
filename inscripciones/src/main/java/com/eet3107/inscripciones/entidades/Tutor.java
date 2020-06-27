package com.eet3107.inscripciones.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="tutor")
@Table
@Getter @Setter @NoArgsConstructor @EqualsAndHashCode
public class Tutor extends Persona {
	
	
	/*@Column(name="idTutor")
	@Id 
	@GeneratedValue
	private Integer idTutor;*/

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column
	private String parentezco;
	
	


//	@OneToMany(mappedBy="tutor",cascade=CascadeType.ALL)
//	private List<Alumno>alumnosACargo;


	
	
	
}
