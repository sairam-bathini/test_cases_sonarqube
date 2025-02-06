package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;

public class Admin_Template_List_Page extends Admin_BaseClass {
    public Admin_Template_List_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Email Management']")
    WebElement emailMngmt;
    @FindBy(xpath = "//*[text()='Manage Email Templates']")
    WebElement emailTemplate;
    @FindBy(xpath = "(//*[@class='FlatIconicButton__StyledButton-sc-1645q4d-0 dmeLpm'])[1]")
    WebElement addTemplate;
    @FindBy(xpath = "//*[text()='Email Template Management']")
    WebElement templateType;
    @FindBy(xpath = "//*[text()='Custom - Marketing']")
    WebElement templateMgmt;
    @FindBy(xpath = "//*[@placeholder='Title'][1]")
    WebElement title;
    @FindBy(xpath = "//*[@placeholder='Template subject'][1]")
    WebElement enterTemplate;
    @FindBy(xpath = "//*[@class='jodit-wysiwyg']")
    WebElement enterBody;
    @FindBy(xpath = "//*[text()='Create template']")
    WebElement createTemplate;
    @FindBy(xpath = "//*[contains(@class,'components__InputStyled')]")
    WebElement searchEmail;
    @FindBy(xpath = "(//*[@class='Icon__CheckboxUncheckedIcon-sc-1b8stld-5 dJEkSc'])[3]")
    WebElement selectEmail;
    @FindBy(xpath = "//*[text()='Save template']")
    WebElement saveTemplate;
    @FindBy(xpath = "(//*[@class='FlatIconicButton__StyledButton-sc-1645q4d-0 dmeLpm'])[2]")
    WebElement editTemplate;
    @FindBy(xpath = "(//*[@class='FlatIconicButton__StyledButton-sc-1645q4d-0 dmeLpm'])[3]")
    WebElement deleteTemplate;
    @FindBy(xpath = "//*[text()='Yes']")
    WebElement yes;

    public void newCTADisplayedAndFunctioning() throws Throwable {
        logger = report.startTest("TC-1922 New CTA is displayed and functioning ");
        log.info("####### TC-1922 New CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        emailTemplate.click();
        Thread.sleep(1000);
        addTemplate.click();
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Template List/TC-1922 New CTA displays.png"));

        if (templateMgmt.isDisplayed()) {
            log.info("####### TC-1922 New CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1922 New CTA is displayed and functioning ");
            logger.log(LogStatus.INFO, "New CTA is displayed and functioning as expected ");
        } else {
            log.info("####### TC-1922 New CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1922 New CTA is displayed and functioning ");
            logger.log(LogStatus.INFO, "New CTA is displayed and not working functioning as expected ");
        }
    }

    public void templatesListdisplayedAndFunctioning()throws Throwable {
        logger = report.startTest("TC-1892 Templates List is displayed and functioning ");
        log.info("####### TC-1892 Templates List is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        emailTemplate.click();
        Thread.sleep(1000);
        addTemplate.click();
        Thread.sleep(1000);

        title.sendKeys("Test");
        enterTemplate.sendKeys("Test");
        WebElement frameElement = driver.findElement(By.className("jodit-wysiwyg_iframe"));
        driver.switchTo().frame(frameElement);
        Thread.sleep(1000);
        enterBody.sendKeys(" Test Body ");
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        createTemplate.click();
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Template List/TC-1892 Create template.png"));
        log.info("####### TC-1892 Create Template is working as expected #######");

        searchEmail.sendKeys("Test");
        selectEmail.click();
        Thread.sleep(2000);
        editTemplate.click();

        frameElement = driver.findElement(By.className("jodit-wysiwyg_iframe"));
        driver.switchTo().frame(frameElement);
        Thread.sleep(1000);
        enterBody.sendKeys(" Test Body Update");
        driver.switchTo().parentFrame();
        Thread.sleep(1000);
        saveTemplate.click();
        Thread.sleep(2000);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Template List/TC-1892 Save template.png"));
        log.info("####### Save Template is working as expected #######");

        selectEmail.click();
        Thread.sleep(1000);
        deleteTemplate.click();
        yes.click();
        Thread.sleep(2000);
        File screenShot2 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot2, new File(System.getProperty("user.dir") + "/target/ScreenShots/Template List/TC-1892 Delete template.png"));
        log.info("####### TC-1892 Delete template is working as expected #######");

        if (templateType.isDisplayed()) {
            log.info("####### TC-1892 Templates List is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1892 Templates List is displayed and functioning ");
        } else {
            log.info("####### TC-1892 Templates List is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1892 Templates List is displayed and functioning ");
            logger.log(LogStatus.INFO, "Unable to view, create, update, and remove email templates");
        }
    }
    }
