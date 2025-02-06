package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_ChampManagement_Dashboard_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_ChampManagement_Dashboard extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Champ_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1842 Create New Event drop-down displays", enabled = true)
    public void emailCheckboxDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 2; i <= 2; i++) {
            String champName = xl.getcelldata(sheetName, i, 1);
            Admin_ChampManagement_Dashboard_Page data = PageFactory.initElements(driver, Admin_ChampManagement_Dashboard_Page.class);
            data.createNewEvent(champName);
        }
        adminLogout.logout();

    }
    @Test(priority = 2, description = "TC-1842 Create New Event drop-down displays", enabled = true)
    public void champListDisplayed() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 2; i <= 2; i++) {
            String champName = xl.getcelldata(sheetName, i, 1);
            Admin_ChampManagement_Dashboard_Page data = PageFactory.initElements(driver, Admin_ChampManagement_Dashboard_Page.class);
            data.champListDisplay(champName);
        }
        adminLogout.logout();

    }

}
