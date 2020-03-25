package com.eet3107.inscripciones.services;

import com.eet3107.inscripciones.entidades.Alumno;

import antlr.collections.List;

public interface AlumnoService {

	public Alumno crearAlumno(Alumno alumno)throws Exception;
	
	public Alumno findById(Alumno alumno) throws Exception;
	
	public Alumno editarAlumno(Alumno alumno)throws Exception;
	
	public Iterable<Alumno>findAll() throws Exception;
	
	public Alumno findAlumnoByDni(Alumno alumno)throws Exception;
	
	public Alumno findAlumnoByApellidoYNombre(Alumno alumno)throws Exception;
	
	public void deleteAlumno(int id) throws Exception;
	
	
	
}
