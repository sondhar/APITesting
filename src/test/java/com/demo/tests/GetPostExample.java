package com.demo.tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetPostExample {

	@Test
	public void testGet() {

		baseURI = "https://reqres.in/api";

		given().get("users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George"))
				.body("data.first_name", hasItems("George", "Rachel"));
	}

	@Test
	public void testPost() {

		JSONObject req = new JSONObject();

		req.put("name", "Sonal");
		req.put("job", "Automation Tester");
		System.out.println(req.toJSONString());

		baseURI = "https://reqres.in/api";

		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(req.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
}
