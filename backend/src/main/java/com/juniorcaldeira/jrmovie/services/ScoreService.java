package com.juniorcaldeira.jrmovie.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juniorcaldeira.jrmovie.dto.MovieDTO;
import com.juniorcaldeira.jrmovie.dto.ScoreDTO;
import com.juniorcaldeira.jrmovie.entities.Movie;
import com.juniorcaldeira.jrmovie.entities.Score;
import com.juniorcaldeira.jrmovie.entities.User;
import com.juniorcaldeira.jrmovie.repositories.MovieRepository;
import com.juniorcaldeira.jrmovie.repositories.ScoreRepository;
import com.juniorcaldeira.jrmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO SaveScore(ScoreDTO dto ) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if(user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();
			}
		
		double avg = sum / movie.getScores().size();
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		return new MovieDTO(movie);
	}
	
}
