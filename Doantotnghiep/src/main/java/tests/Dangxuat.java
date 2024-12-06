package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseSetup;
import pages.LoginPage;

import java.time.Duration;

public class Dangxuat extends BaseSetup {

    private LoginPage loginPage;
    private Actions actions;
    private WebDriverWait wait; // Khai báo đối tượng WebDriverWait

    @BeforeMethod
    public void setUp() {
        driver = getDriver();
        loginPage = new LoginPage(driver);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Khởi tạo WebDriverWait
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
        
        // Rơ chuột vào nút tài khoản để hiển thị thông tin đăng xuất
        WebElement accountMenu = driver.findElement(By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[2]/div[2]")); // Nút tài khoản
        actions.moveToElement(accountMenu).perform(); // Rơ chuột vào nút tài khoản
        Thread.sleep(2000); // Chờ để hiển thị đăng xuất
        
        loginPage.Dx(); // đăng xuất
        Thread.sleep(5000); // Chờ trang tải
        
        loginPage.Qc(); // Đóng quảng cáo nếu có
        Thread.sleep(5000);
        
    }

    @AfterMethod
    public void tearDown() throws Exception {
        super.tearDown(); // Dọn dẹp sau kiểm thử
    }
}
