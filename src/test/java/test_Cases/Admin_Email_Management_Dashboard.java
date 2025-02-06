package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Email_Management_Dashboard_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;

public class Admin_Email_Management_Dashboard extends Admin_BaseClass {
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();
    @Test(priority = 1, description = "TC-1891 Add Site CTA is displayed and functioning ", enabled = true)
    public void QualifyingSite_Management_List_Table_View_Page() throws Throwable {
        adminLogin.login1();
        Admin_Email_Management_Dashboard_Page data = PageFactory.initElements(driver, Admin_Email_Management_Dashboard_Page.class);
        data.saveCTADisplayedAndFunctioning();
        adminLogout.logout();
    }
}
