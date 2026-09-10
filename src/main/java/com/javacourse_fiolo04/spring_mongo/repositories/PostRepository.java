package com.javacourse_fiolo04.spring_mongo.repositories;

import com.javacourse_fiolo04.spring_mongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
