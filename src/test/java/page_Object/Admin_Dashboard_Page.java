package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Dashboard_Page extends Admin_BaseClass {
    WebDriverWait wait;

    public Admin_Dashboard_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@placeholder='yours@example.com']")
    WebElement emailID;
    @FindBy(xpath = "//input[@placeholder='your password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='submit']")
    WebElement logIn;
    @FindBy(xpath = "//span[@class='components__Text-sc-1if6yln-0 bYNJvw']")
    WebElement clickProfile;
    @FindBy(xpath = "//*[text()='Sign Out']")
    WebElement signOut;
    @FindBy(xpath = "//*[text()='Yes']")
    WebElement clickYes;
    @FindBy(xpath = "//*[text()='Dashboard']")
    WebElement clickDashboard;
    @FindBy(xpath = "//*[text()='Actions Required']")
    WebElement actionReq;
    @FindBy(xpath = "//tr[@class='components__Th-jca4yq-13 ktKIEi']")
    WebElement tableHeaders;
    @FindBy(xpath = "(//div[@class=' css-1wy0on6'])[1]")
    WebElement clickReports;
    @FindBy(xpath = "(//div[@class=' css-1wy0on6'])[2]")
    WebElement clickYear;
    @FindBy(xpath = "(//div[@class=' css-1wy0on6'])[3]")
    WebElement clickChampionship;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement clickExport;
    @FindBy(xpath = "//div[@class='components__Text-sc-1if6yln-0 components__AdminTitle-sc-1if6yln-2 kPhxXk']")
    WebElement wb1;
    Actions act = new Actions(driver);


    public void actionsRequired(String validEmail, String validPassword) throws Throwable {
        logger = report.startTest("Admin DashBoard - TC-1848 Actions Required section is displayed and functioning ");
        log.info("####### Executing TC-1848 Actions Required section is displayed and functioning #######");
        Admin_Login_Page data = PageFactory.initElements(driver, Admin_Login_Page.class);
        data.loginMethod(validEmail, validPassword);
        Thread.sleep(2000);
        System.out.println("Current URL " + driver.getCurrentUrl());
        System.out.println(clickDashboard.getText());
        System.out.println(wb1.getText());
        Thread.sleep(5000);
        System.out.println(tableHeaders.getText());
        File screenShot = tableHeaders.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Admin Dashboard/TC-1848 DashboardTableData.png"));

        if (tableHeaders.getText().contains("Total Entries")) {
            log.info("####### TC-1848 Table with the following columns is displayed: Championship, Total Entries, Active Applications, Withdrawn Entries, Total Redbox, Q Status,Review Needed,Reviewed,Total Waitlisted #######");
            logger.log(LogStatus.PASS, "TC-1848 Actions Required section is displayed and functioning");
            logger.log(LogStatus.INFO, " Table with the following columns is displayed: Championship, Total Entries, Active Applications, Withdrawn Entries, Total Redbox, Q Status,Review Needed,Reviewed,Total Waitlisted");
        } else {
            log.info("####### TC-1848 Table with the following columns is not displayed: Championship, Total Entries, Active Applications, Withdrawn Entries, Total Redbox, Q Status,Review Needed,Reviewed,Total Waitlisted #######");
            logger.log(LogStatus.FAIL, "TC-1848 Actions Required section is displayed and functioning");
            logger.log(LogStatus.INFO, "Table with the following columns is not displayed: Championship, Total Entries, Active Applications, Withdrawn Entries, Total Redbox, Q Status,Review Needed,Reviewed,Total Waitlisted");
        }
        clickProfile.click();
        signOut.click();
        clickYes.click();


    }

    public void reportsDisplayed(String validEmail, String validPassword) throws Throwable {
        logger = report.startTest("Admin DashBoard - TC-1853 Reports is displayed and functioning ");
        log.info("####### Executing TC-1853 Reports is displayed and functioning #######");
        emailID.sendKeys(validEmail);
        password.sendKeys(validPassword);
        logIn.click();
        Thread.sleep(2000);
        act.moveToElement(actionReq).click().perform();
        act.moveToElement(clickReports).click().perform();

        Thread.sleep(1000);

        List<WebElement> reportOptions = driver.findElements(By.xpath("//div[@class=' css-yt9ioa-option']"));
        String reportVal = "All Exemptions";
        for (WebElement option : reportOptions) {
            if ((option.getText()).equals(reportVal)) {
                act.moveToElement(option).click().perform();
                break;
            }
        }
        Thread.sleep(1000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[@class=' css-yt9ioa-option']"));
        String yearVal = "2024";
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                act.moveToElement(option).click().perform();
                break;
            }
        }
        Thread.sleep(1000);

        clickChampionship.click();

        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class=' css-yt9ioa-option']"));
        String champValue = "124th U.S. Amateur Championship";
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champValue)) {
                act.moveToElement(option).click().perform();
                break;
            }
        }

        clickExport.click();
        Thread.sleep(4000);

        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Admin Dashboard/TC-1853 AllExemptionReport.png"));

        // ***** Iterating report for Watch List
        clickReports.click();
        Thread.sleep(2000);

        reportOptions = driver.findElements(By.xpath("//div[@class=' css-yt9ioa-option']"));
        String val = "Watch List";
        for (WebElement option : reportOptions) {
            if ((option.getText()).equals(val)) {
                act.moveToElement(option).click().perform();
                break;
            }
        }

        if (clickExport.isDisplayed()) {
            clickExport.click();
            Thread.sleep(2000);
            log.info("####### TC-1853 Export button is working as expected #######");

            logger.log(LogStatus.PASS, "TC-1853 Reports is displayed and functioning ");
            logger.log(LogStatus.INFO, " Export button is working as expected ");
        } else {
            log.info("####### TC-1853 ClickExport button is not enabled #######");
            logger.log(LogStatus.FAIL, "TC-1853 Reports is displayed and functioning ");
            logger.log(LogStatus.INFO, " ClickExport button is not enabled");
        }


    }
}

