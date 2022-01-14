package com.juniorcaldeira.jrmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.juniorcaldeira.jrmovie.entities.Score;
import com.juniorcaldeira.jrmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{

}
