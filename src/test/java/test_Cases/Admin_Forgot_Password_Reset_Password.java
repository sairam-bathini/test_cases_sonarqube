package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import page_Object.Admin_Forgot_Password_Reset_Password_page;
import test_Base.Admin_BaseClass;
import utilities.ExcelFileUtil;

public class Admin_Forgot_Password_Reset_Password extends Admin_BaseClass {

    String input = "./FileInput/ChampAdmin_TestData.xlsx";
    String sheetName = "Forget_Pass";
    ExtentTest logger;
    ExcelFileUtil xl;
    int rc;


    @Test(description = "TC-1851 Recover Password CTA is active and functioning, TC-1860 Module is displayed in a pop up, TC- 1817 Email Field is required, displayed and functioning ")
    public void recoverPasswordCTA() throws Throwable {

        xl = new ExcelFileUtil(input);
        rc = xl.rowcount(sheetName);

            for (int i = 1; i <= 1; i++) {
                String invalidemail = xl.getcelldata(sheetName, i, 0);
                String validemail = xl.getcelldata(sheetName, i, 1);
                Admin_Forgot_Password_Reset_Password_page forgetpass = PageFactory.initElements(driver, Admin_Forgot_Password_Reset_Password_page.class);
                forgetpass.recoverPassword(invalidemail, validemail);
            }


    }
}
