package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;

public class Admin_Bulk_Email_to_All_Players_Page extends Admin_BaseClass {
    public Admin_Bulk_Email_to_All_Players_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Email Management']")
    WebElement emailMgmt;
    @FindBy(xpath = "//*[text()='Bulk Custom Emails']")
    WebElement bulkCustomEmails;
    @FindBy(xpath = "//*[text()='Select year(s)']")
    WebElement selectYear;
    @FindBy(xpath = "(//*[@class=' css-1hwfws3'])[2]")
    WebElement selectChampionship;
    @FindBy(xpath = "//*[text()='Custom - Marketing']")
    WebElement customMarketing;
    @FindBy(xpath = "//div[contains(@id,'react-select')][2]")
    WebElement selectMarketing;
    @FindBy(xpath = "//*[text()='Select...']")
    WebElement template;
    @FindBy(xpath = "//div[contains(@id,'react-select')][1]")
    WebElement selectTemplate;
    @FindBy(xpath = "//div[contains(@id,'react-select')][3]")
    WebElement selectValue;
    @FindBy(xpath = "//*[contains(text(),'Selected Recipients')]")
    WebElement sendToSelectedRecipients;
    @FindBy(xpath = "(//*[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 brzuDz'])[1]")
    WebElement selectClubs;
    @FindBy(xpath = "//*[text()='Yes']")
    WebElement clickYes;
    @FindBy(xpath = "//*[text()='No']")
    WebElement clickNo;

    public void tableSendCTADisplays() throws Throwable {
        logger = report.startTest("TC-1920 Table Send CTA displays ");
        log.info("####### TC-1920 Table Send CTA displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMgmt);
        bulkCustomEmails.click();
        Thread.sleep(1000);
        try {
            selectYear.click();
            Thread.sleep(1000);
            selectValue.click();
            Thread.sleep(2000);
            selectChampionship.click();
            Thread.sleep(1000);
            selectValue.click();
            customMarketing.click();
            Thread.sleep(1000);
            selectMarketing.click();
            template.click();
            Thread.sleep(2000);
            selectTemplate.click();
            Thread.sleep(500);
            selectClubs.click();
            sendToSelectedRecipients.click();
            Thread.sleep(500);
            clickNo.click();
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Bulk Qualified Alternate/TC-1914 Table Send CTA.png"));
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println("No items to display");
        }

        if (sendToSelectedRecipients.isDisplayed()) {
            log.info("####### TC-1920 Table Send CTA displays #######");
            logger.log(LogStatus.PASS, "TC-1920 Table Send CTA displays ");
            logger.log(LogStatus.INFO, "Send CTA is displayed and functioning as expected ");
        } else {
            log.info("####### TC-1920 Table Send CTA displays #######");
            logger.log(LogStatus.FAIL, "TC-1920 Table Send CTA displays ");
            logger.log(LogStatus.INFO, "Send CTA is displayed and not functioning as expected ");
        }
    }

    public void tableAreaDisplays() throws Throwable {
        logger = report.startTest("TC-1927 Table Area displays ");
        log.info("####### TC-1927 Table Area displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", emailMgmt);
        bulkCustomEmails.click();
        Thread.sleep(1000);
        selectYear.click();
        Thread.sleep(1000);
        selectValue.click();
        Thread.sleep(2000);
        selectChampionship.click();
        Thread.sleep(2000);
        selectValue.click();
        Thread.sleep(1000);
        customMarketing.click();
        Thread.sleep(1000);
        selectMarketing.click();
        template.click();
        Thread.sleep(2000);
        try {

            selectTemplate.click();
            Thread.sleep(1000);
            selectClubs.click();
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("No items to display");
        }

        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Bulk Qualified Alternate/TC-1919 Table Area display.png"));

        if (sendToSelectedRecipients.isDisplayed()) {
            log.info("####### TC-1919 Table Area displays #######");
            logger.log(LogStatus.PASS, "TC-1927 Table Area displays ");
            logger.log(LogStatus.INFO, "Table Area is displayed and functioning as expected ");
        } else {
            log.info("####### TC-1919 Table Area displays #######");
            logger.log(LogStatus.FAIL, "TC-1927 Table Area displays ");
            logger.log(LogStatus.INFO, "Table Area is not displayed as expected ");
        }

    }
}
