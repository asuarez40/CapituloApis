package tests.apiPublica;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleObjects {
    String path = "./Reporte/Apis2.html";
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter(path);
    @BeforeTest
    public void before(){
        extent.attachReporter(spark);
    }

    @Test
    @Parameters ({"id","expectedStatusCode"})
    public void getObjects(String id,int expectedStatusCode) {
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects/");
        Response response = request
                .when()
                .get(id);
        response.prettyPrint();
        int statuscode = response.statusCode();
        System.out.println("***" + statuscode + "***");
        Assert.assertEquals(statuscode, expectedStatusCode);

        JSONObject jsonObject = new JSONObject(response.asString());
        String name = jsonObject.getString("name");
        System.out.println("****"+name+"*****");

//        JSONObject jsonData = jsoneResponse.getJSOM
//        String data = jsonData.getString("CPU model");
//        System.out.println("****"+data+"****");

    }
}
