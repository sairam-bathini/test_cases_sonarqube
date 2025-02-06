package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import test_Base.Admin_BaseClass;

@Listeners(utilities.ExtentReportManager.class)
public class ExtentReportManager implements ITestListener{
    public ExtentSparkReporter sparkReporter;
    public ExtentReports reports;
    public ExtentTest test;
    String reportName;

    public void onStart(ITestContext testContext) {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = "Test-Report" + timeStamp + ".html";

        sparkReporter = new ExtentSparkReporter("./target/" + reportName);
        sparkReporter.config().setDocumentTitle("ChampAdmin Automation Report");
        sparkReporter.config().setReportName("ChampAdmin.com Regression Test Cases Report");
        sparkReporter.config().setTheme(Theme.DARK);

        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        reports.setSystemInfo("Application", "ChampAdmin");
        String os = testContext.getCurrentXmlTest().getParameter("os");
        reports.setSystemInfo("Operating System", os);
        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        reports.setSystemInfo("Browser", browser);
    }

    public void onTestSuccess(ITestResult result) {
        test = reports.createTest(result.getTestClass().getName()+" ");

        test.log(Status.PASS, result.getName() + "  got successfully executed");
        test.info(result.getName() + " passed.");
    }

    public void onTestFailure(ITestResult result) {
        test = reports.createTest(result.getTestClass().getName()+" ");

        test.log(Status.FAIL, result.getName() + "  got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());
        test.info(result.getName() + " failed.");
//		test.error(result.getName() + " failed with exception: " + result.getThrowable().getMessage());
        try {
            String classname =result.getTestClass().getName();
//            if(classname.equalsIgnoreCase("testCases.Trials"))
//            {
//                String imgPath1 = new TrailsBaseClass().captureScreen(result.getName());
//                test.addScreenCaptureFromPath(imgPath1);
//            }else {
                String imgPath2 = new Admin_BaseClass().captureScreen(result.getName());
                test.addScreenCaptureFromPath(imgPath2);
           // }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onTestSkipped(ITestResult result) {
        test = reports.createTest(result.getTestClass().getName());
        test.log(Status.SKIP, result.getName() + " got skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext  context) {
        reports.flush();

        String pathOfExtentReport = System.getProperty("user.dir") + "/target/" + reportName;
        File extentReport = new File(pathOfExtentReport);
        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
