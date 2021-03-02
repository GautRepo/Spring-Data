package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.doc.PersonInfo;

public interface PersonInfoRepo extends MongoRepository<PersonInfo, Integer>{
	
	


}
