package test_Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.ExtentReportManager;


public class Admin_BaseClass extends ExtentReportManager {
    public static WebDriver driver;
    public static Properties conpro;
    public static Logger log;
    public static ExtentTest logger;
    public static ExtentReports report;
    public TakesScreenshot snapshot;
    public Actions act;

    @BeforeSuite
    public void start() {
        report = new ExtentReports("target/Extent-Reports/USGA Champ Admin.html");

    }

    @BeforeClass
    @Parameters("browser")
    public void testSetup(String browser) throws Throwable {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Invalid Browser");
                return;

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        act = new Actions(driver);
    }


    @BeforeMethod
    public void openBrowser() throws Throwable {
        conpro = new Properties();
        conpro.load(new FileInputStream("./src/test/resources/config.properties"));
        log = LogManager.getLogger(this.getClass());
        driver.manage().deleteAllCookies();
        driver.get(conpro.getProperty("url"));
        System.out.println("We are currently on the following URL : " + driver.getCurrentUrl());


    }

    @AfterClass(enabled = true)
    public void teardown() {
     //   driver.quit();
        report.endTest(logger);
        report.flush();
    }

    @AfterSuite
    public void endUp() {
//        reports.endTest(loggers);
//        reports.flush();


        report.endTest(logger);
        report.flush(); // This writes the entire report to the file
    }

    public String captureScreen(String tname) {
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<< 'This TestCase Execution got failed' >>>>>>>>>>>>>>>>>>>>>>>>>>>");
        // Method to capture a screenshot
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String currentBinaryDir = System.getProperty("user.dir");
        String directoryPath = currentBinaryDir + "/target/ScreenShots/Failed-TestCases/";
        String targetFilePath = directoryPath + tname + "_" + timeStamp + ".png";
        try {
            // Ensure the directory exists
            Files.createDirectories(Paths.get(directoryPath));
            // Capture and save the screenshot
            TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
            File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
            File targetFile = new File(targetFilePath);
            sourceFile.renameTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to create directory or save screenshot: " + e.getMessage());
        }
        return timeStamp;
    }
}
