package com.caiobruno.whorkshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.caiobruno.whorkshopmongo.domain.Post;
import com.caiobruno.whorkshopmongo.resources.ultil.URL;
import com.caiobruno.whorkshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService service;
    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value= "text" ,defaultValue = "") String text){
		
		text= URL.deCodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(@RequestParam(value= "text" ,defaultValue = "") String text,@RequestParam(value= "minDate" ,defaultValue = "") String minDate,@RequestParam(value= "maxDate" ,defaultValue = "") String maxDate){
		
		text= URL.deCodeParam(text);
		Date min= URL.converteDate(minDate, new Date(0L));
		Date max= URL.converteDate(maxDate, new Date());
		List<Post> list = service.fullSearch(text, min , max);
		return ResponseEntity.ok().body(list);
	}

}
