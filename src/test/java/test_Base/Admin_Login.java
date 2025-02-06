package test_Base;

import org.openqa.selenium.support.PageFactory;
import page_Object.Admin_Login_Page;
import utilities.ExcelFileUtil;

public class Admin_Login extends Admin_BaseClass {
    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Admin_profile";
    ExcelFileUtil xl;
    int rc;

    public void login(int rownum) throws Throwable {
        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);
        for (int i = rownum; i <= rownum; i++) {
            String email = xl.getcelldata(sheetName, i, 0);
            String pswd = xl.getcelldata(sheetName, i, 1);
            Admin_Login_Page data = PageFactory.initElements(driver, Admin_Login_Page.class);
            data.loginMethod(email, pswd);
        }
    }

    public void login1() throws Throwable {
        login(1);
    }

}
