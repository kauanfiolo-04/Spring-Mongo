package com.javacourse_fiolo04.spring_mongo.repositories;

import com.javacourse_fiolo04.spring_mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
