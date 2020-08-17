package com.eet3107.inscripciones.service;


import java.util.Set;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;



public interface InscripcionesService {

	Set<Materia> getPlanEstudios(String curso,String ciclo);

	Integer getMaxAgeCurso(Curso  curso);
	
	Integer getMaxCupo(Curso curso);
	
	Alumno findAlumnoByDni(String dni);
	
	void inscribirAlumno(Alumno al, TrayectoriaAcademica tya, Curso curso) throws Exception;
	
	void reinscribirAlumno( Alumno al,TrayectoriaAcademica tya,Curso curso);
	
	Integer getCantidadEnCurso(Curso curso,String fechaInscripcion);
	
	void testGuardarAlumno(Alumno alumno);
	
	

}
