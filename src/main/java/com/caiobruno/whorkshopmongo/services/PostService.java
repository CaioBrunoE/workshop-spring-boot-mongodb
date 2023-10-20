package com.caiobruno.whorkshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiobruno.whorkshopmongo.domain.Post;
import com.caiobruno.whorkshopmongo.repository.PostRepository2;
import com.caiobruno.whorkshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository2 repository;
	
	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public  List<Post> findByTitle(String text){
	  
	     return repository.findByTitleContainingIgnoreCase(text);
	}
	
}
