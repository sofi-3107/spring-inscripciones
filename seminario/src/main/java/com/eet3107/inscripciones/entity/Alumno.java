package com.eet3107.inscripciones.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="alumno")
@Getter @Setter
@NoArgsConstructor 
public class Alumno {
	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	@Column
	@Length(max=25)
	private String apellido;
	
	@Column
	@Length(max=25)
	private String nombre;
	
	@Column
	@Length(max=15)
	private String fechaNacimiento;
	
	@Column(length=8)
	private String dni;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy="alumno")
	private Legajo legajo;

	
	

}
