package com.stgtrainingproject.trainingproject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stgtrainingproject.trainingproject.entities.Card;

public interface CardDao extends JpaRepository<Card, Integer > {

}
