package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_New_Email_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;

public class Admin_New_Email extends Admin_BaseClass {
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1891 Add Site CTA is displayed and functioning ", enabled = true)
    public void QualifyingSite_Management_List_Table_View_Page() throws Throwable {
        adminLogin.login1();
        Admin_New_Email_Page data = PageFactory.initElements(driver, Admin_New_Email_Page.class);
        data.emailTitleDisplays();
        adminLogout.logout();
    }

    @Test(priority = 2, description = "TC-1916 Email Body displays ", enabled = true)
    public void emailBodyDisplay() throws Throwable {
        adminLogin.login1();
        Admin_New_Email_Page data = PageFactory.initElements(driver, Admin_New_Email_Page.class);
        data.emailBodyDisplays();
        adminLogout.logout();
    }

    @Test(priority = 3, description = "TC-1911 Send CTA displays ", enabled = true)
    public void sendCTADisplay() throws Throwable {
        adminLogin.login1();
        Admin_New_Email_Page data = PageFactory.initElements(driver, Admin_New_Email_Page.class);
        data.saveCTADisplays();
        adminLogout.logout();
    }
}
