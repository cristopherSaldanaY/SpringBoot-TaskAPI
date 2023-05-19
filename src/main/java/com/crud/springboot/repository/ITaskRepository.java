package com.crud.springboot.repository;

import com.crud.springboot.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ITaskRepository extends MongoRepository<Task, String>{
}

