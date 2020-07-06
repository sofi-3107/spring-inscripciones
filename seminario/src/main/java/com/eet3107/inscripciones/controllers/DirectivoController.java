package com.eet3107.inscripciones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("directivo/")
public class DirectivoController {
	
	
	
	@GetMapping("/")
	public ModelAndView root() {
		ModelAndView mav=new ModelAndView("paneles");
		mav.addObject("titulo","Directora");
		mav.addObject("optionTitle","Generar graficos");
		mav.addObject("optionImg","graficos.jpg");
		mav.addObject("optionTitle2","Consultar Legajo");
		mav.addObject("optionImg2","consultaLegajo.png");
		return mav;
	}
	
	
	@GetMapping("/puta")
	public ModelAndView index () {
		ModelAndView mav=new ModelAndView("index");
		mav.addObject("titulo","PUTA");
		return mav;
	}

}
