package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Email_Management_Dashboard_Page extends Admin_BaseClass {
    public Admin_Email_Management_Dashboard_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Email Management']")
    WebElement emailMgmt;
    @FindBy(xpath = "//*[text()='Back To Email Dashboard']")
    WebElement emailDashboard;
    @FindBy(xpath ="//*[text()='New Email']")
    WebElement newEmail;

    public void saveCTADisplayedAndFunctioning() throws Throwable {
        logger = report.startTest("TC-1889 The List of CTAs displays ");
        log.info("####### TC-1889 The List of CTAs displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMgmt);

        List<WebElement> options = driver.findElements(By.xpath("//span[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 crXLVV']"));
        for (int i = 0; i < options.size(); i++) {
            try {
                WebElement option = driver.findElements(By.xpath("//span[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 crXLVV']")).get(i);
                option.click();
                Thread.sleep(2000); // Replace with explicit wait
                emailDashboard.click();
                Thread.sleep(2000); // Replace with explicit wait
            } catch (StaleElementReferenceException e) {
                System.out.println("Element became stale, moving to the next one.");
            }
        }
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Email Dashboard/TC-1889 The List of CTAs.png"));
        if (newEmail.isDisplayed()) {
            log.info("####### TC-1889 The List of CTAs displays  #######");
            logger.log(LogStatus.PASS, "TC-1889 The List of CTAs displays ");
            logger.log(LogStatus.INFO, "The List of CTAs displayed and functioning as expected ");
        } else {
            log.info("####### TC-1889 The List of CTAs displays  #######");
            logger.log(LogStatus.FAIL, "TC-1889 The List of CTAs displays ");
            logger.log(LogStatus.INFO, "The List of CTAs displayed and not functioning as expected");
        }

    }
}

