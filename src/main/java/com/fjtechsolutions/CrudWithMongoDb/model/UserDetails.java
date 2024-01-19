package com.fjtechsolutions.CrudWithMongoDb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "user_details")
public class UserDetails {

    private int id;
    private String userId;
    private String sessionId;
    private Integer userRole;
    private boolean status;

}
