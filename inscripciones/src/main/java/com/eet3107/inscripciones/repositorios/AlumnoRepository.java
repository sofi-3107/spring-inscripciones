package com.eet3107.inscripciones.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entidades.Alumno;
import com.eet3107.inscripciones.entidades.Persona;

@Repository
public interface AlumnoRepository extends CrudRepository<Persona,Integer>{

//	public Alumno findByDni(String dni);
//	
//	public Alumno findByNombreAndApellido(String nombre,String apellido);
//	
	public Alumno findById(int id);
	
	
}
