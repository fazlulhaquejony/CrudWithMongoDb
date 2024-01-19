package com.fjtechsolutions.CrudWithMongoDb.dto;

import lombok.Data;

@Data
public class ResponseBody {

     private String message;
     private Integer statusCode;
     private String error;
}
