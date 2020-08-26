package com.eet3107.inscripciones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eet3107.inscripciones.entity.Curso;

@Controller
@RequestMapping("/directivo/")
public class DirectivoController {
	
	
	
	@GetMapping("/")
	public ModelAndView root() {
		ModelAndView mav=new ModelAndView("paneles");
		mav.addObject("titulo","Directora");
		mav.addObject("optionTitle","Generar graficos");
		mav.addObject("optionImg","graficos.jpg");
		mav.addObject("url","/directivo/graficos");
		return mav;
	}
	
	
	@GetMapping("/graficos")
	public ModelAndView index () {
		ModelAndView mav=new ModelAndView("graficos");
		mav.addObject("titulo","Graficos Estadisticos");
		mav.addObject("curso",new Curso());
		return mav;
	}

}
