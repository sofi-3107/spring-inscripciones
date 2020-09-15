package com.eet3107.inscripciones.repository;



import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.MateriaAlumnoCursoDetail;


public interface MateriaAlumnoCursoDetailRepository extends CrudRepository<MateriaAlumnoCursoDetail,Integer>{
	
	/*Parq obtener los idAlumno que cumplan esa condicion y obtener el cupo actual del curso*/
	//List<Alumno>findByAnioLectivoAndNombreCursoAndDivisionCursoAndCicloCursoAndTurno(String anioLectivo,String nombreCurso,String division,String ciclo,Character turno);
	
	/*Devolviendo esta coleccion por ajax se puede iterar y acada materia se le toma el nombre y la nota del trimestre correspondiente*/
	
	List<Alumno>findByIsRepitenteAndNombreCursoAndDivisionCursoAndCicloCursoAndTurnoAndAnioLectivo(Boolean isRepitente,String nombreCurso, String divisionCurso,String cicloCurso, Character turno,String anioLectivo);
	
	List<MateriaAlumnoCursoDetail>findByAnioLectivoAndNombreCursoAndDivisionCursoAndCicloCursoAndTurno(String anioLectivo,String nombreCurso,String division,String ciclo,Character turno);
	
	
}
