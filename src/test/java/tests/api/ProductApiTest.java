package tests.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProductApiTest {

    @Test
    public void getProductsApiShouldReturn200() {

        RestAssured.baseURI = "https://practicesoftwaretesting.com";

        given()
                .when()
                .get("/api/products")
                .then()
                .statusCode(200);
    }
}
