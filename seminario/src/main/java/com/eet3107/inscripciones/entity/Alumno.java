package com.eet3107.inscripciones.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="alumno")
@Getter @Setter
@NoArgsConstructor 
public class Alumno {
	
	
	
	@Column
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column
	@Length(max=25)
	@NotEmpty(message="Debe escribir su apellido")
	@Size(max=25,message="El apellido debe contener como máximo 25 caracteres")	
	private String apellido;
	
	@Column
	@Length(max=25)
	@Size(max=25,message="El nombre debe contener como máximo 25 caracteres y como mínimo 2")
	@NotEmpty(message="Debe escribir su nombre")
	private String nombre;
	
	@Column
	@Length(max=15)
	@NotEmpty(message="Debe escribir su fecha de nacimiento")
	private String fechaNacimiento;
	

	
	
	@Column(length=8)
	@Size(max=8,min=8,message="El dni debe tener 8 digitos sin puntos ")
	@NotEmpty(message="Debe escribir su dni")
	@Pattern(regexp="\\d+",message="Debe escribir en su dni solo los 8 números del mismo, sin puntos")// Esto \\d es digitos y el + q se puede repetir una o mas veces
	private String dni;
	
	
	
	@OneToMany(mappedBy="alumno",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)
	private Set<TrayectoriaAcademica> inscripciones;
	
	
	

}
