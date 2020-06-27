package com.eet3107.inscripciones.controllers;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eet3107.inscripciones.entidades.Alumno;
import com.eet3107.inscripciones.entidades.Legajo;
import com.eet3107.inscripciones.entidades.Tutor;
import com.eet3107.inscripciones.entidades.Usuario;
import com.eet3107.inscripciones.repositorios.AlumnoRepository;
import com.eet3107.inscripciones.repositorios.LegajoRepository;
import com.eet3107.inscripciones.repositorios.TutorRepository;
import com.eet3107.inscripciones.services.interfaces.UsuarioService;

@Controller
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	@Autowired
	TutorRepository turep;
	
	@Autowired
	LegajoRepository legrep;
	
	@Autowired
	AlumnoRepository rep;
	
	@Autowired 
	BCryptPasswordEncoder encoder;
	

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav=new ModelAndView("/login");
		Usuario user=new Usuario();
		mav.addObject("usuario", user);
		mav.addObject("signin",true);
		return mav;	
	}
	
	
	@GetMapping("/signup")
	public ModelAndView signUp() {
		ModelAndView mav=new ModelAndView();
		Usuario user=new Usuario();
		mav.addObject("signup",true);
		mav.addObject("usuario", user);
		mav.setViewName("/login");
		return mav;		
	}
	
	@GetMapping("/lista")
	public String dataTable() {
		return "tabla";
	}
	
	
	@PostMapping("/signup")	
	public ModelAndView crearCuentaUsuario(@Valid @ModelAttribute("usuario")Usuario usuario,BindingResult result) {
		
		ModelAndView mav=new ModelAndView("/login");		
		if(result.hasErrors()) 
		{	mav.addObject("userWrong",usuario);
			mav.addObject("error","Error de bindingresult");
			return mav;
		}else {
			try {
				Usuario user=new Usuario();
				user.setPassword(encoder.encode(usuario.getPassword()));
				user.setUserName(usuario.getUserName());
				user.setRol(usuario.getRol());
				service.crearUsuario(user);
				mav.addObject("newUser",usuario);
			} catch (Exception e) {
				mav.addObject("error",e.getMessage());
			}
		}
		return mav;
	}
	
	//TEST
	@GetMapping("/test")	
	public String testAlumno() {

		Alumno alu=new Alumno();
		//Legajo
		Legajo legajo=new Legajo();
		legajo.setCurso("1ºCB");
		legrep.save(legajo);
		//Tutor
		Tutor tutor=new Tutor();
		tutor.setNombre("Jesus");
		tutor.setDni("566");
		tutor.setParentezco("papa");
		turep.save(tutor);
		
		//Alumno
		alu.setLegajo(legajo);
		alu.setTutor(tutor);
		alu.setDni("45");
		alu.setNombre("Panchirulo");
		alu.setNacimiento(new Date());
		
		try {
			rep.save(alu);
		} catch (Exception e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		return "index";
		
	}
	
	
	
	
	//@PostMapping("/signup")
	//@PostMapping("/login")
	
	
}
