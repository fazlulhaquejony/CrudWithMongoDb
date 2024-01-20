package com.fjtechsolutions.CrudWithMongoDb.service;

import com.fjtechsolutions.CrudWithMongoDb.dto.UserDetailsDto;
import com.fjtechsolutions.CrudWithMongoDb.dto.ResponseBody;
import com.fjtechsolutions.CrudWithMongoDb.model.LoginDetails;
import com.fjtechsolutions.CrudWithMongoDb.model.UserDetails;
import com.fjtechsolutions.CrudWithMongoDb.repository.LoginDetailsRepo;
import com.fjtechsolutions.CrudWithMongoDb.repository.LoginRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.UUID;

@Service
public class LoginServiceImp implements LoginService{

    LoginRepo loginRepo;
    ResponseBody responseBody= new ResponseBody();

    UserDetails userDetails = new UserDetails();

    LoginDetails loginDetails = new LoginDetails();

    LoginDetailsRepo loginDetailsRepo;

    @Autowired
    public LoginServiceImp(LoginRepo loginRepo,LoginDetailsRepo loginDetailsRepo)
    {
        this.loginRepo = loginRepo;
        this.loginDetailsRepo = loginDetailsRepo;
    }
    @Override
    public ResponseBody save(UserDetailsDto userDetailsDto) throws NoSuchAlgorithmException {

        String uniqueID = getUniqueKey();
        System.out.println("uniqueID update===>"+uniqueID);
        userDetailsDto.setSessionId(uniqueID);
        userDetailsDto.setPassword(getEncryptPassword(userDetailsDto.getPassword()));
        System.out.println("userDetailsDto.getPassword==>"+userDetailsDto.getPassword());
        System.out.println("uniqueID update===>"+uniqueID);
        System.out.println("userDetailsDto===>"+userDetailsDto);
        BeanUtils.copyProperties(userDetailsDto,userDetails);
        System.out.println("userDetails===>"+userDetails);
         loginRepo.insert(userDetails);
        responseBody.setMessage("Inserted SuccessFully");
        responseBody.setStatusCode(200);

        return responseBody;
    }

    @Override
    public ResponseBody update(UserDetailsDto userDetailsDto) throws NoSuchAlgorithmException {

        UserDetails userDetailsExist = loginRepo.findByUserId(userDetailsDto.getUserId());
        System.out.println("userDetailsExist===>"+userDetailsExist);

        if((Objects.equals(getEncryptPassword(userDetailsDto.getPassword()), userDetailsExist.getPassword())))
        {
            String uniqueID = getUniqueKey();
            System.out.println("uniqueID update===>"+uniqueID);

            userDetailsDto.setSessionId(uniqueID);
            System.out.println("userDetailsDto update===>"+userDetailsDto);

            BeanUtils.copyProperties(userDetailsDto,userDetails);
            System.out.println("userDetailsDto update copy===>"+userDetailsDto);
            BeanUtils.copyProperties(userDetailsDto,loginDetails);
            System.out.println("userDetails update===>"+userDetails);

            loginDetailsRepo.save(loginDetails);
            loginRepo.save(userDetails);

            responseBody.setMessage("Login SuccessFull");
            responseBody.setStatusCode(200);

        }
        else
        {
            responseBody.setMessage("LogIn Failed");
            responseBody.setStatusCode(100);
        }



        return responseBody;
    }

    public  String getUniqueKey()
    {
        return UUID.randomUUID().toString().replace("-","");
    }

    public  String getEncryptPassword(String password) throws NoSuchAlgorithmException {

        MessageDigest m = MessageDigest.getInstance("MD5");

        /* Add plain-text password bytes to digest using MD5 update() method. */
        m.update(password.getBytes());

        /* Convert the hash value into bytes */
        byte[] bytes = m.digest();

        /* The bytes array has bytes in decimal form. Converting it into hexadecimal format. */
        StringBuilder s = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        /* Complete hashed password in hexadecimal format */
        System.out.println("hashing==>"+s);
        //return null;
        return s.toString();
    }
}
