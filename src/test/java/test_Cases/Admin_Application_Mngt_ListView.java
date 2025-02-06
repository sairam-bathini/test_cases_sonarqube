package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;
import page_Object.Admin_Application_Mngt_ListView_Page;


public class Admin_Application_Mngt_ListView extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "App_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1820 'Year' and 'Name' of the Championship can be selected from the drop-downs", enabled = true)
    public void yearAndNameSelectionDropdown() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 2; i <= 2; i++) {

            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            System.out.println(year + " test " + champName);
            Admin_Application_Mngt_ListView_Page data = PageFactory.initElements(driver, Admin_Application_Mngt_ListView_Page.class);
            data.yearAndNameSelection(year, champName);
        }
        adminLogout.logout();

    }

    @Test(priority = 2, description = "TC-1825 Filters dropdown is displayed and functioning", enabled = true)
    public void filtersDropdownDisplay() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 3; i <= 3; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String status = xl.getcelldata(sheetName, i, 3);
            Admin_Application_Mngt_ListView_Page data = PageFactory.initElements(driver, Admin_Application_Mngt_ListView_Page.class);
            data.filtersDropdownDisplay(year, champName, status);
        }
        adminLogout.logout();
    }

    @Test(priority = 3, description = "TC-1832 Search bar is displayed and functioning", enabled = true)
    public void searchDisplay() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 4; i <= 4; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            Admin_Application_Mngt_ListView_Page data = PageFactory.initElements(driver, Admin_Application_Mngt_ListView_Page.class);
            data.searchBarDisplay(year, champName, searchData);
        }
        adminLogout.logout();
    }

    @Test(priority = 4, description = "TC-1838 Table area is displayed", enabled = true)
    public void tableAreaDisplays() throws Throwable {
        adminLogin.login1();
        Admin_Application_Mngt_ListView_Page data = PageFactory.initElements(driver, Admin_Application_Mngt_ListView_Page.class);
        data.tableAreaDisplay();
        adminLogout.logout();

    }
}



