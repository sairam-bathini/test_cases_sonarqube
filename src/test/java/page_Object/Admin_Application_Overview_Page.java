package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Application_Overview_Page extends Admin_BaseClass {
    WebDriverWait wait;

    public Admin_Application_Overview_Page(WebDriver driver) {
        this.driver = driver;
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    @FindBy(xpath = "//div[text()='Application Management']")
    WebElement clickAppMngmt;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "//div[text()='Select a Championship']")
    WebElement clickChampionship;
    @FindBy(xpath = "//input[@class='components__InputStyled-sc-78cfz3-1 juWmLe Searchbar__Input-co7tvo-1 GUUaa']")
    WebElement searchFiled;
    @FindBy(xpath = "(//div[@class='components__Text-sc-1if6yln-0 gbuFAn'])[1]")
    WebElement clickPlayer;
    @FindBy(xpath = "//span[text()='Save']")
    WebElement clickSave;
    @FindBy(xpath = "//div[text()='Note']/following:: input[@class='components__InputStyled-sc-78cfz3-1 juWmLe']")
    WebElement note;
    @FindBy(xpath = "//div[text()='Select From List']")
    WebElement receivedBy;
    @FindBy(xpath = "(//*[@id='Material_x2F_Light_x2F_Checkbox-off'])[3]")
    WebElement emailNotification;
    @FindBy(xpath = "//*[text()='Payment information']")
    WebElement paymentInfo;
    @FindBy(xpath = "(//*[@class='Accordion__ContentWrapper-sc-12syp6h-1 fKVkJj'])[2]")
    WebElement paymentArea;
    @FindBy(xpath = "//div[text()='Qualifying/Exemption status']")
    WebElement qualifyingExceptionStatus;
    @FindBy(xpath = " //div[text()='Exemptions']/following::div[@class=' css-222a9d'][1]")
    WebElement clickException;
    @FindBy(xpath = " //div[text()='Exemptions']/following::div[@class=' css-222a9d'][2]")
    WebElement clickQualifyingSite;
    @FindBy(xpath = " //div[text()='Exemptions']/following::div[@class=' css-222a9d'][3]")
    WebElement clickQualifyingStatus;


    public void appHighLevelInfo(String year, String championship, String playerData) throws Throwable {
        logger = report.startTest("TC-1849 Application High Level Info is displayed");
        log.info("####### Executing TC-1849 Application High Level Info #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickAppMngmt);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(5000);
        clickChampionship.click();
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);

        searchFiled.sendKeys(playerData);

        List<WebElement> value = driver.findElements(By.xpath("//*[@class='Icon__CheckboxUncheckedIcon-sc-1b8stld-5 dJEkSc']"));
        Thread.sleep(2000);
        if (value.size() > 2) {
            clickPlayer.click();
            WebElement data = driver.findElement(By.xpath("//div[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 dtnAIB']"));
            System.out.println(data.getText());
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Overview/TC-1849 ApplicationHighData.png"));
            log.info("####### TC-1849 Application High Level Info is displayed #######");
            logger.log(LogStatus.PASS, "TC-1849 Application High Level Info is displayed");
            logger.log(LogStatus.INFO, "Able to see the Application High Level Info");
        } else {
            System.out.println(driver.findElement(By.xpath("//*[text()='No items to display']")).getText());
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Overview/TC-1849 SearchDataFail.png"));
            log.info("####### TC-1849 Application High Level Info is displayed #######");
            logger.log(LogStatus.FAIL, "TC-1849 Application High Level Info is displayed");
            logger.log(LogStatus.INFO, "Application High Level Info is not displayed");
        }


    }

    public void save(String year, String championship, String playerData) throws Throwable {
        logger = report.startTest("TC-1843 Save Changes CTA is displayed and functioning");
        log.info("####### Executing TC-1843 Save Changes CTA #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickAppMngmt);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(5000);
        clickChampionship.click();
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
        searchFiled.sendKeys(playerData);
        List<WebElement> value = driver.findElements(By.xpath("//*[@class='Icon__CheckboxUncheckedIcon-sc-1b8stld-5 dJEkSc']"));
        Thread.sleep(2000);
        if (value.size() > 2) {
            clickPlayer.click();
            clickSave.click();
            Thread.sleep(1000);

            receivedBy.click();
            List<WebElement> Option2 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String value3 = "Incoming Call";
            for (WebElement option : Option2) {
                if ((option.getText()).equals(value3)) {
                    option.click();
                    break;
                }
            }
            note.sendKeys("Test");
            if (!emailNotification.isSelected()) {
                clickSave.click();
            } else {
                emailNotification.click();
                clickSave.click();
            }
            Thread.sleep(3000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Overview/Tc-1843 SaveCTA.png"));
            log.info("####### TC-1843 Save Changes CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1843 Save Changes CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save Changes CTA is functioning");
        } else {
            System.out.println(driver.findElement(By.xpath("//*[text()='No items to display']")).getText());
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Overview/TC-1843 SearchDataFail.png"));
            log.info("####### TC-1843 Save Changes CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1843 Save Changes CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save Changes CTA is not functioning");
        }


    }

    public void paymentInfoArea(String year, String championship, String playerData) throws Throwable {
        logger = report.startTest("TC-1882 Payment Info Area is displayed and functioning");
        log.info("####### Executing TC-1882 Payment Info Area #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickAppMngmt);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(5000);
        clickChampionship.click();
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
        searchFiled.sendKeys(playerData);
        List<WebElement> value = driver.findElements(By.xpath("//*[@class='Icon__CheckboxUncheckedIcon-sc-1b8stld-5 dJEkSc']"));
        Thread.sleep(2000);
        if (value.size() > 2) {
            clickPlayer.click();
            Thread.sleep(1000);
            js.executeScript("arguments[0].scrollIntoView(true);", paymentInfo);
            Thread.sleep(500);
            System.out.println(paymentArea.getText());
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Overview/TC-1882 Payment Info.png"));
            log.info("####### TC-1843 Save Changes CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1843 Save Changes CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save Changes CTA is functioning");
        } else {
            System.out.println(driver.findElement(By.xpath("//*[text()='No items to display']")).getText());
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Overview/TC-1882 Payment InfoFail.png"));
            log.info("####### TC-1843 Save Changes CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1843 Save Changes CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save Changes CTA is not functioning");
        }


    }

    public void qualifyingExceptionArea(String year, String championship, String playerData, String exceptions, String qSite, String qStatus) throws Throwable {
        logger = report.startTest("TC-3037 Qualifying/Exemption Status Area is displayed and functioning");
        log.info("####### Executing TC-3037 Qualifying/Exemption Status Area #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickAppMngmt);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(5000);
        clickChampionship.click();
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
        searchFiled.sendKeys(playerData);
        List<WebElement> value = driver.findElements(By.xpath("//*[@class='Icon__CheckboxUncheckedIcon-sc-1b8stld-5 dJEkSc']"));
        Thread.sleep(2000);
        if (value.size() > 2) {
            clickPlayer.click();
            Thread.sleep(1000);
            js.executeScript("arguments[0].scrollIntoView(true);", qualifyingExceptionStatus);
            Thread.sleep(500);

            clickException.click();
            List<WebElement> excemptionOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String val = exceptions;
            for (WebElement option : excemptionOptions) {
                if ((option.getText()).equals(val)) {
                    option.click();
                    break;
                }
            }
            clickQualifyingSite.click();
            List<WebElement> qSiteOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String val1 = qSite;
            for (WebElement option : qSiteOptions) {
                if ((option.getText()).equals(val1)) {
                    option.click();
                    break;
                }
            }
            clickQualifyingStatus.click();
            List<WebElement> qStatusOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String val2 = qStatus;
            for (WebElement option : qStatusOptions) {
                if ((option.getText()).equals(val2)) {
                    option.click();
                    break;
                }
            }
            Thread.sleep(3000);

            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Overview/TC-3037 Qualifying Status.png"));
            clickSave.click();
            Thread.sleep(1000);

            receivedBy.click();
            List<WebElement> Option2 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
            String value3 = "Incoming Call";
            for (WebElement option : Option2) {
                if ((option.getText()).equals(value3)) {
                    option.click();
                    break;
                }
            }
            note.sendKeys("Test");
            if (!emailNotification.isSelected()) {
                clickSave.click();
            } else {
                emailNotification.click();
                clickSave.click();
            }
            log.info("####### TC-3037 Qualifying/Exemption Status Area is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-3037 Qualifying/Exemption Status Area is displayed and functioning");
            logger.log(LogStatus.INFO, "Qualifying/Exemption Status Area is displayed and functioning");
        } else {
            System.out.println(driver.findElement(By.xpath("//*[text()='No items to display']")).getText());
            Thread.sleep(1000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Application Overview/TC-3037 Payment InfoFail.png"));
            log.info("####### TC-1843 Save Changes CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1843 Save Changes CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save Changes CTA is not functioning");
        }


    }


}
