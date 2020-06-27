package com.eet3107.inscripciones.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="legajo")
@Getter @Setter @NoArgsConstructor
@EqualsAndHashCode
public class Legajo {
	
	@Column @Id @GeneratedValue
	private Integer idLegajo;
	
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="id")
	@MapsId
	private Alumno alumno;
	
	@OneToMany(mappedBy="legajo",cascade=CascadeType.ALL)
	private Set<TrayectoriaAcademica>inscripciones;
	
	

}
