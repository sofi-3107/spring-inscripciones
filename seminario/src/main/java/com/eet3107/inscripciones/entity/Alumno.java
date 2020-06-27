package com.eet3107.inscripciones.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="alumno")
@Getter @Setter
@NoArgsConstructor @EqualsAndHashCode
public class Alumno {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	private String apellido;
	
	@Column
	private String nombre;
	
	@Column
	private String dni;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	@MapsId
	private Legajo legajo;

}
