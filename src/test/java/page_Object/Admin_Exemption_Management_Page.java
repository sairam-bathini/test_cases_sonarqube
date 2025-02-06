package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;

public class Admin_Exemption_Management_Page extends Admin_BaseClass {
    public Admin_Exemption_Management_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Exemptions Management']")
    WebElement exemptionMgmt;
    @FindBy(xpath = "//*[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 khfHEh components__MainBar-sc-5xr1xw-1 GHrIO']")
    WebElement tableData;

    public void tableSendCTADisplays() throws Throwable {
        logger = report.startTest("TC-2984 Exemptions table is displayed ");
        log.info("####### TC-2984 Exemptions table is displayed  #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", exemptionMgmt);
        Thread.sleep(1000);



        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Exemptions Management/TC-2984 Exemptions Table.png"));
        Thread.sleep(1000);


        if (sendToSelectedRecipients.isDisplayed()) {
            log.info("####### TC-1914 Table Send CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1914 Table Send CTA is displayed and functioning ");
            logger.log(LogStatus.INFO, "Send CTA is displayed and functioning as expected ");
        } else {
            log.info("####### TC-1914 Table Send CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1914 Table Send CTA is displayed and functioning ");
            logger.log(LogStatus.INFO, "Send CTA is displayed and not functioning as expected ");
        }
    }

}
