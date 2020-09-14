package com.springboot.heroes.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.heroes.app.models.dao.IHeroeDao;
import com.springboot.heroes.app.models.entity.Heroe;

@Service
public class HeroeServiceImpl implements IHeroeService {
	
	@Autowired
	private IHeroeDao heroeDao;

	@Override
	public List<Heroe> listaHeroes() {
		return heroeDao.findAll();
	}

}
