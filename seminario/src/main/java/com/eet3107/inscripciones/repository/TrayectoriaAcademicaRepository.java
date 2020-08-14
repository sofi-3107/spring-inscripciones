package com.eet3107.inscripciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;


@Repository
public interface TrayectoriaAcademicaRepository extends CrudRepository<TrayectoriaAcademica,Integer>{
	
	List<TrayectoriaAcademica>findAllByCursoAndFechaInscripcion(Curso curso,String fechaInscripcion); 

	
}
