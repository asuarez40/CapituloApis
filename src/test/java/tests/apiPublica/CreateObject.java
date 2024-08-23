package tests.apiPublica;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


public class CreateObject {
    String path = "./Reporte/Apis.html";
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter(path);
    ExtentTest test;

    @Test

    public void createObject() {
//        try {
        extent.attachReporter(spark);
        test = extent.createTest("Prueba");
        File postBody = new File("src/main/resources/CreateObject.json");
        test.log(Status.INFO, "Paso la ruta del archivo del body que es " + postBody);
        RequestSpecification request = given()
                .baseUri("https://api.restful-api.dev")
                .basePath("/objects")
                .header("content-Type", "application/json")
                .body(postBody);
        Response response = request
                .when()
                .post();
        test.log(Status.INFO, "Se realizo el consumo del API");
        response.prettyPrint();
        int statuscode = response.statusCode();
        test.log(Status.INFO, "El status code es: " + statuscode);
        System.out.println("***" + statuscode + "****");
            Assert.assertEquals(statuscode, 200);
//        } catch (Exception e) {
//            System.out.println("Error: "+e);
//        }
   }
    @AfterMethod

    public void afterMethod (ITestResult result){
        if(result.getStatus()== ITestResult.FAILURE){
            test.log(Status.FAIL, "Fue fallido el test ");
        }else {
            test.log(Status.PASS, "Fue exitoso el Test");
        }
        extent.flush();
    }
}

