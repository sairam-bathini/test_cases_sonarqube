package test_Cases;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Player_Details_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Player_Details extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Player_Details";
    ExtentTest logger;
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1852 General Information displays", enabled = true)
    public void genenalInfoDisplay() throws Throwable {

        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 2; i <= 2; i++) {
            String playerID = xl.getcelldata(sheetName, i, 1);
            Admin_Player_Details_Page data = PageFactory.initElements(driver, Admin_Player_Details_Page.class);
            data.generalInformationDisplays(playerID);
        }
        adminLogout.logout();

    }

    @Test(priority = 2, description = "TC-1859 General Information displays", enabled = false)
    public void contactInfoDisplays() throws Throwable {

    }

    @Test(priority = 4, description = "TC-1878 Player Championship History displays ", enabled = true)
    public void championshipHistoryDisplays() throws Throwable {

        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 2; i <= 2; i++) {
            String playerID = xl.getcelldata(sheetName, i, 1);
            Admin_Player_Details_Page data = PageFactory.initElements(driver, Admin_Player_Details_Page.class);
            data.championshipHistory(playerID);
        }

        adminLogout.logout();

    }

    @Test(priority = 5, description = "TC-1884 Save Changes CTA displays ", enabled = true)
    public void saveChangesCTA() throws Throwable {

        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 2; i <= 2; i++) {
            String playerID = xl.getcelldata(sheetName, i, 1);
            Admin_Player_Details_Page data = PageFactory.initElements(driver, Admin_Player_Details_Page.class);
            data.saveChanges(playerID);
        }
        adminLogout.logout();

    }

    @Test(priority = 6, description = "TC-1869 Status and Flags displays", enabled = true)
    public void statusAndFlagDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 2; i <= 2; i++) {
            String playerID = xl.getcelldata(sheetName, i, 1);
            Admin_Player_Details_Page data = PageFactory.initElements(driver, Admin_Player_Details_Page.class);
            data.statusAndFlagDisplay(playerID);
        }

        adminLogout.logout();

    }

}
