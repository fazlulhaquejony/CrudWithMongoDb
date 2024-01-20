package com.fjtechsolutions.CrudWithMongoDb.service;

import com.fjtechsolutions.CrudWithMongoDb.dto.UserDetailsDto;
import com.fjtechsolutions.CrudWithMongoDb.dto.ResponseBody;

import java.security.NoSuchAlgorithmException;

public interface LoginService {

    ResponseBody save(UserDetailsDto loginDto) throws NoSuchAlgorithmException;

    ResponseBody update(UserDetailsDto loginDto) throws NoSuchAlgorithmException;
}
