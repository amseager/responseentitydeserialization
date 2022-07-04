package com.example.responseentitydeserialization;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Example {
    public static void main(String[] args) {


        // Create a Response Entity
        ResponseEntity<Object> entity = new ResponseEntity<>("\"msg\":\"hola mundo\"", HttpStatus.OK);


        // Serializing the Response Entity
        String jsonEntity = ResponseEntityMapper.serializeEntity(entity);
        System.out.println(jsonEntity);


        // Deserializing the Response Entity
        ResponseEntity<Object> deserlializedEntity = ResponseEntityMapper.deserializeEntity(jsonEntity);
        System.out.println(deserlializedEntity);

    }
}
