package com.eet3107.inscripciones.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;
import com.eet3107.inscripciones.service.InscripcionesService;

@Controller
@RequestMapping("admin/")
public class AdministrativoController {
	
	@Autowired
	InscripcionesService inscripcionesSave;
	
	@GetMapping("/")
	public String getPanel(Model model) {
		model.addAttribute("titulo","Administrativo");
		model.addAttribute("optionTitle","Inscripciones");
		model.addAttribute("optionImg","grupoalumnos.jpg");
		model.addAttribute("url","/admin/inscripciones");
		return "paneles";		
	}
	
	@GetMapping("/inscripciones")
	public ModelAndView showForm() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("titulo","Usuario Administrativo");
		mav.setViewName("form");
		mav.addObject("alumno",new Alumno());
		mav.addObject("trayectoria",new TrayectoriaAcademica());
		mav.addObject("curso",new Curso());
		return mav;
	}
	
	@PostMapping("/inscripciones")
	public String  inscribir( @ModelAttribute("alumno") @Valid Alumno alumno,BindingResult alumnoValid,
			 @Valid @ModelAttribute("curso") Curso curso,BindingResult cursoValid,@Valid @ModelAttribute("trayectoria") TrayectoriaAcademica trayectoria,BindingResult trayValid) {
		
		if(alumnoValid.hasErrors()||cursoValid.hasErrors()||trayValid.hasErrors()) {
			return "form";
		}

		inscripcionesSave.inscribirAlumno(alumno, trayectoria, curso);
		return "redirect:/admin/inscripciones";

	}

}
