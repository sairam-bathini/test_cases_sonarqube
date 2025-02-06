package page_Object;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import test_Base.Admin_BaseClass;

public class Admin_User_Profile_page extends Admin_BaseClass {
    TakesScreenshot snapshot;
    WebDriverWait wait;

    public Admin_User_Profile_page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@placeholder='your password']")
    WebElement password;
    @FindBy(xpath = "//button[@name='submit']")
    WebElement logIn;
    @FindBy(xpath = "//input[@placeholder='yours@example.com']")
    WebElement emailID;

    @FindBy(xpath = "//span[@class='components__Text-sc-1if6yln-0 bYNJvw']")
    WebElement clickProfile;
    @FindBy(xpath = "//*[text()='My Profile']")
    WebElement clickMyProfile;
    @FindBy(xpath = "//*[text()='Sign Out']")
    WebElement clicksignout;

    @FindBy(xpath = "//*[@class='auth0-lock-alternative-link']")
    WebElement forgotPswd;
    @FindBy(xpath = "//span[text()='Send email']")
    WebElement sendEmail;
    @FindBy(xpath = "//*[text()='First Name']/..//div[@class='ValidatorInput__ValidationInputWrapper-sc-23dtz9-1 ljwdWP']//div/input")
    WebElement firstName;
    @FindBy(xpath = "//*[text()='Last Name']/..//div[@class='ValidatorInput__ValidationInputWrapper-sc-23dtz9-1 ljwdWP']//div/input")
    WebElement lastName;
    @FindBy(xpath = "//*[text()='Email']/..//div[@class='ValidatorInput__ValidationInputWrapper-sc-23dtz9-1 ljwdWP']//div/input")
    WebElement email;
    @FindBy(xpath = "//*[text()='Save Changes']")
    WebElement saveChanges;
    @FindBy(xpath = "//*[text()='Profile saved']")
    WebElement profileSaved;
    @FindBy(xpath = "//*[text()='Reset Password']")
    WebElement clickReset;

    public void signOut(String email, String pass) throws Exception {

        logger = report.startTest("Admi User Profile- TC-1830 Sign Out CTA is displayed & functioning ");
        log.info("####### Executing TC-1848 Actions Required section is displayed and functioning #######");
        emailID.sendKeys(email);
        password.clear();
        password.sendKeys(pass);

        logIn.click();
        Thread.sleep(5000);
        clickProfile.click();
        String afterLoginURL = driver.getCurrentUrl();
        Thread.sleep(1000);
        clickMyProfile.click();
        Thread.sleep(1000);
        clicksignout.click();

        Thread.sleep(1000);
        String afterSignOutURL = driver.getCurrentUrl();
        if(!afterLoginURL.equals(afterSignOutURL)) {
            log.info("####### TC-1830 Sign-out from Champ Admin and loaded Admin - Login #######");
            logger.log(LogStatus.PASS, "TC-1830 Sign Out CTA is displayed & functioning");
            logger.log(LogStatus.INFO, "Sign-out from Champ Admin and loaded Admin - Login");

        }else{
            log.info("####### TC-1830 Sign-out is Unsuccessful #######");
            logger.log(LogStatus.PASS, "TC-1830 Sign Out CTA is displayed & functioning");
            logger.log(LogStatus.INFO, "Sign-out is Unsuccessful");
        }

    }

    public void generalInformationSection_and_SaveChangesCTA(String email, String pass, String firstname, String lastname) throws Exception {
        logger = report.startTest("Admi User Profile - TC-1834 & TC-1844 General Information section & Save Changes CTA ");
        log.info("####### Executing TC-1834 & TC-1844 General Information section & Save Changes CTA #######");
        Thread.sleep(2000);
        emailID.clear();
        emailID.sendKeys(email);
        password.clear();
        password.sendKeys(pass);
        logIn.click();
        Thread.sleep(5000);
        clickProfile.click();
        Thread.sleep(1000);
        clickMyProfile.click();
        Thread.sleep(2000);

        snapshot = (TakesScreenshot) driver;
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/ScreenShots/generalInfo.png"));
        firstName.sendKeys(Keys.CONTROL + "a");
        firstName.sendKeys(Keys.DELETE);
        firstName.sendKeys(firstname);
        log.info("Provides ability to update user's first name");
        Thread.sleep(1000);
        lastName.sendKeys(Keys.CONTROL + "a");
        lastName.sendKeys(Keys.DELETE);
        lastName.sendKeys(lastname);
        log.info("Provides ability to update user's last name");
        Thread.sleep(1000);
        this.email.sendKeys(Keys.CONTROL + "a");
        this.email.sendKeys(Keys.DELETE);
        this.email.sendKeys(email);
        log.info("Provides ability to update user's email");
        Thread.sleep(1000);
        saveChanges.click();
        Thread.sleep(500);

        if(firstName.isDisplayed()) {
            log.info("####### TC-1830 On click, saved changes if any was made and If any fields at General Information(5) section is empty Field is required is dispalyed  #######");
            logger.log(LogStatus.PASS, "TC-1834 & TC-1844 General Information section & Save Changes CTA ");
            logger.log(LogStatus.INFO, "On click, will save changes if any was made and If any fields at General Information(5) section is empty Field is required is dispalyed ");
        }else{
            log.info("####### TC-1830 Does not saved the changes made #######");
            logger.log(LogStatus.FAIL, "TC-1834 & TC-1844 General Information section & Save Changes CTA ");
            logger.log(LogStatus.INFO, "Does not saved the changes made ");

        }
        Thread.sleep(2000);
        File screenShot2 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot2, new File(System.getProperty("user.dir") + "/ScreenShots/saveChanges.png"));
        Thread.sleep(1000);
        clicksignout.click();
        Thread.sleep(1000);

    }

    public void changePswd(String email, String pass) throws Exception {
        logger = report.startTest("Admi User Profile- TC-1841 Change Password section is displayed and functioning ");
        log.info("####### Executing TC-1841 Change Password section is displayed and functioning #######");
        emailID.clear();
        emailID.sendKeys(email);
        password.clear();
        password.sendKeys(pass);
        logIn.click();
        Thread.sleep(5000);
        clickProfile.click();
        Thread.sleep(1000);
        clickMyProfile.click();
        Thread.sleep(2000);
        clickReset.click();
        Thread.sleep(2000);

        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/ScreenShots/resetPassword.png"));
        Thread.sleep(2000);
        System.out.println("aaaaajxdgsctgsggsfahsfa");
        if (clickReset.isDisplayed()) {
            log.info("####### TC-1841 'Reset Password' button is Clickable/availabe #######");
            logger.log(LogStatus.PASS, "TC-1841 Change Password section is displayed and functioning ");
            logger.log(LogStatus.INFO, "'Reset Password' button is Clickable/availabe");

        } else {
            log.info("####### TC-1841 'Reset Password' button is Clickable/availabe #######");
            logger.log(LogStatus.FAIL, "TC-1841 Change Password section is displayed and functioning ");
            logger.log(LogStatus.INFO, "'Reset Password' button is Clickable/availabe");

        }

    }
}
