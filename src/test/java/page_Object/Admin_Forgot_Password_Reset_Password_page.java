package page_Object;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import test_Base.Admin_BaseClass;

public class Admin_Forgot_Password_Reset_Password_page extends Admin_BaseClass {
    WebDriverWait wait;

    public Admin_Forgot_Password_Reset_Password_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@class='auth0-lock-alternative-link']")
    WebElement forgotPswd;
    @FindBy(xpath = "//span[text()='Send email']")
    WebElement sendEmail;
    @FindBy(xpath = "//input[@placeholder='yours@example.com']")
    WebElement emailID;

    public void recoverPassword(String invalidEmail, String validEmail) throws Exception {
        logger = report.startTest("Forget Psrwd & Reset Pswrd -  TC-1851 Recover Password CTA is active and functioning \n TC-1860 Module is displayed in a pop up\n TC- 1817 Email Field is required, displayed and functioning  ");
        log.info("####### Executing  TC-1851 Recover Password CTA is active and functioning, TC-1860 Module is displayed in a pop up, TC- 1817 Email Field is required, displayed and functioning  #######");

        forgotPswd.click();

        emailID.sendKeys(invalidEmail);
        Thread.sleep(1000);
        sendEmail.click();

        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/ForgotPswdInvalidEmail.png"));

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", emailID);

        emailID.sendKeys(validEmail);
        Thread.sleep(1000);

        if(sendEmail.isDisplayed()) {
            sendEmail.click();
            Thread.sleep(3000);
            log.info("#######  TC-1851 Errors are encountered and displayed, TC-1860 Pop up is displayed, TC- 1817 The Email field is required messagge is displayed #######");
            logger.log(LogStatus.PASS, " TC-1851 Recover Password CTA is active and functioning, TC-1860 Module is displayed in a pop up, TC- 1817 Email Field is required, displayed and functioning ");
            logger.log(LogStatus.INFO, " TC-1851 Errors are encountered and displayed, TC-1860 Pop up is displayed, TC- 1817 The Email field is required messagge is displayed ");

        }else{
            log.info("#######   TC-1851 Errors are not encountered and displayed, TC-1860 Pop up is not displayed, TC- 1817 The Email field is required messagge is not displayed  #######");
            logger.log(LogStatus.FAIL, "TC-1851 Recover Password CTA is active and functioning, TC-1860 Module is displayed in a pop up, TC- 1817 Email Field is required, displayed and functioning ");
            logger.log(LogStatus.INFO, " TC-1851 Errors are not encountered and displayed, TC-1860 Pop up is not displayed, TC- 1817 The Email field is required messagge is not displayed ");

        }


    }

}
