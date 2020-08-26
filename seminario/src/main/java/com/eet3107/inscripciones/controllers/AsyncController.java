package com.eet3107.inscripciones.controllers;

import java.util.List;

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
import com.eet3107.inscripciones.repository.CursoRepository;
import com.eet3107.inscripciones.serviceimpl.InscripcionesServiceImpl;

@RestController
@RequestMapping("api/")
public class AsyncController {
	

	@Autowired
	InscripcionesServiceImpl service;
	
	@Autowired
	CursoRepository cursoRep;
	
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
}
