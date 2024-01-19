package com.fjtechsolutions.CrudWithMongoDb.dto;

import lombok.Data;

@Data
public class UserDetailsDto {

    private int id;
    private String userId;
    private String sessionId;
    private Integer userRole;
    private boolean status;
}
