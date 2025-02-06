package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Event_Details_RedBook_View_Page extends Admin_BaseClass {
    public Admin_Event_Details_RedBook_View_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Championship Management']")
    WebElement clickChampMngmt;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "(//div[text()='Championship Management'])[2]")
    WebElement champMngmt;
    @FindBy(xpath = "//span[text()='Manage Redbook Report']")
    WebElement redbook;
    @FindBy(xpath = "//*[@class='FlexWrapper__StyledFlexWrapper-jk1687-0 efZzJp']")
    WebElement redbookHeaders;
    @FindBy(xpath = "(//*[@class='components__Text-sc-1if6yln-0 cGmDty'])[1]")
    WebElement rank;
    @FindBy(xpath = "//*[text()='Choose the rank to swap with']/following :: div[@class=' css-1uccc91-singleValue'][1]")
    WebElement selectRank;
    @FindBy(xpath = "//span[text()='Save']")
    WebElement save;


    public void listOfQualifyingSitesDisplays(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1929 List of qualifying sites will display with qualified players, Alternate 1 and Alternate 2 related to the qualifying sites");
        log.info("####### TC-1929 List of qualifying sites will display with qualified players, Alternate 1 and Alternate 2 related to the qualifying sites #######");
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
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", champMngmt);
        Thread.sleep(1000);
        redbook.click();
        Thread.sleep(2000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details RedBook/TC-1929 List of Qualifying Sites.png"));
        String columnName = redbookHeaders.getText();
        System.out.println(columnName);
        if (columnName.contains("Rank")) {
            log.info("####### TC-1929 List of qualifying sites will display with qualified players, Alternate 1 and Alternate 2 related to the qualifying sites #######");
            logger.log(LogStatus.PASS, "TC-1929 List of qualifying sites will display with qualified players, Alternate 1 and Alternate 2 related to the qualifying sites");
            logger.log(LogStatus.INFO, "List of qualifying sites are displayed with qualified players, Alternate 1 and Alternate 2 related to the qualifying sites");
        } else {
            log.info("####### TC-1929 List of qualifying sites will display with qualified players, Alternate 1 and Alternate 2 related to the qualifying sites #######");
            logger.log(LogStatus.FAIL, "TC-1929 List of qualifying sites will display with qualified players, Alternate 1 and Alternate 2 related to the qualifying sites");
            logger.log(LogStatus.INFO, "List of qualifying sites are not displayed with qualified players, Alternate 1 and Alternate 2 related to the qualifying sites");
        }

    }

    public void rankListItemIsDisplayedFunctioning(String year, String championship, String rank1) throws Throwable {
        logger = report.startTest("TC-1935 Rank list item is displayed and functioning");
        log.info("####### TC-1935 Rank list item is displayed and functioning #######");
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
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", champMngmt);
        Thread.sleep(1000);
        redbook.click();
        Thread.sleep(2000);
        snapshot = (TakesScreenshot) driver;
        rank.click();
        selectRank.click();
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details RedBook/TC-1935 Rank List.png"));
        List<WebElement> rankOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String rankVal = rank1;
        for (WebElement option : rankOptions) {
            if ((option.getText()).equals(rankVal)) {
                option.click();
                break;
            }
        }
        if (rank.isDisplayed()) {
            log.info("####### TC-1935 Rank list item is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1935 Rank list item is displayed and functioning");
            logger.log(LogStatus.INFO, "Rank list item is displayed and able to update the rank value");
        } else {
            log.info("####### TC-1935 Rank list item is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TC-1935 Rank list item is displayed and functioning");
            logger.log(LogStatus.INFO, "Rank list item is displayed and not able to update the rank value");
        }

    }

    public void saveCTAIsDisplayedFunctioning(String year, String championship, String rank1) throws Throwable {
        logger = report.startTest("TC-1940 Save CTA is displayed and functioning");
        log.info("####### TC-1940 Save CTA is displayed and functioning #######");
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
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", champMngmt);
        Thread.sleep(1000);
        redbook.click();
        Thread.sleep(2000);
        snapshot = (TakesScreenshot) driver;
        rank.click();
        selectRank.click();
        List<WebElement> rankOptions = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        String rankVal = rank1;
        for (WebElement option : rankOptions) {
            if ((option.getText()).equals(rankVal)) {
                option.click();
                break;
            }
        }
        Thread.sleep(1000);
        save.click();
        Thread.sleep(1000);
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1940 Save CTA.png"));

        if (save.isDisplayed()) {
            log.info("####### TC-1940 Save CTA is displayed and functioning #######");
            logger.log(LogStatus.PASS, "TC-1940 Save CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save CTA is displayed and able to update the rank value and save it");
        } else {
            log.info("####### TC-1940 Save CTA is displayed and functioning #######");
            logger.log(LogStatus.FAIL, "TTC-1940 Save CTA is displayed and functioning");
            logger.log(LogStatus.INFO, "Save CTA is not functioning as expected");
        }

    }

    public void qualifierInformation(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1940 Qualifier Information Table: Column Header and Rows are displayed");
        log.info("####### TC-1940 Qualifier Information Table: Column Header and Rows are displayed #######");
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
        Thread.sleep(1000);
        js.executeScript("arguments[0].scrollIntoView(true);", champMngmt);
        Thread.sleep(1000);
        redbook.click();
        Thread.sleep(2000);
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Event Details/TC-1940 Save CTA.png"));
        String columnName = redbookHeaders.getText();
        System.out.println(columnName);
        if (columnName.contains("Name")) {
            log.info("####### TC-1940 Qualifier Information Table: Column Header and Rows are displayed #######");
            logger.log(LogStatus.PASS, "TC-1940 Qualifier Information Table: Column Header and Rows are displayed");
            logger.log(LogStatus.INFO, "Qualifier Information data is displayed as expected");
        } else {
            log.info("####### TC-1940 Qualifier Information Table: Column Header and Rows are displayed #######");
            logger.log(LogStatus.FAIL, "TC-1940 Qualifier Information Table: Column Header and Rows are displayed");
            logger.log(LogStatus.INFO, "Qualifier Information data is not displayed as expected");
        }

    }

}
