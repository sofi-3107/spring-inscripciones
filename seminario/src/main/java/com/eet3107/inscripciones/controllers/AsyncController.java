package com.eet3107.inscripciones.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.MateriaAlumnoCursoDetail;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;
import com.eet3107.inscripciones.repository.CursoRepository;
import com.eet3107.inscripciones.repository.LibretaRepository;
import com.eet3107.inscripciones.repository.MateriaAlumnoCursoDetailRepository;
import com.eet3107.inscripciones.repository.MateriaRepository;
import com.eet3107.inscripciones.repository.TrayectoriaAcademicaRepository;
import com.eet3107.inscripciones.serviceimpl.InscripcionesServiceImpl;

import xom.eet3107.inscripciones.auxiliar.CalculosDeFecha;

@RestController
@RequestMapping("api/")
public class AsyncController {
	

	@Autowired
	InscripcionesServiceImpl service;
	
	@Autowired
	CursoRepository cursoRep;
	
	@Autowired
	MateriaAlumnoCursoDetailRepository detailRep;
	
	@Autowired
	MateriaRepository materiaRep;
	
	@Autowired
	LibretaRepository libretaRep;
	
	@Autowired
	TrayectoriaAcademicaRepository trayectoriaRep;
	
	@GetMapping("/planestudio")
	public List<Materia>getPlanEstudios(@RequestParam(name="pecurso",required=true)String idCurso){
		
		return null;
	}
	
	
	@GetMapping("/getByDni/{dni}")
	public Alumno getByDni(@PathVariable String dni) {
		return service.findAlumnoByDni(dni);
	}
	

	@GetMapping("/getEdadMax/{curso}/{ciclo}")	
	public int getEdadMax(@PathVariable String curso,@PathVariable String ciclo) {				
		return service.getMaxAgeCurso(curso,ciclo);
	}
	
	@GetMapping("/getCantEnCurso/{curso}/{division}/{ciclo}/{turno}/{anioLectivo}")	
	public Boolean getCantEnCurso(@PathVariable String curso,@PathVariable String division,@PathVariable String ciclo,@PathVariable Character turno,@PathVariable String anioLectivo) {
		return service.hayLugarenCurso(curso, division, ciclo, turno, anioLectivo);
	}
	
	@GetMapping("/getDivisiones/{curso}/{ciclo}/{turno}")
	public ModelAndView  getDivisiones(@PathVariable String curso,@PathVariable String ciclo, @PathVariable Character turno) {
		ModelAndView mav=new ModelAndView("fragments/dinamic :: lista-divisiones");
		List<Curso> divisiones=cursoRep.findAllBynombreCursoAndCicloAndTurno(curso, ciclo, turno);
		if(divisiones==null) {
			System.out.println("divisiones es null");
		}
		if(divisiones.size()<1) {
			System.out.println("divisiones es vacio");
		}
		mav.addObject("cursos",divisiones);
		return mav;
	}
	
	
	
	@GetMapping("/repitentes/{curso}/{division}/{ciclo}/{turno}/{anioLectivo}")
	public int[] cantidadRepitentesCurso(@PathVariable String curso,@PathVariable String division,@PathVariable String ciclo,@PathVariable Character turno,@PathVariable String anioLectivo) {
		int []repitentesCurso=new int[2];
		Curso cursoConsulta=cursoRep.findBynombreCursoAndDivisionAndCicloAndTurno(curso, division, ciclo, turno);
		List<TrayectoriaAcademica> alumnosCurso=trayectoriaRep.findAllByCursoAndAnioLectivo(cursoConsulta, anioLectivo);
		int repitentes=0;
		int regulares=alumnosCurso.size();
			for(TrayectoriaAcademica alumno : alumnosCurso) {
				if(alumno.getIsRepitente()) {
					repitentes++;
				}
			}
			regulares=-repitentes;
			repitentesCurso[0]=repitentes;
			repitentesCurso[1]=regulares;
			
		return repitentesCurso;
		
	}
	

	
	@GetMapping("/desaprobados/{curso}/{divison}/{ciclo}/{turno}/{anioLectivo}")
	public Map<String,List<Integer>>getByCurso(@PathVariable String curso,@PathVariable String division,@PathVariable String ciclo,@PathVariable Character turno,@PathVariable String anioLectivo){
		
		Curso cursoConsultado=cursoRep.findBynombreCursoAndDivisionAndCicloAndTurno("1º", "1º", "Basico", 'T');
		return service.aprobadosDesaprobadosPorMateriaCurso(cursoConsultado, cursoConsultado.getPlanDeEstudios(), "2020", 1);
	}
	
	
	@GetMapping("/sobreedad/{curso}/{divison}/{ciclo}/{turno}/{anioLectivo}")
	public int[]cantidadSobreeedadCurso(@PathVariable String curso,@PathVariable String division,@PathVariable String ciclo,@PathVariable Character turno,@PathVariable String anioLectivo){
		
		Curso cursoConsultado=cursoRep.findBynombreCursoAndDivisionAndCicloAndTurno(curso, division, ciclo, turno);
		List<TrayectoriaAcademica> alumnosCurso=trayectoriaRep.findAllByCursoAndAnioLectivo(cursoConsultado, anioLectivo);
		return CalculosDeFecha.cantidadSobreedadEnCurso(alumnosCurso, cursoConsultado);
	}
	
	
	
	@GetMapping("/test/bar")
		public List<MateriaAlumnoCursoDetail> pruebaBarras() {
		
		System.out.println("metodo pruebaBarras");
		List<MateriaAlumnoCursoDetail>lista;
		lista= detailRep.findByAnioLectivoAndNombreCursoAndDivisionCursoAndCicloCursoAndTurno("2020", "1º", "1º", "Basico", 'M');

		return lista;
	}
}
