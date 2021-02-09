package com.nonave.downscrapyservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nonave.downscrapyservice.repository.entity.Plugin;


public interface PluginDao extends JpaRepository<Plugin, Long>{

	
	
}