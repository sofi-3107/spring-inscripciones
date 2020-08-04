package com.eet3107.inscripciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso,Integer>{

public Curso findByCursoAndDivisionAndCicloAndTurno(String curso,String division,String ciclo,Character character);
}
