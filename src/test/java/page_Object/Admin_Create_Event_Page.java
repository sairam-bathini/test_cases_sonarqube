package page_Object;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_Create_Event_Page extends Admin_BaseClass {
    public Admin_Create_Event_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Championship Management']")
    WebElement clickChampMngmt;
    @FindBy(xpath = "//div[text()='Create a new event']")
    WebElement newEvent;
    @FindBy(xpath = "//span[text()='Active Championship']")
    WebElement activeChamp;
    @FindBy(xpath = "//span[contains(text(),'Qualifying Sites')]")
    WebElement hideQualifyingSites;
    @FindBy(xpath = "//span[contains(text(),'Sneak Peek')]")
    WebElement hideSneakPeek;
    @FindBy(xpath = "//span[text()='All-exempt Championship']")
    WebElement allExemptChampionship;
    @FindBy(xpath = "//div[text()='Championship']/following::input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement champName;
    @FindBy(xpath = "//div[text()='Type to search for a club']")
    WebElement clickClub;
    @FindBy(xpath = "//*[@class='Icon__PlusIcon-sc-1b8stld-16 ciCOBP']")
    WebElement addClub;
    @FindBy(xpath = "//div[text()='Championship']/following::input[@class='components__InputStyled-sc-78cfz3-1 jXhjCH'][1]")
    WebElement champBackground;
    @FindBy(xpath = "//div[text()='Championship']/following::input[@class='components__InputStyled-sc-78cfz3-1 jXhjCH'][2]")
    WebElement champLogo;
    @FindBy(xpath = "(//*[contains(@class,'CloudinaryImage__StyledImage')])[2]")
    WebElement clickChampLogo;
    @FindBy(xpath = "//div[text()='Championship Overview URL']/following::input[@class='components__InputStyled-sc-78cfz3-1 juWmLe'][1]")
    WebElement champOverviewURL;
    @FindBy(xpath = "//div[text()='Championship Start Date']/following::div[@class='react-datetime-picker__wrapper'][1]")
    WebElement champStartDate;

    @FindBy(xpath = "//*[text()='Save']")
    WebElement save;


    public void champSummaryDisplay(String champName) throws Throwable {
        logger = report.startTest("TC-1842 Create New Event drop-down displays ");
        log.info("####### TC-1842 Create New Event drop-down displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(3000);
        newEvent.click();
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/ChampMgmt Dashboard/TC-1842 ChampList.png"));
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        String val = champName;
        List<WebElement> options1 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        for (WebElement option : options1) {
            if ((option.getText()).equals(val)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
    }

    public void saveCTA(String champName) throws Throwable {
        logger = report.startTest("TC-1842 Create New Event drop-down displays ");
        log.info("####### TC-1842 Create New Event drop-down displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(3000);
        newEvent.click();
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/ChampMgmt Dashboard/TC-1842 ChampList.png"));
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        for (WebElement option : options) {
            System.out.println(option.getText());
        }
        String val = champName;
        List<WebElement> options1 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        for (WebElement option : options1) {
            if ((option.getText()).equals(val)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
    }
}
