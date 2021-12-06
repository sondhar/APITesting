package com.demo.tests;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstDemo {
	
	@Test
	public static void getUsersById() {
		Response response = RestAssured.get("https://reqres.in/api/users/2");
		System.out.println(response.asPrettyString());
		
	}
	

}
