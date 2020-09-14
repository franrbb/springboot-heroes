package com.springboot.heroes.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.heroes.app.models.entity.Heroe;

public interface IHeroeDao extends JpaRepository<Heroe, Long>{

}
