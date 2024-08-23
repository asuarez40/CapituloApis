package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Calendar;
import java.util.Objects;

public class GenerateExtentReport {
    String path;
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark;
    ExtentTest test;

    public void geratorReport(String nameApi) {
        Calendar date = Calendar.getInstance();
        String dateReport = String.valueOf(date.get(Calendar.DATE) + date.get(Calendar.MONTH) + date.get(Calendar.YEAR) + date.get(Calendar.HOUR) + date.get(Calendar.MINUTE) + date.get(Calendar.SECOND));
        test = extent.createTest(nameApi);
        path = "./Reporte/Apis " + nameApi + "_" + dateReport;
        spark = new ExtentSparkReporter(path);
        extent.attachReporter(spark);

    }

    public void testLog(String status, String descriptionn) {

        if (Objects.equals(status, "FAIL") || Objects.equals(status, "Fail") || Objects.equals(status, "fail")) {
            test.log(Status.FAIL, descriptionn);
        } else if (Objects.equals(status, "PASS") || Objects.equals(status, "Pass") || Objects.equals(status, "pass")) {
            test.log(Status.PASS, descriptionn);
        } else if (Objects.equals(status, "INFO") || Objects.equals(status, "Info") || Objects.equals(status, "info")) {
            test.log(Status.INFO, descriptionn);
        }
    }

    public void finalReport() {
        extent.flush();
    }

}
