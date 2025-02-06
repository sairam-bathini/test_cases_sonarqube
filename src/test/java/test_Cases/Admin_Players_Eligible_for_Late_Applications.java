package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Players_Eligible_for_Late_Applications_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Players_Eligible_for_Late_Applications extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Champ_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1917 Email Section displays", enabled = true)
    public void general() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 47; i <= 47; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            Admin_Players_Eligible_for_Late_Applications_Page data = PageFactory.initElements(driver, Admin_Players_Eligible_for_Late_Applications_Page.class);
            data.general(year, champName);
        }
        adminLogout.logout();

    }

    @Test(priority = 2, description = "TC-1867 Players Eligible to Apply After the Close of Entries", enabled = true)
    public void playersSearchField() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 48; i <= 48; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String playerID = xl.getcelldata(sheetName, i, 3);
            Admin_Players_Eligible_for_Late_Applications_Page data = PageFactory.initElements(driver, Admin_Players_Eligible_for_Late_Applications_Page.class);
            data.playersSearchField(year, champName, playerID);
        }
        adminLogout.logout();
    }

    @Test(priority = 3, description = "TC-1874 Submit CTA", enabled = true)
    public void submitCTA() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 49; i <= 49; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String playerID = xl.getcelldata(sheetName, i, 3);
            Admin_Players_Eligible_for_Late_Applications_Page data = PageFactory.initElements(driver, Admin_Players_Eligible_for_Late_Applications_Page.class);
            data.submitCTA(year, champName, playerID);
        }
        adminLogout.logout();
    }
}
