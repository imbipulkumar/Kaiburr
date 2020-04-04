package io.swagger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.swagger.model.Server;

@Repository
public interface ServerRepository extends MongoRepository<Server, String> {

    Optional<Server> findById(String Id);

    List<Server> findByName(String name);

    void deleteById(String id);

	boolean existsById(String id);

}