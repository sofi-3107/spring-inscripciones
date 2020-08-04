package com.eet3107.inscripciones.service;

import java.util.Set;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Legajo;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;

public interface InscripcionesService {

	Set<Materia> getPlanEstudios(String curso);

	Integer getMaxAgeCurso(Curso  curso);
	
	Integer getMaxCupo(Curso curso);
	
	Integer getCantInscriptosEnCurso(Curso curso);
	
	public Alumno findAlumnoByDni(String dni);

	void inscribirAlumno(Alumno al, TrayectoriaAcademica tya,Curso curso);

}
