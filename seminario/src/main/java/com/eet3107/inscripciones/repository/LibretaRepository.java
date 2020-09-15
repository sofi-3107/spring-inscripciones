package com.eet3107.inscripciones.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Libreta;
import com.eet3107.inscripciones.entity.Materia;

public interface LibretaRepository extends CrudRepository<Libreta,Integer>{
	
	
	List<Libreta>findByCursoAndMateriasAndTrimestreAndAnioLectivo(Curso curso,Materia materia,Integer trimestre,String anioLectivo);
	/* con la lista de materias del plan de estudio por cada elemento ejecutamos este método y analizamos las notas si aprobados o 
	 * desaprobados y guardamos en un contador*/
	
	List<Libreta>findByCursoAndAnioLectivo(Curso curso,String anioLectivo);
	

}
