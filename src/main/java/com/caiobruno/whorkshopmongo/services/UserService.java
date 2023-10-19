package com.caiobruno.whorkshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiobruno.whorkshopmongo.domain.User;
import com.caiobruno.whorkshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository ;
	
	public List<User> findAll(){
		return repository.findAll();
	}
}
