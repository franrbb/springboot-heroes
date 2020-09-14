package com.springboot.heroes.app.controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.heroes.app.models.entity.Heroe;
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
	
	@GetMapping("/heroe/{id}")
	public String heroe(@PathVariable(value = "id")Long id, Heroe heroe, Model model) {
		
		if(id > 0) {
			heroe = heroeService.buscarHeroe(id);
		}
		
		model.addAttribute("heroe", heroe);
		
		return "verHeroe";
	}
	
	@GetMapping("/search")
	public String buscar(@ModelAttribute("search") Heroe heroe, Model model) {
		
		Heroe heroeSearch = new Heroe();
		heroeSearch.reset();
		
		ExampleMatcher matcher = ExampleMatcher.
				// where descripcion like '%?%'
				matching().withMatcher("nombre", ExampleMatcher.GenericPropertyMatchers.contains());
		
		Example<Heroe> example = Example.of(heroe, matcher);
		List<Heroe> heroes = heroeService.buscarByExample(example);
		
		model.addAttribute("heroes", heroes);
		model.addAttribute("search",heroeSearch);
		
		return "heroes";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		Heroe heroeSearch = new Heroe();
		heroeSearch.reset();
		model.addAttribute("search",heroeSearch);
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
