package com.fortech.training.QuizApp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fortech.training.QuizApp.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	User findByName(String name);
	User findByEmail(String email);
	List<User> findAll();
}