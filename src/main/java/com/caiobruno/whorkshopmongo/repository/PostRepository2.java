package com.caiobruno.whorkshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.caiobruno.whorkshopmongo.domain.Post;

@Repository
public interface PostRepository2 extends MongoRepository<Post, String> {

}