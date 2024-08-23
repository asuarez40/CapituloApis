package tests.apiPublica;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetWithUrlParams {
    @Test
    public void getWithUrlParams() {
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParam("id", 1, 2);
        Response response = request
                .when()
                .get();
        response.prettyPrint();
        int statuscode = response.statusCode();
        System.out.println("***" + statuscode + "****");
        Assert.assertEquals(statuscode, 200);

    }

    @Test
    public void getWithUrlParams1() {
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .formParam("id", "1")
                .formParam("id", "2");
        Response response = request
                .when()
                .get();
        response.prettyPrint();
        int statuscode = response.statusCode();
        System.out.println("***" + statuscode + "****");
        Assert.assertEquals(statuscode, 200);

    }
}
