package com.eet3107.inscripciones.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eet3107.inscripciones.entidades.Alumno;
import com.eet3107.inscripciones.entidades.Tutor;
import com.eet3107.inscripciones.repositorios.AlumnoRepository;
import com.eet3107.inscripciones.services.interfaces.AlumnoService;



@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	/* inyectamos el repositorio*/
	@Autowired
	AlumnoRepository rep;

//	@Override
//	public Alumno actualizarAlumno(Alumno alumno) throws Exception {	
//		Alumno alumnoUpdated=rep.findById(alumno.getTutor());
//		alumnoUpdated.setApellido(alumno.));
//		alumnoUpdated.setNombre(alumno.getNombre());
//		alumnoUpdated.setDni(alumno.getDni());
//		alumnoUpdated.setMail(alumno.getMail());
//		alumnoUpdated.setNacimiento(alumno.getNacimiento());
//		alumnoUpdated.setTelefono(alumno.getTelefono());
//		return rep.save(alumno);
		
	

		@Override
		public Alumno crearAlumno(Alumno alumno) throws Exception {
			return null;
		}

		@Override
		public Alumno findById(int id) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Alumno editarAlumno(Alumno alumno) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Alumno> findAll() throws Exception {
			// TODO Auto-generated method stub
			return null;
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
		public void deleteAlumno(int id) throws Exception {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Alumno actualizarAlumno(Alumno alumno) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
	
	}



	

