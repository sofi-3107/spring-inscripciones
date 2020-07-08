package com.eet3107.inscripciones.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.Legajo;
import com.eet3107.inscripciones.entity.Materia;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;
import com.eet3107.inscripciones.repository.AlumnoRepository;
import com.eet3107.inscripciones.repository.CursoRepository;
import com.eet3107.inscripciones.repository.LegajoRepository;
import com.eet3107.inscripciones.repository.MateriaRepository;
import com.eet3107.inscripciones.repository.TrayectoriaAcademicaRepository;

@Controller
@RequestMapping("test/")
public class TestController {

	@Autowired
	AlumnoRepository aluR;
	
	@Autowired
	CursoRepository cursoR;
	
	@Autowired
	LegajoRepository legR;
	
	@Autowired
	MateriaRepository matR;
	
	@Autowired
	TrayectoriaAcademicaRepository trayR;
	
	
	/*Creando datos de prueba*/
	

	
	Legajo leg=new Legajo();// leg antes de alumno
	TrayectoriaAcademica tray=new TrayectoriaAcademica();
	Curso curso=new Curso();


	Set<Materia>planE=new HashSet<Materia>();
	Set<TrayectoriaAcademica>inscripciones=new HashSet<TrayectoriaAcademica>();
	public void cargoNamas() {
		curso.setCiclo("superior");

		curso.setDivision("1ª");
		curso.setEdadMax(16);
		curso.setNombre("1ª");

		curso.setTurno('T');
		tray.setCondicion("regular");
		tray.setCurso(curso);
		tray.setLegajo(leg);
		
		leg.setInscripciones(inscripciones);

	}

	
	@Transactional
	@GetMapping("/")
	public String test(Model model) {
		cursoR.save(curso);	
		trayR.save(tray);		
		

		legR.save(leg);

		model.addAttribute("created",true);
		return "prueba";
	}
}
