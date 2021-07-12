package br.com.alura.resource;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
public class BitcoinResourceTest {

	public void testarSeStatusDaRequisicaoIgualA200() {
		RestAssured
			.given().get("bitcoins").then().statusCode(200);
	}
}
