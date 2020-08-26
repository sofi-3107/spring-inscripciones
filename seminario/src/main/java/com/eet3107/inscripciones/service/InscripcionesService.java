package com.eet3107.inscripciones.service;


import java.util.Set;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;



public interface InscripcionesService {

	Set<Materia> getPlanEstudios(String curso,String ciclo);

	Integer getMaxAgeCurso(String  curso,String division);
	
	Integer getMaxCupo(String  curso,String division,String ciclo,Character turno);
	
	Alumno findAlumnoByDni(String dni);
	
	void inscribirAlumno(Alumno al, TrayectoriaAcademica tya, Curso curso) throws Exception;
	
	void reinscribirAlumno( Alumno al,TrayectoriaAcademica tya,Curso curso);
	
	Boolean hayLugarenCurso(String nombreCurso,String division,String ciclo,Character turno,String anioLectivo);
	
	
	
	

}
