package com.eet3107.inscripciones.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.MateriaAlumnoCursoDetail;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;
import com.eet3107.inscripciones.repository.AlumnoRepository;
import com.eet3107.inscripciones.repository.CursoRepository;
import com.eet3107.inscripciones.repository.MateriaAlumnoCursoDetailRepository;
import com.eet3107.inscripciones.repository.MateriaRepository;
import com.eet3107.inscripciones.repository.TrayectoriaAcademicaRepository;
import com.eet3107.inscripciones.service.InscripcionesService;


@Service
public class InscripcionesServiceImpl implements InscripcionesService{
	
	
	@Autowired 
	AlumnoRepository aluRep;
	
	@Autowired
	CursoRepository cursoRep;
	
	@Autowired
	TrayectoriaAcademicaRepository trayectoriaRep;
	
	@Autowired
	MateriaAlumnoCursoDetailRepository detailRep;
	
	@Autowired
	MateriaRepository materiaRep;



	@Override
	public Integer getMaxAgeCurso(Curso curso) {
		return curso.getEdadMax();
	}

	@Override
	public Integer getMaxCupo(Curso curso) {
		return cursoRep.findById(curso.getIdCurso()).get().getCupoMax();
	}



	@Override
	public Alumno findAlumnoByDni(String dni) {
		return aluRep.findByDni(dni);
	}

	@Override
	@Transactional
	public void inscribirAlumno(Alumno al, TrayectoriaAcademica tya, Curso curso) throws Exception {			
		
		Set<TrayectoriaAcademica>inscripciones=new HashSet<TrayectoriaAcademica>();	
		aluRep.save(al);
		System.out.println("Alumno: "+al.toString());
		tya.setAlumno(al);		
		Curso cursoUpdate=cursoRep.findBynombreCursoAndDivisionAndCicloAndTurno(curso.getNombreCurso(), curso.getDivision(), curso.getCiclo(), curso.getTurno());
		tya.setCurso(cursoUpdate.getIdCurso());
		trayectoriaRep.save(tya);
		inscripciones.add(tya);
		al.setInscripciones(inscripciones);	
		//Tabla de detalle
		System.out.println("getCiclo: "+cursoUpdate.getCiclo());
		MateriaAlumnoCursoDetail detalle=new MateriaAlumnoCursoDetail();
		Set<Materia>materiaNotas=new HashSet<Materia>();
		materiaNotas.addAll(cursoUpdate.getPlanDeEstudios());
		System.out.println("Materia Set tamaño : "+materiaNotas.size());
		for(Materia m:materiaNotas) {
			System.out.println(m.getNombre());
		}
		detalle.setMateriaNotas(materiaNotas);
		detalle.setAnioLectivo(tya.getAnioLectivo());
		detalle.setAlumno(al.getDni());
		detalle.setAnioLectivo(tya.getFechaInscripcion().substring(0, 4));
		detalle.setCicloCurso(cursoUpdate.getCiclo());
		detalle.setNombreCurso(cursoUpdate.getNombreCurso());
		detalle.setDivisionCurso(cursoUpdate.getDivision());
		detalle.setTurno(cursoUpdate.getTurno());
		detailRep.save(detalle);
	}
	

	@Override
	public void reinscribirAlumno(Alumno al, TrayectoriaAcademica tya, Curso curso) {
		System.out.println("METODO REINSCRIBIR DEL SERVICIO");
		Alumno alumno=aluRep.findById(al.getId()).get();
		Curso cursoUpdate=cursoRep.findBynombreCursoAndDivisionAndCicloAndTurno(curso.getNombreCurso(), curso.getDivision(), curso.getCiclo(), curso.getTurno());
		tya.setCurso(cursoUpdate.getIdCurso());
		tya.setAlumno(alumno);
		System.out.println("Antes de persistir tray: "+alumno.toString());
		trayectoriaRep.save(tya);
		alumno.getInscripciones().add(tya);
		aluRep.save(alumno);
		//Tabla de detalle
		MateriaAlumnoCursoDetail detalle=new MateriaAlumnoCursoDetail();
		Set<Materia>materiaNotas=new HashSet<Materia>();
		materiaNotas.addAll(cursoUpdate.getPlanDeEstudios());
		
		System.out.println("Materia Set tamaño : "+materiaNotas.size());
		for(Materia m:materiaNotas) {
			System.out.println(m.getNombre());
		}
		
		detalle.setMateriaNotas(materiaNotas);
		detalle.setAnioLectivo(tya.getAnioLectivo());
		detalle.setAlumno(al.getDni());
		detalle.setAnioLectivo(tya.getFechaInscripcion().substring(0, 4));
		detalle.setCicloCurso(cursoUpdate.getCiclo());
		detalle.setNombreCurso(cursoUpdate.getNombreCurso());
		detalle.setDivisionCurso(cursoUpdate.getDivision());
		detalle.setTurno(cursoUpdate.getTurno());
		detailRep.save(detalle);
	}



	@Override
	public Integer getCantidadEnCurso(Curso curso, String fechaInscripcion) {
		return trayectoriaRep.findAllByCursoAndFechaInscripcion(curso, fechaInscripcion).size();
	}

	@Override
	public void testGuardarAlumno(Alumno alumno) {
		aluRep.save(alumno);
		
	}

	@Override
	public Set<Materia> getPlanEstudios(String curso, String ciclo) {
		// TODO Auto-generated method stub
		return null;
	}







	









	

	




	
	


}
