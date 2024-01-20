package com.fjtechsolutions.CrudWithMongoDb.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDetailsDto {

    private int id;
    private String userId;
    private String password;
    private String sessionId;
    private Integer userRole;
    private boolean status;
    private Date logInTime;
    private Date logOutTime;
    private int  logInKey;
}
