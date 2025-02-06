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
import java.util.List;

public class Admin_Event_Details_Pairings_Page extends Admin_BaseClass {
    public Admin_Event_Details_Pairings_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Championship Management']")
    WebElement clickChampMngmt;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "//*[text()='Pairings']")
    WebElement pairings;
    @FindBy(xpath = "//*[contains(text(),'Rules')]")
    WebElement rulesRandomizeAll;
    @FindBy(xpath = "//*[contains(text(),'Unpair')]")
    WebElement unpairAll;
    @FindBy(xpath = "//span[text()='Yes']")
    WebElement unpairAllYes;
    @FindBy(xpath = "//span[text()='No']")
    WebElement unpairAllNo;
    @FindBy(xpath = "//span[text()='Save']")
    WebElement save;
    @FindBy(xpath = "//*[text()='Confirm']")
    WebElement confirm;
    @FindBy(xpath = "(//*[@class='components__Th-jca4yq-13 ktKIEi'])[1]")
    WebElement tableArea;
    @FindBy(xpath = "(//*[@class='Checkbox__Wrapper-sc-1xms6td-0 jibKrv'])[3]")
    WebElement checkFirstRow;
    @FindBy(xpath = "(//*[@class='FlatIconicButton__StyledButton-sc-1645q4d-0 dmeLpm'])[1]")
    WebElement add;
    @FindBy(xpath = "(//*[@class='FlatIconicButton__StyledButton-sc-1645q4d-0 dmeLpm'])[3]")
    WebElement unpair;
    @FindBy(xpath = "//span[text()='Export']")
    WebElement export;
    @FindBy(xpath = "//*[contains(text(),'Plain')]")
    WebElement plainRandomize;
    @FindBy(xpath = "(//*[@class='components__Text-sc-1if6yln-0 components__MenuText-sc-1c1gug6-6 biHJtW'])[6]")
    WebElement scrollInto;


    public void rulesRandomiseAllCTAIsDisplayedAndfunctioning(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1865 Rules Randomise All  CTA is displayed and functioning ");
        log.info("####### TC-1865 Rules Randomise All  CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }

        js.executeScript("arguments[0].click();", pairings);
        Thread.sleep(3000);
        rulesRandomizeAll.click();
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1865 Rules Randomise.png"));

        if (rulesRandomizeAll.isDisplayed()) {
            log.info("####### TC-1865 Rules Randomise All CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1865 Rules Randomise All CTA is displayed and functioning ");
            logger.log(LogStatus.INFO, "Rules Randomise All CTA is working as expected");
        } else {
            log.info("####### TC-1865 Rules Randomise All CTA is displayed and functioning  #######");
            logger.log(LogStatus.FAIL, "TC-1865 Rules Randomise All CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Rules Randomise All CTA is not working as expected");
        }
    }

    public void unpairAllCTAIsDisplayedAndfunctioning(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1872 Unpair All CTA is displayed and functioning ");
        log.info("####### TC-1872 Unpair All CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }

        js.executeScript("arguments[0].click();", pairings);
        Thread.sleep(3000);
        rulesRandomizeAll.click();
        unpairAll.click();
        Thread.sleep(1000);
        unpairAllNo.click();
        Thread.sleep(1000);
        unpairAll.click();
        Thread.sleep(1000);
        unpairAllYes.click();
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1872 Unpair All CTA.png"));

        if (unpairAll.isDisplayed()) {
            log.info("####### TC-1872 Unpair All CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1872 Unpair All CTA is displayed and functioning ");
            logger.log(LogStatus.INFO, "Unpair All CTA is working as expected");
        } else {
            log.info("####### TC-1872 Unpair All CTA is displayed and functioning  #######");
            logger.log(LogStatus.FAIL, "TC-1872 Unpair All CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Unpair All CTA is not working as expected");
        }
    }

    public void saveAllCTAIsDisplayedAndfunctioning(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1868 Save CTA is displayed and functioning ");
        log.info("####### TC-1868 Save CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }

        js.executeScript("arguments[0].click();", pairings);
        Thread.sleep(3000);
        save.click();
        confirm.click();
        Thread.sleep(9000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
        wait.until(ExpectedConditions.elementToBeClickable(save));
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1868 Save CTA.png"));
        if (save.isDisplayed()) {
            log.info("####### TC-1868 Save CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1868 Save CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save CTA is working as expected");
        } else {
            log.info("####### TC-1868 Save CTA is displayed and functioning  #######");
            logger.log(LogStatus.FAIL, "TC-1868 Save CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save CTA is not working as expected");
        }
    }

    public void tableAreaIsDisplayed(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1873 Table area is displayed ");
        log.info("####### TC-1873 Table area is displayed #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        js.executeScript("arguments[0].click();", pairings);
        Thread.sleep(3000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1873 Table Area.png"));
        String tableData = tableArea.getText();
        System.out.println(tableData);
        if (tableData.contains("Name")) {
            log.info("####### TC-1873 Table area is displayed #######");
            logger.log(LogStatus.PASS, "TC-1873 Table area is displayed");
            logger.log(LogStatus.INFO, "Table area is displayed as expected");
        } else {
            log.info("####### TC-1873 Table area is displayed  #######");
            logger.log(LogStatus.FAIL, "TC-1873 Table area is displayed");
            logger.log(LogStatus.INFO, "Table area is not displayed as expected");
        }

    }

    public void addCTAIsDisplayed(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1876 Add CTA is displayed and functioning ");
        log.info("####### TC-1876 Add CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        js.executeScript("arguments[0].click();", pairings);
        Thread.sleep(3000);
        snapshot = (TakesScreenshot) driver;
        checkFirstRow.click();
        Thread.sleep(1000);
        add.click();
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1876 Add.png"));
        if (add.isDisplayed()) {
            log.info("####### TC-1876 Add CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1876 Add CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Table area is displayed as expected");
        } else {
            log.info("####### TC-1876 Add CTA is displayed and functioning  #######");
            logger.log(LogStatus.FAIL, "TC-1876 Add CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Table area is not displayed as expected");
        }

    }

    public void unpairCTAIsDisplayed(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1879 Unpair CTA is displayed and functioning");
        log.info("####### TC-1879 Unpair CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        js.executeScript("arguments[0].click();", pairings);
        Thread.sleep(3000);
        if (unpair.isDisplayed()) {
            System.out.println(unpair.getLocation());
            js.executeScript("arguments[0].scrollIntoView(true);", scrollInto);
            Thread.sleep(2000);
            unpair.click();
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1878 Unpair CTA.png"));
            unpairAllNo.click();
            unpair.click();
            unpairAllYes.click();
            log.info("####### TC-1879 Unpair CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1879 Unpair CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Unpair CTA is displayed as expected");
        } else {
            log.info("####### TC-1879 Unpair CTA is displayed and functioning  #######");
            logger.log(LogStatus.FAIL, "TC-1879 Unpair CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Unpair CTA(delete icon) is not displayed ");
        }

    }

    public void exportCTAIsDisplayed(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1881 Export CTA displays and functioning");
        log.info("####### TC-1881 Export CTA displays and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        js.executeScript("arguments[0].click();", pairings);
        Thread.sleep(2000);
        if (export.isDisplayed()) {
            export.click();
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1881 Export CTA.png"));
            log.info("####### TC-1881 Export CTA displays and functioning #######");
            logger.log(LogStatus.PASS, "TC-1881 Export CTA displays and functioning");
            logger.log(LogStatus.INFO, "Save CTA is displayed and working as expected");
        } else {
            log.info("####### TC-1881 Export CTA displays and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1881 Export CTA displays and functioning");
            logger.log(LogStatus.INFO, "Save CTA is not displayed and not working as expected ");
        }

    }

    public void accessToPairingsPage(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1885 Access to Pairings page");
        log.info("####### TC-1885 Access to Pairings page #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        js.executeScript("arguments[0].click();", pairings);
        Thread.sleep(3000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1885 Pairings Page.png"));
        String tableData = tableArea.getText();
        if (tableData.contains("Name")) {
            log.info("####### TC-1885 Access to Pairings page #######");
            logger.log(LogStatus.PASS, "TC-1885 Access to Pairings page");
            logger.log(LogStatus.INFO, "Able to navigate to Pairings page");
        } else {
            log.info("####### TC-1885 Access to Pairings page  #######");
            logger.log(LogStatus.FAIL, "TC-1885 Access to Pairings page");
            logger.log(LogStatus.INFO, "Unable to navigate to Pairings page");
        }

    }

    public void plainRandomiseCTAisDisplayedandfunctioning(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1887 Plain Randomise CTA is displayed and functioning");
        log.info("####### TC-1887 Plain Randomise CTA is displayed and functioning #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        clickYear.click();
        List<WebElement> yearOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String yearVal = year;
        for (WebElement option : yearOptions) {
            if ((option.getText()).equals(yearVal)) {
                option.click();
                break;
            }
        }
        List<WebElement> champOptions = driver.findElements(By.xpath("//div[@class='components__Text-sc-1if6yln-0 hJlldQ']"));
        String champVal = championship;
        for (WebElement option : champOptions) {
            if ((option.getText()).equals(champVal)) {
                option.click();
                break;
            }
        }
        js.executeScript("arguments[0].click();", pairings);
        Thread.sleep(3000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1887 Plain Randomise.png"));
        plainRandomize.click();
        Thread.sleep(1000);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details Pairings/TC-1887 Plain Randomise After Click.png"));
        if (plainRandomize.isDisplayed()) {
            log.info("####### TC-1887 Plain Randomise CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1887 Plain Randomise CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Plain Randomise CTA is displayed and functioning as expected");
        } else {
            log.info("####### TC-1887 Plain Randomise CTA is displayed and functioning  #######");
            logger.log(LogStatus.FAIL, "TC-1887 Plain Randomise CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Plain Randomise CTA is not displayed and not functioning as expected");
        }

    }
}



