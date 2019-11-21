package com.example.responseentitydeserialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Main3 {

	public static void main(String[] args) throws Exception {

		ResponseEntity<Object> build = ResponseEntity.ok().build();

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.addMixIn(ResponseEntity.class, ResponseEntityMixin.class);

		String s = objectMapper.writeValueAsString(build);

		ResponseEntity<Object> result = objectMapper.readValue(s, ResponseEntity.class);

		System.out.println(result);


	}

	public abstract static class ResponseEntityMixin<T> {

		@JsonCreator(mode = JsonCreator.Mode.DELEGATING)
		public ResponseEntityMixin(@JsonProperty("status") HttpStatus status) {
		}
	}
}
