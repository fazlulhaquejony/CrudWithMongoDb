package com.fjtechsolutions.CrudWithMongoDb.repository;

import com.fjtechsolutions.CrudWithMongoDb.model.LoginDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginDetailsRepo extends MongoRepository<LoginDetails, String> {
}
