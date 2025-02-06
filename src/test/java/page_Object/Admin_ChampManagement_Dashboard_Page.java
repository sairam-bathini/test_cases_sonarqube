package page_Object;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.io.File;
import java.util.List;

public class Admin_ChampManagement_Dashboard_Page extends Admin_BaseClass {
    public Admin_ChampManagement_Dashboard_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Championship Management']")
    WebElement clickChampMngmt;
    @FindBy(xpath = "//div[text()='Create a new event']")
    WebElement newEvent;
    @FindBy(xpath = "(//*[@class='Icon__DragAndDropIcon-sc-1b8stld-24 erhxIg'])[2]")
    WebElement position1;
    @FindBy(xpath = "(//*[@class='Icon__DragAndDropIcon-sc-1b8stld-24 erhxIg'])[3]")
    WebElement position2;


    public void createNewEvent(String champName) throws Throwable {
        logger = report.startTest("TC-1856 Championship Summary displays ");
        log.info("####### TC-1856 Championship Summary displays #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(3000);
        newEvent.click();
        snapshot = (TakesScreenshot) driver;
        File screenShot = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot, new File(System.getProperty("user.dir") + "/target/ScreenShots/Create Event/TC-1856 Champ Summary.png"));
        List<WebElement> options = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));

        String val = champName;
        List<WebElement> options1 = driver.findElements(By.xpath("//div[contains(@id,'react-select')]"));
        for (WebElement option : options1) {
            if ((option.getText()).equals(val)) {
                option.click();
                break;
            }
        }
        Thread.sleep(2000);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Create Event/TC-1842 New Champ Page.png"));
    }

    public void champListDisplay(String champName) throws Throwable {
        logger = report.startTest("Save CTA is displaying and functioning ");
        log.info("####### TC-1846 Championships List is displayed correctly #######");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", clickChampMngmt);
        Thread.sleep(4000);
        snapshot = (TakesScreenshot) driver;
        Actions action = new Actions(driver);
        action.dragAndDrop(position1,position2).build().perform();
        Thread.sleep(2000);
        File screenShot1 = snapshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot1, new File(System.getProperty("user.dir") + "/target/ScreenShots/Create Event/TC-1846 ChampList1.png"));
    }
}
