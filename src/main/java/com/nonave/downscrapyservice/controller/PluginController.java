package com.nonave.downscrapyservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nonave.downscrapyservice.repository.PluginDao;
import com.nonave.downscrapyservice.repository.entity.Plugin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/plugin")
public class PluginController {

	@Autowired
	private PluginDao pluginDao;
	
	@GetMapping
	public ResponseEntity<List<Plugin>> getPlugin() {
		log.debug("find all scrapt");
		return ResponseEntity.ok(pluginDao.findAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Plugin> getPluginbyId(@PathVariable("id") Long id) {
		Optional<Plugin> optionalPlugin = pluginDao.findById(id);
		return (optionalPlugin.isPresent()) ? ResponseEntity.ok(optionalPlugin.get()): ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Plugin> createPlugin(@RequestBody Plugin plugin ) {
		pluginDao.save(plugin);
		return ResponseEntity.ok(plugin);
	}
	
	// TODO bug no content
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Plugin> deletePlugin(@PathVariable("id") Long id) {
		pluginDao.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
}