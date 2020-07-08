package com.eet3107.inscripciones.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Setter @Getter
@NoArgsConstructor
public class NotaTrimestral implements Serializable {
	

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id 
@ManyToOne
@JoinColumn(name="id")
private Materia  materia;

@Id @Column
private Integer trimestre;
	
@Column
private Integer nota;
	
}
