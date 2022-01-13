package com.juniorcaldeira.jrmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniorcaldeira.jrmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{

}
