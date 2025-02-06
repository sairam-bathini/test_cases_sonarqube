package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;

public class Admin_Bulk_Emails_To_Clubs_Page extends Admin_BaseClass {
    public Admin_Bulk_Emails_To_Clubs_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Email Management']")
    WebElement emailMngmt;
    @FindBy(xpath = "//*[text()='Bulk Emails To Clubs']")
    WebElement bulkEmailsToClubs;
    @FindBy(xpath = "(//*[@class=' css-1hwfws3'])[2]")
    WebElement selectChampionship;
    @FindBy(xpath = "//div[contains(@id,'react-select')][2]")
    WebElement selectFirst;
    @FindBy(xpath = "//*[@class='components__Th-jca4yq-13 ktKIEi']")
    WebElement tableData;
    @FindBy(xpath = "//*[text()='–Select template–']")
    WebElement selectTemplate;
    @FindBy(xpath = "//*[text()='Template']")
    WebElement template;
    @FindBy(xpath = "//div[contains(@id,'react-select')]")
    WebElement clickTemplate;
    @FindBy(xpath = "//*[contains(text(),'Selected Recipients')]")
    WebElement sendToSelectedRecipients;
    @FindBy(xpath = "(//*[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 brzuDz'])[1]")
    WebElement selectClubs;
    @FindBy(xpath = "//*[text()='Yes']")
    WebElement clickYes;
    @FindBy(xpath = "//*[text()='No']")
    WebElement clickNo;


    public void tableAreaDisplays() throws Throwable {
        logger = report.startTest("TC-1897 Table Area displays ");
        log.info("####### TC-1897 Table Area displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        bulkEmailsToClubs.click();
        Thread.sleep(1000);

        selectChampionship.click();
        Thread.sleep(2000);
        selectFirst.click();
        Thread.sleep(2000);

        System.out.println(tableData.getText());
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Bulk Emails Clubs Page/TC-1897 Table Area Display.png"));

        if (bulkEmailsToClubs.isDisplayed()) {
            log.info("####### TC-1897 Table Area displays #######");
            logger.log(LogStatus.PASS, "TC-1897 Table Area displays ");
            logger.log(LogStatus.INFO, "Table Area is displayed as expected ");
        } else {
            log.info("####### TC-1897 Table Area displays #######");
            logger.log(LogStatus.FAIL, "TC-1897 Table Area displays ");
            logger.log(LogStatus.INFO, "Table Area is not displayed as expected ");
        }
    }

    public void templateSelectiondisplays() throws Throwable {
        logger = report.startTest("TC-1900 Template Selection displays ");
        log.info("####### TC-1900 Template Selection displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        bulkEmailsToClubs.click();
        Thread.sleep(1000);
        selectTemplate.click();
        Thread.sleep(1000);
        clickTemplate.click();

        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Bulk Emails Clubs Page/TC-1897 Template Selection Display.png"));

        if (template.isDisplayed()) {
            log.info("####### TC-1900 Template Selection displays #######");
            logger.log(LogStatus.PASS, "TC-1900 Template Selection displays ");
            logger.log(LogStatus.INFO, "Template Selection is displayed as expected ");
        } else {
            log.info("####### TC-1900 Template Selection displays #######");
            logger.log(LogStatus.FAIL, "TC-1900 Template Selection displays ");
            logger.log(LogStatus.INFO, "Template Selection is not displayed as expected ");
        }

    }
    public void tableSendCTADisplays() throws Throwable {
        logger = report.startTest("TC-1894 Table Send CTA displays ");
        log.info("####### TC-1894 Table Send CTA displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMngmt);
        bulkEmailsToClubs.click();
        Thread.sleep(1000);
        selectTemplate.click();
        Thread.sleep(1000);
        clickTemplate.click();
        selectClubs.click();
        sendToSelectedRecipients.click();
        Thread.sleep(500);
        clickNo.click();

        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Bulk Emails Clubs Page/TC-1897 Template Selection Display.png"));

        if (sendToSelectedRecipients.isDisplayed()) {
            log.info("####### TC-1894 Table Send CTA displays #######");
            logger.log(LogStatus.PASS, "TC-1894 Table Send CTA displays ");
            logger.log(LogStatus.INFO, "Send CTA is displayed and functioning as expected ");
        } else {
            log.info("####### TC-1894 Table Send CTA displays #######");
            logger.log(LogStatus.FAIL, "TC-1894 Table Send CTA displays ");
            logger.log(LogStatus.INFO, "Send CTA is displayed and not functioning as expected ");
        }

    }
}
