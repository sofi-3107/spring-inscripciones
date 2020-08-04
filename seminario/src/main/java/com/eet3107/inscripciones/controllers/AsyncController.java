package com.eet3107.inscripciones.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Materia;

@RestController
@RequestMapping("api/")
public class AsyncController {
	

	
	@GetMapping("/planestudio")
	public List<Materia>getPlanEstudios(@RequestParam(name="pecurso",required=true)String idCurso){
		
		return null;
	}
	
	
	@GetMapping("/getByDni/{dni}")
	public Alumno getByDni(@PathVariable String dni) {
		return null;
	}

	@GetMapping("/getDatosCurso/{curso}")	
	public Curso getDatosCurso(@PathVariable Curso curso) {
		return null;
	}
}
