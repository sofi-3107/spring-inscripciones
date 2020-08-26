package com.eet3107.inscripciones.repository;



import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.MateriaAlumnoCursoDetail;


public interface MateriaAlumnoCursoDetailRepository extends CrudRepository<MateriaAlumnoCursoDetail,Integer>{

	public Set<Materia>findByAlumnoAndAnioLectivo(String dniAlumno,String anioLectivo);
	//Tiene que devolver el Set materiaNotas, que sería la libreta de calificaciones del alumno
	
	/*Parq obtener los idAlumno que cumplan esa condicion y obtener el cupo actual del curso*/
	List<Alumno>findByAnioLectivoAndNombreCursoAndDivisionCursoAndCicloCursoAndTurno(String anioLectivo,String nombreCurso,String division,String ciclo,Character turno);
	
	
}
