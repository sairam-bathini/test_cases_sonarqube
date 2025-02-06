package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.time.Duration;

public class Admin_login_pop_up_page extends Admin_BaseClass {


    WebDriverWait wait;

    public Admin_login_pop_up_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//button[@name='submit']")
    WebElement login;
    @FindBy(xpath = "//input[@placeholder='yours@example.com']")
    WebElement emailID;
    @FindBy(xpath = "//input[@placeholder='your password']")
    WebElement password;
    @FindBy(xpath = "//div[contains(@class,'AdminTitle')]")
    WebElement welTitle;
    @FindBy(xpath = "//*[text()='Application Management']")
    WebElement appMngt;
    @FindBy(xpath = "//span[@class='components__Text-sc-1if6yln-0 bYNJvw']")
    WebElement clickProfile;
    @FindBy(xpath = "//*[text()='Sign Out']")
    WebElement signOut;
    @FindBy(xpath = "//*[text()='Yes']")
    WebElement clickYes;
    @FindBy(xpath = "//*[contains(text(),'remember your password?')]")
    WebElement forgotPswd;
    @FindBy(xpath = "//span[text()='Send email']")
    WebElement sendEmail;
    @FindBy(xpath = "//*[contains(text(),'Wrong')]")
    WebElement invalid_login;
    @FindBy(xpath = "//*[@role='alert']")
    WebElement invalid_email;
    @FindBy(xpath = "//*[contains(text(),'blank')]")
    WebElement error_pswrd;

