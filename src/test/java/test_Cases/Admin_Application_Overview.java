package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Application_Overview_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;
import utilities.ExcelFileUtil;

public class Admin_Application_Overview extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "App_Details";
    ExcelFileUtil xl;
    int rc;
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1849 Application High Level Info is displayed", enabled = true)
    public void appHighLevelInfo() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 8; i <= 8; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            Admin_Application_Overview_Page data = PageFactory.initElements(driver, Admin_Application_Overview_Page.class);
            data.appHighLevelInfo(year, champName, searchData);
        }
        adminLogout.logout();
    }

    @Test(priority = 2, description = "TC-1843 Save Changes CTA is displayed and functioning", enabled = true)
    public void saveCTA() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 8; i <= 8; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            Admin_Application_Overview_Page data = PageFactory.initElements(driver, Admin_Application_Overview_Page.class);
            data.save(year, champName, searchData);
        }
        adminLogout.logout();
    }

    @Test(priority = 3, description = "TC-1882 Payment Info Area is displayed and functioning", enabled = true)
    public void paymentInfo() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 8; i <= 8; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            Admin_Application_Overview_Page data = PageFactory.initElements(driver, Admin_Application_Overview_Page.class);
            data.paymentInfoArea(year, champName, searchData);
        }
        adminLogout.logout();
    }

    @Test(priority = 4, description = "TC-3037 Qualifying/Exemption Status Area is displayed and functioning", enabled = true)
    public void qualifyingExceptionStatusArea() throws Throwable {
        adminLogin.login1();
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 11; i <= 11; i++) {
            String year = xl.getcelldata(sheetName, i, 1);
            String champName = xl.getcelldata(sheetName, i, 2);
            String searchData = xl.getcelldata(sheetName, i, 4);
            String exception = xl.getcelldata(sheetName, i, 5);
            String site = xl.getcelldata(sheetName, i, 6);
            String status = xl.getcelldata(sheetName, i, 7);
            Admin_Application_Overview_Page data = PageFactory.initElements(driver, Admin_Application_Overview_Page.class);
            data.qualifyingExceptionArea(year, champName, searchData, exception, site, status);
        }
        adminLogout.logout();
    }
}
