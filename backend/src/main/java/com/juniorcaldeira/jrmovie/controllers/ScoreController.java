package com.juniorcaldeira.jrmovie.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juniorcaldeira.jrmovie.dto.MovieDTO;
import com.juniorcaldeira.jrmovie.dto.ScoreDTO;
import com.juniorcaldeira.jrmovie.services.ScoreService;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	
	@PutMapping
	public MovieDTO saveScore(@RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = service.SaveScore(dto);	
		return movieDTO;
		}

}
