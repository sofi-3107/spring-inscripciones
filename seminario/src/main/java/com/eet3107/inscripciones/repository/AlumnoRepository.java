package com.eet3107.inscripciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entity.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno,Integer>{
	
	

}
