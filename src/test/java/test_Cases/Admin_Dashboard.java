package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Dashboard_Page;
import test_Base.Admin_BaseClass;
import utilities.ExcelFileUtil;

public class Admin_Dashboard extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Admin_profile";
    ExcelFileUtil xl;
    int rc;

    @Test(priority = 1, description = "TC-1848 Actions Required section is displayed and functioning ",enabled = true)
    public void actionRequired() throws Throwable {

        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 1; i <= 1; i++) {
            String email = xl.getcelldata(sheetName, i, 0);
            String password = xl.getcelldata(sheetName, i, 1);
            Admin_Dashboard_Page data = PageFactory.initElements(driver,Admin_Dashboard_Page.class);
            data.actionsRequired(email,password);

        }

    }
    @Test(priority = 2, description = "TC-1853 Reports is displayed and functioning ")
    public void reportsDisplayed() throws Throwable {


        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = 1; i <= 1; i++) {
            String email = xl.getcelldata(sheetName, i, 0);
            String password = xl.getcelldata(sheetName, i, 1);
            Admin_Dashboard_Page data = PageFactory.initElements(driver,Admin_Dashboard_Page.class);
            data.reportsDisplayed(email,password);

        }


    }
}
