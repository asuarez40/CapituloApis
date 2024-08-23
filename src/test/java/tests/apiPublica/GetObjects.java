package tests.apiPublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetObjects {

    @Test
    public void getObjects() {
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects");
        Response response = request
                .when()
                .get();
        response.prettyPrint();
        int statuscode = response.statusCode();
        System.out.println("***" + statuscode + "****");
        Assert.assertEquals(statuscode, 200);
    }
}
