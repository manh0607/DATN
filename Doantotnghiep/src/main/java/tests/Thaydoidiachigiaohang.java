package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseSetup;
import pages.LoginPage;

public class Thaydoidiachigiaohang extends BaseSetup {

    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);

        loginPage.Qc(); // Đóng quảng cáo nếu có
        Thread.sleep(5000);
        loginPage.Tk(); // Mở menu tài khoản
        Thread.sleep(5000);

        // Nhập vào trường số điện thoại
        loginPage.Sdt("0967931759"); 
        loginPage.clicktt(); 
        Thread.sleep(5000);

        // Nhập vào trường mật khẩu
        loginPage.Mk("Manhtran0607"); 
        loginPage.Dn();
        
        // Dừng lại để nhập CAPTCHA thủ công
        System.out.println("Vui lòng nhập CAPTCHA thủ công.");
        Thread.sleep(20000); // Dừng 30 giây để nhập CAPTCHA
        
        loginPage.Qc(); // Đóng quảng cáo nếu có
        Thread.sleep(5000);
        
        loginPage.Giohang();
        Thread.sleep(5000);
        
        loginPage.Thaydoidc();
        Thread.sleep(5000);
        
        loginPage.Diachigh1();
        Thread.sleep(10000);
      
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown(); // Dọn dẹp sau kiểm thử
    }
}


