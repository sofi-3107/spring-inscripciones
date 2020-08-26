package com.eet3107.inscripciones.controllers;

import java.util.Set;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eet3107.inscripciones.entity.Alumno;
import com.eet3107.inscripciones.entity.Curso;
import com.eet3107.inscripciones.entity.TrayectoriaAcademica;
import com.eet3107.inscripciones.repository.AlumnoRepository;
import com.eet3107.inscripciones.serviceimpl.InscripcionesServiceImpl;

import xom.eet3107.inscripciones.auxiliar.CheckPreviousInscripciones;

@Controller
@RequestMapping("admin/")
public class AdministrativoController {
	
	@Autowired
	InscripcionesServiceImpl servicio;

	@Autowired
	AlumnoRepository aluRep;
	
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
	public String  inscribir(@ModelAttribute("alumno") @Valid Alumno alumno,BindingResult alumnoValid,
			 @Valid @ModelAttribute("curso") Curso curso,BindingResult cursoValid,@Valid @ModelAttribute("trayectoria") TrayectoriaAcademica trayectoria,
			 BindingResult trayValid,RedirectAttributes red) throws Exception {
		
		
		if(alumnoValid.hasErrors()||cursoValid.hasErrors()||trayValid.hasErrors()) {
			red.addAttribute("message","Ha ocurrido un error en la carga de los datos, Verifique abajo el detalle");
			red.addAttribute("type","danger");
			return "form";
		}else {
			if(alumno.getId()==null) {
				servicio.inscribirAlumno(alumno, trayectoria, curso);
				red.addAttribute("message","Alumno inscripto correctamente");
				red.addAttribute("type","success");
				return "redirect:/admin/inscripciones";
			}else {
				Set<TrayectoriaAcademica>inscripciones=aluRep.findByDni(alumno.getDni()).getInscripciones();
				
				if(CheckPreviousInscripciones.isAlreadyinCurrentPeriod(inscripciones,trayectoria.getAnioLectivo())) {
					red.addAttribute("message","Alumno ya inscripto en el presente ciclo lectivo");
					red.addAttribute("type","danger");
					return "redirect:/admin/inscripciones";
				}else {
					servicio.reinscribirAlumno(alumno, trayectoria, curso);
					red.addAttribute("message","Alumno reinscripto correctamente");
					red.addAttribute("type","success");
					return "redirect:/admin/inscripciones";
				}

			}
			
				
			
		}


	}
	
	//UPDATE OR DELETE
	
	@GetMapping("/UpdateOrDelete")
	
	public String updateOrDelete(Model model) {	
		model.addAttribute("alumno",new Alumno());
		model.addAttribute("trayectoria",new TrayectoriaAcademica());
		model.addAttribute("curso",new Curso());
		return "delete-update";
	}

}