    public void emailVerification(String email) throws Exception {

        logger = report.startTest("Admin Login Pop up- TC-1823 Email field is required, displayed and functioning");
        log.info("####### Executing  TC-1823 Email field is required, displayed and functioning #######");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.elementToBeClickable(login));
        Thread.sleep(2000);
        login.click();
        Thread.sleep(1000);

        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Admin Login Pop up/TC-1823 loginError.png"));
        emailID.sendKeys(email);
        login.click();
        Thread.sleep(1000);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Admin Login Pop up/TC-1823 emailError.png"));
        try {
            if (invalid_login.getText().contains("Wrong")) {
                log.info("####### TC-1823  'Wrong Email or Password' is displayed  #######");
                logger.log(LogStatus.PASS, "TC-1823 Email field is required, displayed and functioning");
                logger.log(LogStatus.INFO, " 'Wrong Email or Password' is displayed");
            } else if (invalid_email.getText().contains("Invalid")) {
                log.info("####### TC-1823  'Invalid' message is displayed  #######");
                logger.log(LogStatus.PASS, "TC-1823 Email field is required, displayed and functioning");
                logger.log(LogStatus.INFO, "  'Invalid' message is displayed");
            } else {
                log.info("####### TC-1823  'Wrong Email or Password/Invalid' message is not displayed  #######");
                logger.log(LogStatus.FAIL, "TC-1823 Email field is required, displayed and functioning");
                logger.log(LogStatus.INFO, " 'Wrong Email or Password/Invalid' message is not displayed ");
            }
        } catch (Exception e) {
            if (invalid_email.getText().contains("Invalid")) {
                log.info("####### TC-1823  'Invalid' message is displayed  #######");
                logger.log(LogStatus.PASS, "TC-1823 Email field is required, displayed and functioning");
                logger.log(LogStatus.INFO, "  'Invalid' message is displayed");
            } else {
                log.info("####### TC-1823  'Wrong Email or Password/Invalid' message is not displayed  #######");
                logger.log(LogStatus.FAIL, "TC-1823 Email field is required, displayed and functioning");
                logger.log(LogStatus.INFO, " 'Wrong Email or Password/Invalid' message is not displayed ");
            }
        }


    }

    public void passwordVerification(String email, String enterPassword) throws Exception {
        logger = report.startTest("Admin Login Pop up - TC-1829 Password Field is required, displayed and functioning");
        log.info("####### Executing  TC-1829 Password Field is required, displayed and functioning #######");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.elementToBeClickable(emailID));
        emailID.sendKeys(email);
        Thread.sleep(1000);
        password.sendKeys(enterPassword);
        Thread.sleep(2000);
        login.click();
        Thread.sleep(3000);

        snapshot = (TakesScreenshot) driver;
        File screenShot2 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot2, new File(System.getProperty("user.dir") + "/target/ScreenShots/Admin Login Pop up/TC-1829 password.png"));
        Thread.sleep(2000);

        try {
            if (invalid_login.getText().contains("WRONG")) {
                log.info("#######'TC-1829  'Wrong Email or Password' is displayed  #######");
                logger.log(LogStatus.PASS, "TC-1829 Password Field is required, displayed and functioning");
                logger.log(LogStatus.INFO, " 'Wrong Email or Password' is displayed");
            } else if (error_pswrd.getText().contains("blank")) {
                log.info("####### 'TC-1829 'Can't be blank' message is displayed  #######");
                logger.log(LogStatus.PASS, "TC-1829 Password Field is required, displayed and functioning");
                logger.log(LogStatus.INFO, "'Can't be blank' message is displayed");
            } else {
                log.info("####### 'TC-1829 Password field 'Can't be blank' message' is not displayed #######");
                logger.log(LogStatus.FAIL, "TC-1829 Password Field is required, displayed and functioning");
                logger.log(LogStatus.INFO, " Password field 'Can't be blank' message' is not displayed ");
            }
        } catch (RuntimeException e) {
            if (error_pswrd.getText().contains("blank")) {
                log.info("####### 'TC-1829 'Can't be blank' message is displayed  #######");
                logger.log(LogStatus.PASS, "TC-1829 Password Field is required, displayed and functioning");
                logger.log(LogStatus.INFO, "'Can't be blank' message is displayed");
            } else {
                log.info("####### 'TC-1829 Password field 'Can't be blank' message' is not displayed #######");
                logger.log(LogStatus.FAIL, "TC-1829 Password Field is required, displayed and functioning");
                logger.log(LogStatus.INFO, " Password field 'Can't be blank' message' is not displayed ");
            }
        }
    }

    public void loginApplication(String email, String enterPassword) throws Exception {
        logger = report.startTest("Admin Login Pop up- TC-1823 Email field is required, displayed and functioning");
        log.info("####### Executing  TC-1823 Email field is required, displayed and functioning #######");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.elementToBeClickable(emailID));
        emailID.clear();
        emailID.sendKeys(email);

        password.clear();
        password.sendKeys(enterPassword);

        login.click();
        Thread.sleep(5000);
        snapshot = (TakesScreenshot) driver;
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Admin Login Pop up/TC-1837 Admin_Dashboard.png"));
        Thread.sleep(3000);
        if (welTitle.isDisplayed()) {
            String msg = welTitle.getText();
            System.out.println(msg);
            Thread.sleep(500);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", appMngt);
            Thread.sleep(2000);
            log.info(msg + "  ####### TC-1837 The user is authorized correctly #######");
            logger.log(LogStatus.PASS, "TC-1837 Log In CTA is active and functioning and TC-1816 Admin menu is displayed and functioning ");
            logger.log(LogStatus.INFO, "TC-1837 The user is authorized correctly");

        } else {
            log.info("####### 'TC-1837 The user is not authorized correctly or Password field 'Can't be blank/Wrong Email or Password' message is not displayed #######");
            logger.log(LogStatus.FAIL, "TC-1837 Log In CTA is active and functioning and TC-1816 Admin menu is displayed and functioning ");
            logger.log(LogStatus.INFO, "The user is not authorized correctly or Password field 'Can't be blank/Wrong Email or Password' message is not displayed ");
        }
    }

    public void forgotPassword(String email) throws Exception {
        // report = new
        // com.relevantcodes.extentreports.ExtentReports("./target/Reports/recoverPassword.html");
        logger = report.startTest("Admin Login Pop up- TC-1845 'Don't remember your password?' Link is displayed and functioning");
        log.info("####### Executing TC-1845 'Don't remember your password?' Link is displayed and functioning #######");
        driver.get(conpro.getProperty("url"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.elementToBeClickable(forgotPswd));
        forgotPswd.click();

        emailID.sendKeys(email);
        Thread.sleep(1000);
        if (sendEmail.isDisplayed()) {
            sendEmail.click();
            Thread.sleep(3000);

            snapshot = (TakesScreenshot) driver;
            File screenShot2 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot2, new File(System.getProperty("user.dir") + "/target/ScreenShots/TC-1845 ForgotPassword.png"));
            log.info("####### TC-1823  'Don't remember your password?' Link is functioning <--  Send Email button is Clickable #######");
            logger.log(LogStatus.PASS, "TC-1845 'Don't remember your password?' Link is displayed and functioning");
            logger.log(LogStatus.INFO, " 'Don't remember your password?' Link is functioning <--  Send Email button is Clickable");

        } else {
            log.info("####### TC-1823  'Don't remember your password?' Link is not displayed <--  Send Email button is not Clickable #######");
            logger.log(LogStatus.PASS, "TC-1845 'Don't remember your password?' Link is displayed and functioning");
            logger.log(LogStatus.INFO, " 'Don't remember your password?' Link is not displayed <--  Send Email button is not Clickable");
        }

    }

}

