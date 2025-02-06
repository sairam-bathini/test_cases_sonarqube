package test_Cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import page_Object.Admin_Template_List_Page;
import test_Base.Admin_BaseClass;
import test_Base.Admin_Login;
import test_Base.Admin_Logout;

public class Admin_Template_List extends Admin_BaseClass {
    Admin_Login adminLogin = new Admin_Login();
    Admin_Logout adminLogout = new Admin_Logout();

    @Test(priority = 1, description = "TC-1891 Add Site CTA is displayed and functioning ", enabled = true)
    public void newCTADisplayedAndFunctioning() throws Throwable {
        adminLogin.login1();
        Admin_Template_List_Page data = PageFactory.initElements(driver, Admin_Template_List_Page.class);
        data.newCTADisplayedAndFunctioning();
        adminLogout.logout();
    }

    @Test(priority = 2, description = "TC-1891 Add Site CTA is displayed and functioning ", enabled = true)
    public void templatesListdisplayedAndFunctioning() throws Throwable {
        adminLogin.login1();
        Admin_Template_List_Page data = PageFactory.initElements(driver, Admin_Template_List_Page.class);
        data.templatesListdisplayedAndFunctioning();
        //  adminLogout.logout();
    }
}
