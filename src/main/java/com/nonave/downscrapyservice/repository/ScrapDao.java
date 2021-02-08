package com.nonave.downscrapyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nonave.downscrapyservice.repository.entity.Scrap;


public interface ScrapDao extends JpaRepository<Scrap, Long>{

	
	
}