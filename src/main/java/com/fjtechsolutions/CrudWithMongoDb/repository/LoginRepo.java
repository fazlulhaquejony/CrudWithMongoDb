package com.fjtechsolutions.CrudWithMongoDb.repository;

import com.fjtechsolutions.CrudWithMongoDb.model.LoginDetails;
import com.fjtechsolutions.CrudWithMongoDb.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginRepo extends MongoRepository<UserDetails, String> {
}
