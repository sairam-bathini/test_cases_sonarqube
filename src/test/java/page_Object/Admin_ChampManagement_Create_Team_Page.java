package page_Object;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test_Base.Admin_BaseClass;

import java.util.List;

public class Admin_ChampManagement_Create_Team_Page extends Admin_BaseClass {
    public Admin_ChampManagement_Create_Team_Page(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[text()='Championship Management']")
    WebElement clickChampMngmt;
    @FindBy(xpath = "(//div[@class=' css-1hwfws3'])[1]")
    WebElement clickYear;
    @FindBy(xpath = "//*[text()='Substitution / Create Team']")
    WebElement createTeam;

    public void mergeIntoTeam(String year, String championship) throws Throwable {
        logger = report.startTest("TC-1871 Merge into Team CTA ");
        log.info("####### TC-1871 Merge into Team CTA #######");
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

        js.executeScript("arguments[0].click();", createTeam);
        Thread.sleep(500);
    }
}
