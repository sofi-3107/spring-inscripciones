package com.eet3107.inscripciones.controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.ISpringTemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.eet3107.inscripciones.entidades.Alumno;
import com.eet3107.inscripciones.reports.ExportarExcelCsv;
import com.eet3107.inscripciones.services.AlumnoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
@Controller
@RequestMapping("/")
public class InscripcionesController {
	
	
	public static final ObjectMapper JSON_MAPPER = new ObjectMapper();

	@Autowired
	AlumnoServiceImpl service;

	@GetMapping("/carga")
	public String getRoot(Model model) {
		model.addAttribute("tab1Active", "active");
		model.addAttribute("alumno", new Alumno());
		model.addAttribute("editar", 0);
		return "index";
	}

	@PostMapping("/carga")
	public String cargar(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult result, ModelMap modelMap,
			RedirectAttributes redAttr) {
		if (result.hasErrors()) {
			modelMap.addAttribute("alumno", alumno);
			modelMap.addAttribute("tab1Active", "active");
			modelMap.addAttribute("invalid", "is-invalid");
			redAttr.addAttribute("alert", "Ocurrió un error en la carga");
			redAttr.addAttribute("type", "danger");
			return "index";
		} else {
			try {
				service.crearAlumno(alumno);
				redAttr.addAttribute("alert", "carga exitosa");
				redAttr.addAttribute("type", "success");
				return "redirect:/";
			} catch (Exception e) {
				modelMap.addAttribute("error", e.getMessage());
				modelMap.addAttribute("tab1Active", "active");
				redAttr.addAttribute("alert", "Ocurrió un error en la carga");
				redAttr.addAttribute("type", "danger");
				return "index";
			}

		}

	}

	/*
	 * Este método resuelve el error de no poder guardar cadena como fecha, cambia
	 * el formato pra todo objeto Date
	 */

	@InitBinder
	public void initBinder(WebDataBinder dateBinder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		dateBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));

	}

	@GetMapping("/")

	public String verTodos(Model model) {
		try {
			Iterable<Alumno> alumnos = service.findAll();
			if (alumnos != null) {
				model.addAttribute("alumnos", alumnos);
				return "lista";
			} else {
				model.addAttribute("alumnos", "no hay na");
				return "lista";
			}
		} catch (Exception e) {
			model.addAttribute("alumnos", e.getMessage());
		}
		return "lista";
	}

	@GetMapping("/editar")
	public String editarAlumno(Model model, @RequestParam(name = "id", required = false) int id) {
		try {
			Alumno alumno = service.findById(id);
			model.addAttribute("alumno", alumno);
			model.addAttribute("editar", 1);
			model.addAttribute("tab1Active", "active");
			return "index";
		} catch (Exception e) {
			model.addAttribute("tab1Active", "active");
			// model.addAttribute("error",e.getMessage());
		}
		return "index";
	}

	@PostMapping("/editar")

	public RedirectView editarAlumno(@Valid @ModelAttribute("alumno") Alumno alumno, BindingResult result,
			ModelMap modelMap, RedirectAttributes redAttr) {
		if (result.hasErrors()) {
			modelMap.addAttribute("alumno", alumno);
			modelMap.addAttribute("tab1Active", "active");
			modelMap.addAttribute("invalid", "is-invalid");
			redAttr.addAttribute("alert", "Ocurrió un error en la actualización");
			redAttr.addAttribute("type", "danger");
			return new RedirectView("/editar");
		} else {
			try {
				service.actualizarAlumno(alumno);
				return new RedirectView("/");
			} catch (Exception e) {
				modelMap.addAttribute("error", e.getMessage());
				return new RedirectView("index");
			}

		}
	}

	@GetMapping("/delete")
	public String deleteAlumno(Model model, @RequestParam(name = "id", required = false) int id) {
		try {
			service.deleteAlumno(id);
			model.addAttribute("success", "Borrado con éxito");
			return "redirect:/";
		} catch (Exception e) {
			model.addAttribute("errorDelete", e.getMessage());
			return "redirect:/";
		}

	}

	private ISpringTemplateEngine templateEngine(ITemplateResolver templateResolver) {
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.addDialect(new Java8TimeDialect());
		engine.setTemplateResolver(templateResolver);
		return engine;
	}
	
	@GetMapping("/crearCsv")
	public String crearCsv(RedirectAttributes redAttr) {
		ExportarExcelCsv.crearArchivoCSV("todoelMundo", service.findAll());
		redAttr.addAttribute("alert", "Generación exitosa,\n Tu archivo CSV se guardo en Documents");
		return "redirect:/";
		
	}
	
	@GetMapping("/crearPDF")
	public void crearPdf() {
		Document doc=new Document();
	}
	
	@RequestMapping(value="/MyJson",method=RequestMethod.GET ,produces={"application/json"})
	public @ResponseBody Iterable<Alumno> returnGet () {
		try {
			
			return service.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
		}
		return service.findAll();
		
		
	}
	
}
