package com.eet3107.inscripciones.controllers;

import java.io.IOException;
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

import xom.eet3107.inscripciones.auxiliar.CalculosDeFecha;

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
			 @Valid @ModelAttribute("curso") Curso curso,/*BindingResult cursoValid,*/@Valid @ModelAttribute("trayectoria") TrayectoriaAcademica trayectoria,
			 BindingResult trayValid,RedirectAttributes red,Model model) throws Exception{
		
		
		if(alumnoValid.hasErrors()/*||cursoValid.hasErrors()*/||trayValid.hasErrors()) {
			System.out.println("Controlador dentro de errores de validacion");
			model.addAttribute("message","Ha ocurrido un error en la carga de los datos, Verifique abajo el detalle");
			model.addAttribute("type","danger");
			return "form";//decia return form
		}else {
			if(alumno.getId()==null) {
				System.out.println("Controlador dentro de inscribir");
				try {
					servicio.inscribirAlumno(alumno, trayectoria, curso);
					red.addAttribute("message","Alumno inscripto correctamente");
					red.addAttribute("type","success");
					return "redirect:/admin/inscripciones";
				} catch (IOException e) {
					System.out.println("Controlador dentro de excepciones: "+e.getMessage());
					System.out.println("null curso controller: "+curso==null);
					System.out.println("null tya controller: "+trayectoria==null);
					System.out.println("null alumno controller: "+alumno==null);					
					red.addAttribute("message","Entro a la exception");
					red.addAttribute("type","danger");
					return "redirect:/admin/inscripciones";
				}

			}else {
				Set<TrayectoriaAcademica>inscripciones=aluRep.findByDni(alumno.getDni()).getInscripciones();
				
				if(CalculosDeFecha.isAlreadyinCurrentPeriod(inscripciones,trayectoria.getAnioLectivo())) {
					red.addAttribute("message","Alumno ya inscripto en el presente ciclo lectivo");
					red.addAttribute("type","danger");
					return "redirect:/admin/inscripciones";
				}else {
					System.out.println("Controlador dentro de reinscribir");
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
