package com.example.responseentitydeserialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class Main2 {

	public static void main(String[] args) throws Exception {

		ResponseEntity<Object> build = ResponseEntity.ok().build();

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.addMixIn(ResponseEntity.class, ResponseEntityMixin.class);

		String s = objectMapper.writeValueAsString(build);

		ResponseEntity<Object> result = objectMapper.readValue(s, ResponseEntity.class);

		System.out.println(result);


	}

	public abstract static class ResponseEntityMixin<T> {

		@JsonCreator
		public ResponseEntityMixin(@JsonProperty("body") T body, @JsonProperty("headers") MultiValueMap<String, String> headers, @JsonProperty("status") HttpStatus status) {
		}
	}
}
