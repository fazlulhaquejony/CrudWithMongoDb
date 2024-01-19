package com.fjtechsolutions.CrudWithMongoDb.service;

import com.fjtechsolutions.CrudWithMongoDb.dto.UserDetailsDto;
import com.fjtechsolutions.CrudWithMongoDb.dto.ResponseBody;

public interface LoginService {

    ResponseBody save(UserDetailsDto loginDto);
}
