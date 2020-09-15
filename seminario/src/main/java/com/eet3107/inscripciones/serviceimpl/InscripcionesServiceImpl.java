package com.eet3107.inscripciones.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Libreta;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.MateriaAlumnoCursoDetail;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;
import com.eet3107.inscripciones.repository.AlumnoRepository;
import com.eet3107.inscripciones.repository.CursoRepository;
import com.eet3107.inscripciones.repository.LibretaRepository;
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
	
	@Autowired
	LibretaRepository libretaRep;



	@Override
	public Integer getMaxAgeCurso(String curso,String ciclo) {
		return cursoRep.findBynombreCursoAndDivisionAndCicloAndTurno(curso, "1º", ciclo, 'M').getEdadMax();
	}




	@Override
	public Alumno findAlumnoByDni(String dni) {
		return aluRep.findByDni(dni);
	}

	@Override
	@Transactional
	public void inscribirAlumno(Alumno al, TrayectoriaAcademica tya, Curso curso) throws IOException {			
		
		Set<TrayectoriaAcademica>inscripciones=new HashSet<TrayectoriaAcademica>();			
		tya.setAlumno(al);		
		System.out.println("Dentro del metodo inscribir antes de consultar el curso");
		Curso cursoUpdate=cursoRep.findBynombreCursoAndDivisionAndCicloAndTurno(curso.getNombreCurso(), curso.getDivision(), curso.getCiclo(), curso.getTurno());
		System.out.println("Contenido del curso que llega: "+curso.getNombreCurso()+" " +curso.getDivision()+" "+curso.getCiclo()+" "+curso.getTurno());
		System.out.println("curso consultado nulo: " +cursoUpdate);
		System.out.println("tya nulo?_" +tya==null);
		tya.setCurso(cursoUpdate);		
		trayectoriaRep.save(tya);
		inscripciones.add(tya);
		al.setInscripciones(inscripciones);	
		System.out.println("Before saving alumno");
		aluRep.save(al);
		//Creacion de la libreta
		Libreta libreta=new Libreta();
		List<Materia>materiasLibreta=new ArrayList<Materia>();
		System.out.println("Libreta es nulo: "+libreta==null);
		List<Materia>planDeEstudios=cursoUpdate.getPlanDeEstudios();
		System.out.println("Plan de estudios null?: "+planDeEstudios);
		materiasLibreta.addAll(planDeEstudios);
		libreta.setMaterias(materiasLibreta);
		libreta.setAlumnoTyaFk(tya);
		libreta.setAnioLectivo(tya.getAnioLectivo());
		libreta.setCurso(cursoUpdate);
		libretaRep.save(libreta);
		
		//Tabla de detalle
//		MateriaAlumnoCursoDetail detalle=new MateriaAlumnoCursoDetail();
//		detalle.setAnioLectivo(tya.getAnioLectivo());
//		detalle.setAlumno(al.getDni());
//		detalle.setCicloCurso(cursoUpdate.getCiclo());
//		detalle.setIsRepitente(tya.getIsRepitente());
//		detalle.setNombreCurso(cursoUpdate.getNombreCurso());
//		detalle.setDivisionCurso(cursoUpdate.getDivision());
//		detalle.setTurno(cursoUpdate.getTurno());
//		detailRep.save(detalle);
	}
	

	@Override
	public void reinscribirAlumno(Alumno al, TrayectoriaAcademica tya, Curso curso) {
		System.out.println("METODO REINSCRIBIR DEL SERVICIO");
		Alumno alumno=aluRep.findById(al.getId()).get();
		Curso cursoUpdate=cursoRep.findBynombreCursoAndDivisionAndCicloAndTurno(curso.getNombreCurso(), curso.getDivision(), curso.getCiclo(), curso.getTurno());
		tya.setCurso(cursoUpdate);
		tya.setAlumno(alumno);
		System.out.println("Antes de persistir tray: "+alumno.toString());
		trayectoriaRep.save(tya);
		alumno.getInscripciones().add(tya);
		aluRep.save(alumno);
		
		//Creacion de la libreta
		Libreta libreta=new Libreta();
		List<Materia>materiasLibreta=new ArrayList<Materia>();
		materiasLibreta.addAll(cursoUpdate.getPlanDeEstudios());
		libreta.setMaterias(materiasLibreta);
		libreta.setAlumnoTyaFk(tya);
		libreta.setCurso(cursoUpdate);
		libreta.setAnioLectivo(tya.getAnioLectivo());
		libretaRep.save(libreta);
		//Tabla de detalle
//		MateriaAlumnoCursoDetail detalle=new MateriaAlumnoCursoDetail();		
//		detalle.setAnioLectivo(tya.getAnioLectivo());
//		detalle.setAlumno(al.getDni());
//		detalle.setAnioLectivo(tya.getFechaInscripcion().substring(0, 4));
//		detalle.setCicloCurso(cursoUpdate.getCiclo());
//		detalle.setIsRepitente(tya.getIsRepitente());
//		detalle.setNombreCurso(cursoUpdate.getNombreCurso());
//		detalle.setDivisionCurso(cursoUpdate.getDivision());
//		detalle.setTurno(cursoUpdate.getTurno());
//		detailRep.save(detalle);
	}







	@Override
	public Integer getMaxCupo(String curso, String division, String ciclo, Character turno) {
		return cursoRep.findAllBynombreCursoAndDivisionAndCicloAndTurno(curso, division, ciclo, turno).size();
	}




	@Override
	public Boolean hayLugarenCurso(String nombreCurso, String division, String ciclo, Character turno,
			String anioLectivo) {
		Curso curso=cursoRep.findBynombreCursoAndDivisionAndCicloAndTurno(nombreCurso, division, ciclo, turno);
		int cupoMax=curso.getCupoMax();
		System.out.println("CupoMax recuperado: "+cupoMax);
		int cantExistente=trayectoriaRep.findAllByCursoAndAnioLectivo(curso, anioLectivo).size();
		System.out.println(cantExistente);
		if(cantExistente==0) {
			System.out.println("cantExistente: "+cantExistente);
		}
			if(cantExistente<cupoMax) {
				return true;
			}else {
				return false;
			}	
			
	}




	@Override
	public Map<String, List<Integer>> aprobadosDesaprobadosPorMateriaCurso(Curso curso,List<Materia> planDeEstudios,String anioLectivo,int trimestre) {
		Map<String,List<Integer>>aprobadosDesaprobados=new HashMap<String,List<Integer>>();
		for(Materia materia : planDeEstudios) {
			List<Libreta> libretasMateria=libretaRep.findByCursoAndMateriasAndTrimestreAndAnioLectivo(curso, materia, trimestre, anioLectivo);
			Integer aprobados=0;
			Integer desaprobados=0;
			for(Libreta libreta : libretasMateria) {
				if(libreta.getCalificacion()<6) {
					++aprobados;
				}else {
					++desaprobados;
				}
			}
			List<Integer>aprobadosDesaprobadosDeMateria= new ArrayList<Integer>();
			aprobadosDesaprobadosDeMateria.add(aprobados);
			aprobadosDesaprobadosDeMateria.add(desaprobados);
			aprobadosDesaprobados.put(materia.getNombre(), aprobadosDesaprobadosDeMateria);
		}
		return aprobadosDesaprobados;
	}











	









	

	




	
	


}
