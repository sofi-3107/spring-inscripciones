package com.eet3107.inscripciones.entidades;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Domicilio {
	
	
	@Id
	@Column(name="id_domicilio")
	@GeneratedValue
	private Integer idDomicilio;
	
	
	@Column
	private String calle;
	
	
	@Column
	private String numero;
	
	


	public Integer getIdDomicilio() {
		return idDomicilio;
	}


	public void setIdDomicilio(Integer idDomicilio) {
		this.idDomicilio = idDomicilio;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public Domicilio() {
	}
	
	
	
	

}
