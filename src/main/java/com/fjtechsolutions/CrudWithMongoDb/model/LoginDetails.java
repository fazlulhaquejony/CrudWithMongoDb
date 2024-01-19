package com.fjtechsolutions.CrudWithMongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "LoginDetails")
public class LoginDetails {

    private Date logInTime;
    private Date logOutTime;
    private int  logInKey;

}
