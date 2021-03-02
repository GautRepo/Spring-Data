package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.doc.Person;

public interface IPersonRepo extends MongoRepository<Person, Integer>{

}
