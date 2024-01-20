package com.fjtechsolutions.CrudWithMongoDb.repository;

import com.fjtechsolutions.CrudWithMongoDb.model.LoginDetails;
import com.fjtechsolutions.CrudWithMongoDb.model.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface LoginRepo extends MongoRepository<UserDetails, String> {

    @Query(value="{ userId : ?0}", fields="{ userId : 0 }")
    UserDetails findByUserId(String userId);
}
