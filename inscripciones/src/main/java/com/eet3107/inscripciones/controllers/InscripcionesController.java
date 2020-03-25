package com.eet3107.inscripciones.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.eet3107.inscripciones.entidades.Alumno;
import com.eet3107.inscripciones.services.AlumnoServiceImpl;

@Controller
@RequestMapping("/")
public class InscripcionesController {
	
	
	@Autowired
	AlumnoServiceImpl service;
	
	@GetMapping("/carga")
	public String getRoot(Model model) {
		model.addAttribute("tab1Active","active");
		model.addAttribute("alumno", new Alumno());
		model.addAttribute("editar", "false");
		return "index";
	}
	
	@PostMapping("/carga")
	public RedirectView cargar(@Valid @ModelAttribute("alumno")Alumno alumno,BindingResult result,ModelMap modelMap, RedirectAttributes redAttr) {
		if(result.hasErrors()) {
			modelMap.addAttribute("alumno", alumno);
			modelMap.addAttribute("tab1Active","active");
			modelMap.addAttribute("invalid","is-invalid");
			redAttr.addAttribute("alert", "Ocurrió un error en la carga");
			redAttr.addAttribute("type","danger");
			return new RedirectView("/");			
		}else {
			try {
				service.crearAlumno(alumno);
				redAttr.addAttribute("alert", "carga exitosa");
				redAttr.addAttribute("type","success");
				return new RedirectView("/");
			} catch (Exception e) {
				modelMap.addAttribute("error",e.getMessage());
				modelMap.addAttribute("tab1Active","active");
				redAttr.addAttribute("alert", "Ocurrió un error en la carga");
				redAttr.addAttribute("type","danger");
				return new RedirectView("/");
			}
			
		}
		

	}
	
	/* Este método resuelve el error de no poder guardar cadena como fecha,
	cambia el formato pra todo objeto Date*/
	
	@InitBinder
	public void initBinder(WebDataBinder dateBinder) {
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
		dateBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf,false));
		
	}
	
	@GetMapping("/")
	
	public String verTodos(Model model) {
		try {
			Iterable <Alumno>alumnos= service.findAll();
			if(alumnos!=null) {
			model.addAttribute("alumnos", alumnos);
			return "lista";
			}else {
				model.addAttribute("alumnos", "no hay na");
				return "lista";
			}
		} catch (Exception e) {
			model.addAttribute("alumnos", e.getMessage());
		}
		return "lista";
	}
	
	
	
	@PostMapping("/editar")
		public String editarAlumno(Model model) {
		model.addAttribute("editar", "true");
			return "";
		}
	
	@GetMapping("/delete")
	public String deleteAlumno(Model model,@RequestParam(name="id",required=false)int id) {
		try {
			service.deleteAlumno(id);
			model.addAttribute("success","Borrado con éxito");
			return"redirect:/";
		} catch (Exception e) {
			model.addAttribute("errorDelete",e.getMessage());
			return"redirect:/";
		}
		
	}


}
