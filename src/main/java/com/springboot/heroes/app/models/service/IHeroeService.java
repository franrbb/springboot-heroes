package com.springboot.heroes.app.models.service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.springboot.heroes.app.models.entity.Heroe;

public interface IHeroeService {
	
	public List<Heroe> listaHeroes();
	
	public Heroe buscarHeroe(Long idHeroe);
	
	public List<Heroe> buscarByExample(Example<Heroe> example);

}
