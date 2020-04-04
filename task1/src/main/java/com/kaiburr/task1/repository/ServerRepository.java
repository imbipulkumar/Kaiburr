package com.kaiburr.task1.repository;

import java.util.List;

import com.kaiburr.task1.model.Server;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServerRepository extends MongoRepository<Server, String> {

	List<Server> findByName(String name);
}