package com.springboot.heroes.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.heroes.app.models.service.IHeroeService;

@Controller
public class HeroeController {
	
	@Autowired
	private IHeroeService heroeService;
	
	@GetMapping({"/heroes", "/"})
	public String heroes(Model model) {
		
		model.addAttribute("titulo", "Heroes");
		model.addAttribute("heroes", heroeService.listaHeroes());
		
		return "heroes";
	}

}
