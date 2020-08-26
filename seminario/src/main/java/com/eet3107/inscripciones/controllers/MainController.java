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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eet3107.inscripciones.entity.Usuario;
import com.eet3107.inscripciones.repository.UsuarioRepository;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	UsuarioRepository userRep;
	
	@GetMapping("/")
	public String getLogin(Model model) {
	model.addAttribute("titulo","Login de Usuario");
	model.addAttribute("usuario",new Usuario());
	model.addAttribute("button","Ingresar");
	model.addAttribute("create","0");
	return "login";	
	}
	
	
	@PostMapping("/")
	public String sendUser(@Valid @ModelAttribute("usuario")Usuario usuario,BindingResult userResult,Model model,RedirectAttributes redirect) {
		String url="";
		if(userResult.hasErrors()) {
			model.addAttribute("button","Ingresar");
			return "login";
		}else {
			Usuario user=userRep.findByUserNameAndPassword(usuario.getUserName(), usuario.getPassword());
			
			if(user!=null&&usuario.getRol().equals(user.getRol())) {
				System.out.println("user rol coincide: "+usuario.getRol().equals(user.getRol()));
				String rol=user.getRol();
				switch(rol) {
				case "administrativo":
					url= "redirect:/admin/";
					System.out.println("admin: "+url);
					break;
				case "directivo":
					url= "redirect:/directivo/";
					System.out.println("director: "+url);
					break;
				case "preceptor":
					url= "redirect:/preceptor/";
					System.out.println("preceptor: "+url);
					break;
				}
				
			}else {
				System.out.println("No coincidio rol");
				redirect.addAttribute("type","danger");
				redirect.addAttribute("message","Usuario,contraseña o rol incorrectos. Verifique");
				redirect.addAttribute("button","Ingresar");
				return "redirect:/";
			}
		}
		return url;
	}
	
	
	@GetMapping("/new")
	public String crearUsuario(Model model) {
		model.addAttribute("titulo","Crear nuevo Usuario");
		model.addAttribute("usuario",new Usuario());
		model.addAttribute("create","1");
		model.addAttribute("button","Crear");
		return "login";
	}
	
	
	@PostMapping("/new")	
	public String guardarNuevoUsuario(@Valid @ModelAttribute("usuario")Usuario usuario,BindingResult userResult,RedirectAttributes redirect,Model model ) {
		if(userResult.hasErrors()) {
			model.addAttribute("button","Crear");
			return "login";
			
		}else {
			if(userRep.findByUserNameAndPassword(usuario.getUserName(), usuario.getPassword())!=null) {
				redirect.addAttribute("userExist", "1");
				redirect.addAttribute("type","danger");
				redirect.addAttribute("message","El usuario y contraseña ya existen, elija otros por favor");
				model.addAttribute("create","0");
				return "redirect:/";
			}else {
				userRep.save(usuario);
				redirect.addAttribute("type", "success");
				redirect.addAttribute("message","Usuario creado correctamente");
				return "redirect:/";
			}
		}
	}

}
