package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Create_Event_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Create_Event extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "App_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1842 Create New Event drop-down displays ", enabled = true)
    public void champSummaryDisplays() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 15; i <= 15; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            Admin_Create_Event_Page data = PageFactory.initElements(driver, Admin_Create_Event_Page.class);
            data.champSummaryDisplay(champName);
        }
        adminLogout.logout();
    }
}
