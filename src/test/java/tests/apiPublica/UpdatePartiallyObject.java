package tests.apiPublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdatePartiallyObject {
    @Test
    public void updatePartialObject() {
        File putBody = new File("src/main/resources/UpdatePartiallyObject.json");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("content-Type", "application/json")
                .body(putBody);
        Response response = request
                .when()
                .patch("ff8081819071bec7019084c4da5b25c2");
        response.prettyPrint();
        int statuscode = response.statusCode();
        System.out.println("***" + statuscode + "****");
        Assert.assertEquals(statuscode, 200);
    }
}
