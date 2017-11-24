package com.fortech.training.QuizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fortech.training.QuizApp.dao.UserRepository;
import com.fortech.training.QuizApp.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired private UserRepository userRepo;

	@Override
	public User save(User user) {
		
		if (user == null || user.getName() == null || user.getName() == "" ||
				user.getPassword() == null || user.getPassword() == "" ||
				user.getEmail() == null || user.getEmail() == "" ||
				userRepo.findByEmail(user.getEmail()) != null) {
			return null;
		}
		return userRepo.save(user);
	}

	@Override
	public User get(int id) {
		return userRepo.findOne(id);
	}

	@Override
	public List<User> getAll() {
		return userRepo.findAll();
	}

	@Override
	public void update(int id, User user) {
		if (user.getName() == null || user.getName() == "" ||
				user.getPassword() == null || user.getPassword() == "" ||
				user.getEmail() == null || user.getEmail() == "" ||
				userRepo.findByEmail(user.getEmail()) != null) {
			return;
		}
		user.setId(id);
		userRepo.save(user);
	}

	@Override
	public void delete(int id) {
		userRepo.delete(id);
	}
	
	@Override
	public boolean validateUser(String name, String password) {
		User user = userRepo.findByName(name);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		} return false;
	}
}
