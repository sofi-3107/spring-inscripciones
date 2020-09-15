package com.eet3107.inscripciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Materia;

@Repository
public interface MateriaRepository extends CrudRepository<Materia,Integer>{

	
	
	public List<Materia>findByCurso(Curso curso);
}
