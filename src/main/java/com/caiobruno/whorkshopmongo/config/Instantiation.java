package com.caiobruno.whorkshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.caiobruno.whorkshopmongo.domain.Post;
import com.caiobruno.whorkshopmongo.domain.User;
import com.caiobruno.whorkshopmongo.dto.AuthorDTO;
import com.caiobruno.whorkshopmongo.dto.CommentDTO;
import com.caiobruno.whorkshopmongo.repository.PostRepository2;
import com.caiobruno.whorkshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository2 postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		postRepository.deleteAll();
		userRepository.deleteAll();	
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem"," Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia","Acordei feliz hoje!", new AuthorDTO(maria) );
		
		CommentDTO c1 = new CommentDTO(null," Boa viagem mano!", sdf.parse("2018/03/21"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO(null,"Aproveite!", sdf.parse("2018/03/22"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO(null,"Tenha um ótimo dia!", sdf.parse("2018/03/23"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));
		post2.getComments().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		
		userRepository.save(maria);
	    
	}

}
