package com.fortech.training.QuizApp.service;

import java.util.List;

import com.fortech.training.QuizApp.entity.User;

public interface UserService {
		
	User save(User user);
	
	User get(int id);
		
	List<User> getAll();
		
	void update(int id, User user);
	
	void delete(int id);
	
	boolean validateUser(String user, String password);

}
