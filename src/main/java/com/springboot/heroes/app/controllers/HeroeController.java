package com.springboot.heroes.app.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springboot.heroes.app.models.service.IHeroeService;

@Controller
public class HeroeController {
	
	@Autowired
	private IHeroeService heroeService;
	
	@GetMapping("/home")
	public String home(Model model) {
		
		model.addAttribute("titulo", "Home");
		
		return "home";
	}
	
	@GetMapping("/heroes")
	public String heroes(Model model) {
		
		model.addAttribute("titulo", "Heroes");
		model.addAttribute("heroes", heroeService.listaHeroes());
		
		return "heroes";
	}
	
	@GetMapping("/about")
	public String about(Model model) {
		
		model.addAttribute("titulo", "About");
		
		return "about";
	}
	
	@ModelAttribute("anio")
	public int obtenerFechaActual() {
		
		Calendar cal = Calendar.getInstance();
		int anio = cal.get((Calendar.YEAR));
		
		return anio;
	}

}
