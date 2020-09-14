package com.springboot.heroes.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

	@Override
	public Heroe buscarHeroe(Long idHeroe) {
		return heroeDao.findById(idHeroe).orElse(null);
	}

	@Override
	public List<Heroe> buscarByExample(Example<Heroe> example) {
		// TODO Auto-generated method stub
		return heroeDao.findAll(example);
	}

}
