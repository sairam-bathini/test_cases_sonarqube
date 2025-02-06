package test_Cases;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_PlayerManagement_Table_View_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_PlayerManagement_Table_View extends Admin_BaseClass {

    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Player_Details";
    ExtentTest logger;
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1819 Search displays ", enabled = true)
    public void serachDisplays() throws Throwable {

        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 5; i <= 5; i++) {
            String searchData = xl.getcelldata(sheetName, i, 1);
            Admin_PlayerManagement_Table_View_Page data = PageFactory.initElements(driver, Admin_PlayerManagement_Table_View_Page.class);
            data.searchDisplay(searchData);
        }
        adminLogout.logout();

    }

    @Test(priority = 2, description = "TC-1827 Filters dropdown displays ", enabled = true)
    public void filterDropdownDisplays() throws Throwable {

        adminLogin.login1();
        Admin_PlayerManagement_Table_View_Page data = PageFactory.initElements(driver, Admin_PlayerManagement_Table_View_Page.class);
        data.filterDropdown();
        adminLogout.logout();


    }

    @Test(priority = 3, description = "TC-1833 Export CTA button displays ", enabled = true)
    public void exportButtonCTA() throws Throwable {

        adminLogin.login1();
        Admin_PlayerManagement_Table_View_Page data = PageFactory.initElements(driver, Admin_PlayerManagement_Table_View_Page.class);
        data.exportCTA();
        adminLogout.logout();
    }

    @Test(priority = 4, description = "TC-1863 Table area displays ", enabled = true)
    public void tableAreaDisplay() throws Throwable {
        adminLogin.login1();
        Admin_PlayerManagement_Table_View_Page data = PageFactory.initElements(driver, Admin_PlayerManagement_Table_View_Page.class);
        data.tableArea();
        adminLogout.logout();
    }


}
