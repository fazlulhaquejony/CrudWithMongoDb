package com.fjtechsolutions.CrudWithMongoDb.service;

import com.fjtechsolutions.CrudWithMongoDb.dto.UserDetailsDto;
import com.fjtechsolutions.CrudWithMongoDb.dto.ResponseBody;
import com.fjtechsolutions.CrudWithMongoDb.model.LoginDetails;
import com.fjtechsolutions.CrudWithMongoDb.model.UserDetails;
import com.fjtechsolutions.CrudWithMongoDb.repository.LoginRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImp implements LoginService{

    LoginRepo loginRepo;

    @Autowired
    public LoginServiceImp(LoginRepo loginRepo)
    {
        this.loginRepo = loginRepo;
    }
    @Override
    public ResponseBody save(UserDetailsDto userDetailsDto) {

        ResponseBody responseBody = new ResponseBody();
        UserDetails userDetails =new UserDetails();
        System.out.println("userDetailsDto===>"+userDetailsDto);
        BeanUtils.copyProperties(userDetailsDto,userDetails);
        System.out.println("userDetails===>"+userDetails);
         loginRepo.save(userDetails);
        responseBody.setMessage("Inserted SuccessFully");
        responseBody.setStatusCode(200);

        return responseBody;
    }
}
