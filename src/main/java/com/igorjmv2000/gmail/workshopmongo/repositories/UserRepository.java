package com.igorjmv2000.gmail.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.igorjmv2000.gmail.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
