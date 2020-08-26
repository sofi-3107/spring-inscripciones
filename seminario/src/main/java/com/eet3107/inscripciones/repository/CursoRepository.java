package com.eet3107.inscripciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso,String>{

public Curso findBynombreCursoAndDivisionAndCicloAndTurno(String nombreCurso,String division,String ciclo,Character character);
public List<Curso> findAllBynombreCursoAndDivisionAndCicloAndTurno(String nombreCurso,String division,String ciclo,Character character);
public List<Curso> findAllBynombreCursoAndCicloAndTurno(String nombreCurso,String ciclo,Character turno);


}
