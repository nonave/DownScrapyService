package com.nonave.downscrapyservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nonave.downscrapyservice.repository.ScrapDao;
import com.nonave.downscrapyservice.repository.entity.Scrap;
import com.nonave.downscrapyservice.request.ScrapRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/scrap")
public class ShareBookController {

	@Autowired
	private ScrapDao scrapDao;
	
	@GetMapping
	public ResponseEntity<List<Scrap>> getScraps() {
		log.debug("find all scrapt");
		return ResponseEntity.ok(scrapDao.findAll());
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Scrap> getScrapbyId(@PathVariable("id") Long id) {
		Optional<Scrap> optionalScrap = scrapDao.findById(id);
		return (optionalScrap.isPresent()) ? ResponseEntity.ok(optionalScrap.get())	: ResponseEntity.noContent().build();

	}
	
	@PostMapping
	public ResponseEntity<Scrap> createScrap(@RequestBody ScrapRequest scrapRequest) {
		Scrap s = new Scrap();
		scrapDao.save(s);
		return ResponseEntity.ok(s);
	}
	
	// algo
	
}