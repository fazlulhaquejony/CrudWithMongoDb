package com.fjtechsolutions.CrudWithMongoDb.conroller;

import com.fjtechsolutions.CrudWithMongoDb.dto.UserDetailsDto;
import com.fjtechsolutions.CrudWithMongoDb.dto.ResponseBody;
import com.fjtechsolutions.CrudWithMongoDb.service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLogIn {

    LoginService loginService;

    public UserLogIn(LoginService loginService)
    {
        this.loginService=loginService;
    }

    @GetMapping("/login")
    public ResponseBody userLogin(@RequestBody UserDetailsDto loginRequest) throws Exception
    {
        System.out.println("Login Started===>");
        return loginService.save(loginRequest);

    }
}
