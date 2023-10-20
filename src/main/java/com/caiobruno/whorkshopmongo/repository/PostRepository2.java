package com.caiobruno.whorkshopmongo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.caiobruno.whorkshopmongo.domain.Post;

@Repository
public interface PostRepository2 extends MongoRepository<Post, String> {

	@Query("{ 'title': { $regex: ?0 , $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase (String text);
	
	@Query("{ $and: [ { date: { $gte: ?1 } }, { date: { $lte: ?2 } }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comment.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text ,Date date , Date maxtDate );
}
