package com.eet3107.inscripciones.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eet3107.inscripciones.entidades.Usuario;
import com.eet3107.inscripciones.repositorios.UsuarioRepository;
import com.eet3107.inscripciones.services.UsuarioServiceImpl;


@RestController
@RequestMapping("/api")

public class AsyncController {
	
	

	@Autowired
	UsuarioRepository rep;
	@Autowired
	UsuarioServiceImpl service; 
	
	
	@RequestMapping (value="/users",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public  Iterable<Usuario>  getAll(){		
			return rep.findAll();
	}
	
	@GetMapping ("/usuarios")
	public  List<Usuario>  getAllUsers(){		
			return service.getUsuarios();
	}
	
	
	@GetMapping(value="/users/find")
	public Usuario getUser(@RequestParam(name = "id", required = true) int id) {
		return service.findUsuarioById(id);
	}
}
