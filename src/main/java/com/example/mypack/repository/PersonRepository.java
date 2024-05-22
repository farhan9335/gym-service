package com.example.mypack.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.mypack.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

}
