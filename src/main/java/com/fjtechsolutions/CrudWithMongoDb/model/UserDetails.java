package com.fjtechsolutions.CrudWithMongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "userDetails")
//@Document(collation = "userDetails")
public class UserDetails {

    private int id;
    private String userId;
    private String password;
    private String sessionId;
    private Integer userRole;
    private boolean status;

}
