package tests.apiPublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeleteObject {

    @Test
    public void deleteObject() {

        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("content-Type", "application/json");
        Response response = request
                .when()
                .delete("ff8081819071bec7019084c653d825c4");
        response.prettyPrint();
        int statuscode = response.statusCode();
        System.out.println("***" + statuscode + "****");
        Assert.assertEquals(statuscode, 200);
    }
}
