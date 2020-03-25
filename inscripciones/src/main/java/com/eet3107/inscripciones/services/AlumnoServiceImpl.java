package com.eet3107.inscripciones.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eet3107.inscripciones.entidades.Alumno;
import com.eet3107.inscripciones.repositorios.AlumnoRepository;



@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	/* inyectamos el repositorio*/
	@Autowired
	AlumnoRepository rep;

	@Override
	public Alumno crearAlumno(Alumno alumno) throws Exception {
		return alumno=rep.save(alumno);
		
	}

	@Override
	public Alumno editarAlumno(Alumno alumno) throws Exception {
	
		return null;
	}

	@Override
	public Iterable findAll() {
		return rep.findAll();
	}

	@Override
	public Alumno findAlumnoByDni(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno findAlumnoByApellidoYNombre(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno findById(Alumno alumno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAlumno(int id) throws Exception {		
		  rep.deleteById(id);
	}



	
}
