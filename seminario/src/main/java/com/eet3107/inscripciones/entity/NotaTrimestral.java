package com.eet3107.inscripciones.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Setter @Getter
@NoArgsConstructor
public class NotaTrimestral  {
	

@Id @GeneratedValue
private Integer idNotas;


@ManyToOne
@JoinColumn(name="id_materia")
private Materia  materia;

@Column
private Integer trimestre;
	
@Column
private Integer nota;
	
}
