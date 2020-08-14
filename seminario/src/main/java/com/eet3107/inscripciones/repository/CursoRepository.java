package com.eet3107.inscripciones.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Materia;

@Repository
public interface CursoRepository extends CrudRepository<Curso,String>{

public Curso findBynombreCursoAndDivisionAndCicloAndTurno(String nombreCurso,String division,String ciclo,Character character);

public Set<Materia>findByIdCurso(String idCurso);
}
