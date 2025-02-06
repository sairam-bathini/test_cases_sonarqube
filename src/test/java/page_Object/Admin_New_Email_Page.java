package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_New_Email_Page extends Admin_BaseClass {
    public Admin_New_Email_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Email Management']")
    WebElement emailMngmt;
    @FindBy(xpath = "//*[text()='New Email']")
    WebElement newEmail;
    @FindBy(xpath = "//*[text()='Custom - Marketing']")
    WebElement templateType;
    @FindBy(xpath = "//*[text()='Add recipients']")
    WebElement addRecipients;
    @FindBy(xpath = "//*[text()='Send']")
    WebElement send;
    @FindBy(xpath = "//*[text()='Select year(s)']")
    WebElement selectYear;
    @FindBy(xpath = "//*[text()='Select championship(s)']")
    WebElement selectchampionship;
    @FindBy(xpath = "(//input[contains(@class,'components__InputStyled')])[2]")
    WebElement searchPlayer;
    @FindBy(xpath = "(//*[@class='Checkbox__Wrapper-sc-1xms6td-0 jibKrv'])[3]")
    WebElement selectPlayer;
    @FindBy(xpath = "//*[text()='OK']")
    WebElement selectOk;
    @FindBy(xpath = "//*[@class='jodit-wysiwyg']")
    WebElement enterBody;
    @FindBy(xpath = "//*[@placeholder='Template subject'][1]")
    WebElement enterTemplate;
    @FindBy(xpath = "//*[text()='Yes']")
    WebElement selectYes;


    public void emailTitleDisplays() throws Throwable {
        logger = report.startTest("TC-1915 Email Title displays ");
        log.info("####### TC-1915 Email Title displays  #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        newEmail.click();
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/New Email Page/TC-1915 Email Title displays.png"));

        if (templateType.isDisplayed()) {
            log.info("####### TC-1915 Email Title displays #######");
            logger.log(LogStatus.PASS, "TC-1915 Email Title displays ");
            logger.log(LogStatus.INFO, "Email Title is displayed as expected ");
        } else {
            log.info("####### TC-1915 Email Title displays #######");
            logger.log(LogStatus.FAIL, "TC-1915 Email Title displays ");
            logger.log(LogStatus.INFO, "Email Title is not displayed as expected");
        }
    }

    public void saveCTADisplays() throws Throwable {
        logger = report.startTest("TC-1911 Send CTA displays ");
        log.info("####### TC-1911 Send CTA displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        newEmail.click();
        selectYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = "2025";
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        selectchampionship.click();
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = "U.S. Senior Open";
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }

        enterTemplate.sendKeys("Test");
        WebElement frameElement = driver.findElement(By.className("jodit-wysiwyg_iframe"));

        driver.switchTo().frame(frameElement);
        Thread.sleep(1000);
        enterBody.sendKeys(" Test Body ");
        driver.switchTo().parentFrame();
        Thread.sleep(1000);

        addRecipients.click();
        searchPlayer.sendKeys("Santosh");
        Thread.sleep(3000);
        selectPlayer.click();
        Thread.sleep(500);
        selectOk.click();
        Thread.sleep(2000);
        send.click();
        Thread.sleep(500);
        selectYes.click();
        snapshot = (TakesScreenshot) driver;
        Thread.sleep(500);
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/New Email Page/TC-1911 Send CTA displays.png"));

        if (templateType.isDisplayed()) {
            log.info("####### TC-1911 Send CTA displays #######");
            logger.log(LogStatus.PASS, "TC-1911 Send CTA displays ");
            logger.log(LogStatus.INFO, "Send CTA displayed working as expected ");
        } else {
            log.info("####### TC-1911 Send CTA displays #######");
            logger.log(LogStatus.FAIL, "TC-1911 Send CTA displays ");
            logger.log(LogStatus.INFO, "Send CTA displayed and not working as expected ");
        }
    }
    public void emailBodyDisplays() throws Throwable {
        logger = report.startTest("TC-1916 Email Body displays ");
        log.info("####### TC-1916 Email Body displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        newEmail.click();
        selectYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = "2025";
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        selectchampionship.click();
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = "U.S. Senior Open";
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }

        enterTemplate.sendKeys("Test");
        WebElement frameElement = driver.findElement(By.className("jodit-wysiwyg_iframe"));

        driver.switchTo().frame(frameElement);
        Thread.sleep(1000);
        enterBody.sendKeys(" Test Body ");
        driver.switchTo().parentFrame();
        Thread.sleep(1000);

        if (templateType.isDisplayed()) {
            log.info("####### TC-1916 Email Body displays #######");
            logger.log(LogStatus.PASS, "TC-1916 Email Body displays ");
            logger.log(LogStatus.INFO, "Email Body is displayed as expected ");
        } else {
            log.info("####### TC-1916 Email Body displays #######");
            logger.log(LogStatus.FAIL, "TC-1916 Email Body displays ");
            logger.log(LogStatus.INFO, "Email Body is displayed and not working expected ");
        }
    }
}
