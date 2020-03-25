package com.eet3107.inscripciones.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.eet3107.inscripciones.entidades.Alumno;

import antlr.collections.List;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno,Integer>{

	public Alumno findByDni(String dni);
	
	public Alumno findByNombreAndApellido(String nombre,String apellido);
	
	
}
