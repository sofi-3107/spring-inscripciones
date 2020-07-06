package com.eet3107.inscripciones.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("preceptor/")
public class PreceptorController {
	
	
	
	@GetMapping("/")
	public String raiz() {
		return "index";
	}

}
