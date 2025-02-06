package page_Object;

import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Players_Eligible_for_Late_Applications_Page extends Admin_BaseClass {
    public Admin_Players_Eligible_for_Late_Applications_Page(WebDriver driver) {
        this.driver = driver;
    }

    Actions actions = new Actions(driver);
    @FindBy(xpath = "//div[text()='Championship Management']")
    WebElement clickChampMngmt;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "//div[text()='Players Eligible to Apply After the Close of Entries']")
    WebElement applyCloseOfEntries;
    @FindBy(xpath = "//*[contains(text(),'Players Eligible to')]/following::button[@class='FlatIconicButton__StyledButton-sc-1645q4d-0 dmeLpm'][1]")
    WebElement addEntry;
    @FindBy(xpath = " //*[@class=' css-1n7v3ny-option']")
    WebElement playerClick;
    @FindBy(xpath = "//*[contains(text(),'Players Eligible to')]/following::button[@class='FlatIconicButton__StyledButton-sc-1645q4d-0 dmeLpm'][2]")
    WebElement delEntry;
    @FindBy(xpath = "//div[text()='Search for a player']")
    WebElement playerSearch;
    @FindBy(xpath = "//*[text()='OK']")
    WebElement clickOk;
    @FindBy(xpath = "//*[contains(text(),'Players Eligible to')]/following::*[@class='Icon__CheckboxUncheckedIcon-sc-1b8stld-5 dJEkSc'][2]")
    WebElement selectPlayer;
    @FindBy(xpath = "//*[text()='Are you sure you want to remove the selected player(s)?']/following::*[text()='Yes']")
    WebElement clickYes;
    public void general(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1886 General");
        log.info("####### TC-1886 General #######");
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

        js.executeScript("arguments[0].scrollIntoView(true);", applyCloseOfEntries);
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", applyCloseOfEntries);
        Thread.sleep(2000);
        addEntry.click();
        Thread.sleep(1000);
        snapshot = (TakesScreenshot) driver;
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/ChampAdmin Players Eligible Late Applications/TC-1886 General.png"));
        if (playerSearch.isDisplayed()) {
            log.info("####### TC-1886 General #######");
            logger.log(LogStatus.PASS, "TC-1886 General");
            logger.log(LogStatus.INFO, "General Info is displayed");
        } else {
            log.info("####### TC-1886 General #######");
            logger.log(LogStatus.FAIL, "TC-1886 General");
            logger.log(LogStatus.INFO, "General Info is not displayed");
        }

    }


    public void playersSearchField(String year, String championship, String playerID) throws Throwable {
        logger = report.startTest("TC-1877 Players Search Field");
        log.info("####### TC-1877 Players Search Field #######");
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
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", applyCloseOfEntries);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", applyCloseOfEntries);
            addEntry.click();
            Thread.sleep(2000);
            actions.moveToElement(playerSearch).click().sendKeys(playerID).perform();
            Thread.sleep(3000);
            playerClick.click();
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/ChampAdmin Players Eligible Late Applications/TC-1877 Players Search Field.png"));
            log.info("####### TC-1877 Players Search Field #######");
            logger.log(LogStatus.PASS, "TC-1877 Players Search Field");
            logger.log(LogStatus.INFO, "Players Search Field is displayed and functioning as expected");
        } catch (Exception e) {
            log.info("####### TC-1877 Players Search Field #######");
            logger.log(LogStatus.FAIL, "TC-1877 Players Search Field");
            logger.log(LogStatus.INFO, "Players Search Field is not functioning as expected");
        }

    }

    public void submitCTA(String year, String championship, String playerID) throws Throwable {
        logger = report.startTest("TC-1874 Submit CTA");
        log.info("####### TC-1874 Submit CTA #######");
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
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", applyCloseOfEntries);
            Thread.sleep(1000);
            js.executeScript("arguments[0].click();", applyCloseOfEntries);
            addEntry.click();
            Thread.sleep(2000);
            actions.moveToElement(playerSearch).click().sendKeys(playerID).perform();
            Thread.sleep(3000);
            playerClick.click();
            clickOk.click();
            Thread.sleep(9000);
            snapshot = (TakesScreenshot) driver;
            File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/ChampAdmin Players Eligible Late Applications/TC-1874 Player Added.png"));
            selectPlayer.click();
            Thread.sleep(1000);
            delEntry.click();
            clickYes.click();
            Thread.sleep(3000);
            File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/ChampAdmin Players Eligible Late Applications/TC-1874 Player removed.png"));
            log.info("####### TC-1874 Submit CTA #######");
            logger.log(LogStatus.PASS, "TC-1874 Submit CTA");
            logger.log(LogStatus.INFO, "Submit CTA is displayed and functioning as expected");
        } catch (Exception e) {
            log.info("####### TC-1874 Submit CTA #######");
            logger.log(LogStatus.FAIL, "TC-1874 Submit CTA");
            logger.log(LogStatus.INFO, "Submit CTA is not functioning as expected");
        }
    }
}



