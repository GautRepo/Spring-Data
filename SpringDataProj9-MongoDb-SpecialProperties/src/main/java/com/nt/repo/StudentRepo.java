package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Student;

public interface StudentRepo extends MongoRepository<Student,String>{

}
