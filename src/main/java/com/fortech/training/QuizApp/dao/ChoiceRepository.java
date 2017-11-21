package com.fortech.training.QuizApp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fortech.training.QuizApp.entity.Choice;

@Repository
public interface ChoiceRepository extends CrudRepository<Choice, Integer>{

}
