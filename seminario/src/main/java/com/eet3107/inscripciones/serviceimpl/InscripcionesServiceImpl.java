package com.eet3107.inscripciones.serviceimpl;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Legajo;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;
import com.eet3107.inscripciones.repository.AlumnoRepository;
import com.eet3107.inscripciones.repository.CursoRepository;
import com.eet3107.inscripciones.repository.LegajoRepository;
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
	LegajoRepository legajoRep;
	
	

	@Override
	public Set<Materia> getPlanEstudios(String curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMaxAgeCurso(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMaxCupo(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getCantInscriptosEnCurso(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Alumno findAlumnoByDni(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void inscribirAlumno(Alumno al, TrayectoriaAcademica tya, Curso curso) {
			
			Legajo legajo=new Legajo();
			legajo.setAlumno(al);
			legajo.setIdLegajo(al.getId());
			al.setLegajo(legajo);
			tya.setLegajo(legajo);
			aluRep.save(al);
			//Curso curso2=cursoRep.findByNombreAndDivisionAndCicloAndTurno(curso.getNombre(), curso.getDivision(), curso.getCiclo(), curso.getTurno());
			cursoRep.save(curso);
			tya.setCurso(curso);
			Set <TrayectoriaAcademica>inscripciones=new HashSet<TrayectoriaAcademica>();
			inscripciones.add(tya);			
			al.getLegajo().setInscripciones(inscripciones);	
			trayectoriaRep.save(tya);
			legajoRep.save(al.getLegajo());
		
	}





	
	


}
