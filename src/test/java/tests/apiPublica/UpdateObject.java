package tests.apiPublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UpdateObject {

    @Test
    public void updateObject() {
        File putBody = new File("src/main/resources/UpdateObjects.json");

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("content-Type", "application/json")
                .body(putBody);
        Response response = request
                .when()
                .put("ff8081819071bec7019084c4da5b25c2");
        response.prettyPrint();
        int statuscode = response.statusCode();
        System.out.println("***" + statuscode + "****");
        Assert.assertEquals(statuscode, 200);
    }
}
