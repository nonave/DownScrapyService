package com.nonave.downscrapyservice.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(path = "/down")
public class ShareBookController {


	@GetMapping
	public ResponseEntity<List<Object>> getDown() {
		log.debug("find all Comment");
		return ResponseEntity.ok().build();
	}
}