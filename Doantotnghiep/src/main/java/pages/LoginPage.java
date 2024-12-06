package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

public class LoginPage {

    private WebDriver driver;

    // Cập nhật selector cho các phần tử
    private By sodienthoai = By.xpath("/html/body/div[10]/div/div/div/div[1]/div/form/div/input"); // Nhập số điện thoại
    private By tieptuc = By.xpath("/html/body/div[10]/div/div/div/div[1]/div/form/button"); // Nút Tiếp tục
    private By matkhau = By.xpath("/html/body/div[10]/div/div/div/div[1]/div/form/div/input"); // Nhập mật khẩu
    private By dangnhap = By.xpath("/html/body/div[10]/div/div/div/div[1]/div/form/button"); // Nút Đăng nhập
    
    private By quangcao = By.xpath("//*[@id=\"VIP_BUNDLE\"]/div[2]/div/picture[1]/img"); // Nút đóng quảng cáo
    private By taikhoan = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[2]/div[2]"); // Nút tài khoản
    private By thongtintaikhoan = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/a[1]/p"); // Nút Thông tin tài khoản
    
    private By dangxuat = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[2]/div[2]/div/a[4]/p"); // Nút Đăng xuất
    
    private By capnhatmk = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[3]/div[2]/div[1]/div[2]/button"); // Nút Cập nhật (bên trong trang thông tin tài khoản)
    private By matkhauhientai = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/form/div[1]/div/input"); // Nhập mật khẩu hiện tại
    private By matkhaumoi = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/form/div[2]/div[1]/input"); // Nhập mật khẩu mới
    private By nhaplaimatkhau = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/form/div[3]/div/input"); // Nhập lại mật khẩu mới
    private By luumatkhau = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/form/button"); // Nút Lưu thay đổi
    
    private By nhapsanpham = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[1]/div/div/input"); // Thanh tìm kiếm
    private By timkiemsanpham = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[1]/div/div/button"); // Nút tìm kiếm
    
    private By hoTen = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/form/div[1]/div[2]/div[1]/div/div/input"); // Nhập họ tên
    private By bietDanh = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/form/div[1]/div[2]/div[2]/div/div/input"); // Nhập biệt danh
    private By ngaySinh = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/form/div[2]/div/select[1]"); // Chọn ngày sinh
    private By thangSinh = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/form/div[2]/div/select[2]"); // Chọn tháng sinh
    private By namSinh = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/form/div[2]/div/select[3]"); // Chọn năm sinh
    private By gioiTinhNam = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/form/div[3]/label[2]/span[2]"); // Chọn giới tính nam
    private By gioiTinhNu = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/form/div[3]/label[3]/span[2]"); // Chọn giới tính nữ
    private By chonQuocTich = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/form/div[4]/div/div/input"); // Nút chọn quốc tịch
    private By timKiemQuocTich = By.xpath("/html/body/div[10]/div/div/div/div[2]/div/input"); // Tìm kiếm quốc tịch
    private By luuQuocTich = By.xpath("/html/body/div[10]/div/div/div/div[4]/button"); // Nút Lưu thay đổi quốc tịch
    private By luuCapNhatThongTin = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div/div[1]/div/form/button"); // Nút Lưu thay đổi thông tin
    
    private By dienthoai = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[1]/div[1]/div[4]/div/a/div[2]");
    private By chonsp = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div[5]/div/div[3]/div/div/div/a/span/div[1]/div[3]/picture/img");
    private By themsp = By.xpath("//*//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div/div[3]/div[3]/button[2]");
    private By boloc = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div[4]/div[2]/div/div[1]/div[2]/button/div");
    private By bolocthuonghieu = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div[4]/div[2]/div/div[1]/div[1]/div[1]/div[3]/div[2]/button[1]/div");
    private By bolockhoanggia = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div[4]/div[3]/div[2]/div[2]/div[5]/div[1]/button[2]/div");
    private By bolocdanhgia = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div[4]/div[3]/div[2]/div[2]/div[4]/div/div[1]/div/div[1]/span/img[2]");
    private By xemketqua = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div[4]/div[3]/div[2]/div[3]/div[2]");
    private By xoaboloc = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div[4]/div[3]/div[2]/div[3]/div[1]");
    
    
    
    private By giohang = By.xpath("//*[@id=\"main-header\"]/div/div/div[2]/div[1]/div[2]/div[3]/a/div/div/img");
    private By chonspthanhtoan = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div/div[2]/div[1]/div[1]/label/span");
    
    private By chontatcaspgiohang = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[1]/label/span[1]");
    private By xoatatcaspgiohang = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[1]/img");
    private By xacnhanxoa = By.xpath("/html/body/div[11]/div/div/div/div[2]/div[1]");
    
    private By tangslsp = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[1]/div[2]/div/div[1]/div[2]/div/div[3]/div/span[2]/img");
    
    private By thaydoi = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/a");
    private By diachi1 = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[1]/div/div[1]/p[5]/button[1]");
    private By diachi2 = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[1]/div/div[2]/p[5]/button[1]");
    private By diachi3 = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[1]/div/div[3]/p[5]/button[1]");
    
    private By chonsapxep = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div/div[2]/div[2]/div[4]/div[2]/div/div[2]/div[2]/div[2]/div[2]/img");
    private By sptucaotoithap = By.xpath("//*[@id=\"popup-106\"]/div/div[5]/div");
  
    //*[@id="popup-111"]/div/div[5]/div
    
    private By rochuot = By.xpath("//*[@id=\"__next\"]/div[2]/main/div/div[2]/div[2]/div/div[1]/div[1]/div[1]/a");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getLoginInPageTitle() {
        return driver.getTitle(); // Lấy tiêu đề của trang đăng nhập
    }

    public void Qc() {
        // Đóng quảng cáo nếu nút đóng quảng cáo hiển thị
           	WebElement Quangcao = driver.findElement(quangcao);
            if (Quangcao.isDisplayed()) {
            	Quangcao.click();
            }
    }

    public void Tk() {
        // Mở menu tài khoản nếu nút tài khoản hiển thị
            WebElement Taikhoan = driver.findElement(taikhoan);
            if (Taikhoan.isDisplayed()) {
            	Taikhoan.click();
            }
    }

    public void Sdt(String phoneNumber) {
        // Nhập số điện thoại vào ô nhập
            WebElement Sodienthoi = driver.findElement(sodienthoai);
            if (Sodienthoi.isDisplayed()) {
            	Sodienthoi.sendKeys(phoneNumber);
            }
    }

    public void clicktt() {
        // Nhấn nút Tiếp tục
            WebElement Tieptuc = driver.findElement(tieptuc);
            if (Tieptuc.isDisplayed()) {
            	Tieptuc.click();
            }
    }

    public void Mk(String password) {
        // Nhập mật khẩu vào ô nhập
            WebElement Matkhau = driver.findElement(matkhau);
            if (Matkhau.isDisplayed()) {
            	Matkhau.sendKeys(password);
            }
    }

    public void Dn() {
        // Nhấn nút Đăng nhập
            WebElement Dangnhap = driver.findElement(dangnhap);
            if (Dangnhap.isDisplayed()) {
            	Dangnhap.click();
            }
    }
    
    public void Dx() {
        // Đăng xuất tài khoản
            WebElement Dangxuat = driver.findElement(dangxuat);
            if (Dangxuat.isDisplayed()) {
            	Dangxuat.click();
            }
    }

    // Phương thức cho các chức năng liên quan đến cập nhật thông tin tài khoản

    public void Tttk() {
        // Mở trang thông tin tài khoản
            WebElement Thongtintaikhoan = driver.findElement(thongtintaikhoan);
            if (Thongtintaikhoan.isDisplayed()) {
            	Thongtintaikhoan.click();
            }
    }
    
    // Cập nhật thông tin
    
    public void nhapHoTen(String hoten) {
        WebElement hoTenElement = driver.findElement(hoTen); // Sử dụng fullNameInput đã khai báo
        if (hoTenElement.isDisplayed()) {
            // Tạo đối tượng Actions
            Actions actions = new Actions(driver);
            // Nhấn Control + A để chọn tất cả và sau đó nhấn Delete để xóa
            actions.moveToElement(hoTenElement).click().keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
            hoTenElement.sendKeys(hoten); // Nhập họ tên mới
        }
    }
    // Phương thức nhập biệt danh
    public void nhapBietDanh(String bietdanh) {
        	WebElement bietDanhElement = driver.findElement(bietDanh);
        	if (bietDanhElement.isDisplayed()) {
        		bietDanhElement.clear(); // Xóa nội dung cũ nếu có
        		bietDanhElement.sendKeys(bietdanh);
        	}
    }
    
    	// Thay đổi mật khẩu
    
    public void clickcnmk() {
        // Nhấn nút Cập nhật để hiển thị form thay đổi mật khẩu
            WebElement Capnhatmk = driver.findElement(capnhatmk);
            if (Capnhatmk.isDisplayed()) {
            	Capnhatmk.click();
            }
    }

    public void Mkhientai(String currentPassword) {
        // Nhập mật khẩu hiện tại vào ô nhập
            WebElement Matkhauhientai = driver.findElement(matkhauhientai);
            if (Matkhauhientai.isDisplayed()) {
            	Matkhauhientai.sendKeys(currentPassword);
            }
    }

    public void Mkmoi(String newPassword) {
        // Nhập mật khẩu mới vào ô nhập
            WebElement Matkhaumoi = driver.findElement(matkhaumoi);
            if (Matkhaumoi.isDisplayed()) {
            	Matkhaumoi.sendKeys(newPassword);
            }
    }

    public void NhaplaiMk(String confirmPassword) {
        // Nhập lại mật khẩu mới vào ô nhập
            WebElement Nhaplaimatkhau = driver.findElement(nhaplaimatkhau);
            if (Nhaplaimatkhau.isDisplayed()) {
            	Nhaplaimatkhau.sendKeys(confirmPassword);
            }
    }

    public void LuuMk() {
        // Nhấn nút Lưu thay đổi
            WebElement Luumatkhau = driver.findElement(luumatkhau);
            if (Luumatkhau.isDisplayed()) {
            	Luumatkhau.click();
            }
    }
    
    
    // Tìm kiếm sản phẩm
    public void Sanpham(String query) {
        // Nhập từ khóa vào thanh tìm kiếm nếu nó hiển thị
        WebElement Nhapsanpham = driver.findElement(nhapsanpham);
        if (Nhapsanpham.isDisplayed()) {
        	Nhapsanpham.sendKeys(query);
        }
    }

    public void clickTimkiem() {
        // Nhấn nút tìm kiếm nếu nó hiển thị
        WebElement Timkiemsanpham = driver.findElement(timkiemsanpham);
        if (Timkiemsanpham.isDisplayed()) {
        	Timkiemsanpham.click();
        }
    }
    public void clearSearchBox() {
        WebElement searchBox = driver.findElement(nhapsanpham); // Hoặc bằng cách tìm ID chính xác của ô tìm kiếm
        searchBox.clear(); // Thực hiện xóa nội dung trong ô tìm kiếm

        // Kiểm tra xem ô tìm kiếm đã xóa hoàn toàn chưa
        String searchBoxValue = searchBox.getAttribute("value");
        if (!searchBoxValue.isEmpty()) {
            System.out.println("Lỗi: Nội dung chưa được xóa. Xóa bằng JavaScript.");
            // Sử dụng JavaScript nếu .clear() không hiệu quả
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", searchBox);
        } else {
            System.out.println("Đã xóa nội dung trong ô tìm kiếm.");
        }
    }

    // Thêm vào giỏ hàng
    public void chondanhmuc() {       
            WebElement Dienthoai = driver.findElement(dienthoai);
            if (Dienthoai.isDisplayed()) {
            	Dienthoai.click();
            }
    }
    public void chonsanpham() {       
            WebElement Chonsp = driver.findElement(chonsp);
            if (Chonsp.isDisplayed()) {
            	Chonsp.click();
            }
    }
    public void themvaogiohang() {        
            WebElement Themvaogio = driver.findElement(themsp);
            if (Themvaogio.isDisplayed()) {
            	Themvaogio.click();
            }
    }

    //chọn sp thanh toán
    public void Giohang() {        
            WebElement Vaogiohang = driver.findElement(giohang);
            if (Vaogiohang.isDisplayed()) {
            	Vaogiohang.click();
            }
    }
    public void Chondexemthanhtoan() {    
            WebElement Xemthanhtoan = driver.findElement(chonspthanhtoan);
            if (Xemthanhtoan.isDisplayed()) {
            	Xemthanhtoan.click();
            }
    }
    
    // xoá tất cả sản phẩm trong giỏ hàng
    public void Chontatcaspgiohang() {       
        WebElement Chontatcasanpham = driver.findElement(chontatcaspgiohang);
        if (Chontatcasanpham.isDisplayed()) {
        	Chontatcasanpham.click();
        }
    }
    public void Xoatatcaspgiohang() {
        WebElement Xoatatcasanpham = driver.findElement(xoatatcaspgiohang);
        if (Xoatatcasanpham.isDisplayed()) {
        	Xoatatcasanpham.click();
        }
    }
    public void Xacnhanxoatatca() {
        WebElement Xacnhanxoatatcasanpham = driver.findElement(xacnhanxoa);
        if (Xacnhanxoatatcasanpham.isDisplayed()) {
        	Xacnhanxoatatcasanpham.click();
        }
    }
    
    public void Tangslsanpham() {
        WebElement Tangslsp = driver.findElement(tangslsp);
        if (Tangslsp.isDisplayed()) {
        	Tangslsp.click();
        }
    }
    // thay đổi địa chỉ giao hàng
    public void Thaydoidc() {
        WebElement Thaydoi = driver.findElement(thaydoi);
        if (Thaydoi.isDisplayed()) {
        	Thaydoi.click();
        }
    }
    public void Diachigh1() {
        WebElement Diachi1 = driver.findElement(diachi1);
        if (Diachi1.isDisplayed()) {
        	Diachi1.click();
        }
    }
    public void Diachigh2() {
        WebElement Diachi2 = driver.findElement(diachi2);
        if (Diachi2.isDisplayed()) {
        	Diachi2.click();
        }
    }
    public void Diachigh3() {
        WebElement Diachi3 = driver.findElement(diachi3);
        if (Diachi3.isDisplayed()) {
        	Diachi3.click();
        }
    }
    // Lọc sản phẩm
    public void Locthuonghieusp() {
        WebElement Bolocthuonghieu = driver.findElement(bolocthuonghieu);
        if (Bolocthuonghieu.isDisplayed()) {
        	Bolocthuonghieu.click();
        }
    }
    
    public void Boloc() {
        WebElement Bolocsp = driver.findElement(boloc);
        if (Bolocsp.isDisplayed()) {
        	Bolocsp.click();
        }
    }
    
    public void Lockhoanggiasp() {
        WebElement Bolockhoanggia = driver.findElement(bolockhoanggia);
        if (Bolockhoanggia.isDisplayed()) {
        	Bolockhoanggia.click();
        }
    }
    public void Locdanhgia() {
        WebElement Bolocdanhgia = driver.findElement(bolocdanhgia);
        if (Bolocdanhgia.isDisplayed()) {
        	Bolocdanhgia.click();
        }
    }
    
    public void Xemketquasp() {
        WebElement Xemkqsp = driver.findElement(xemketqua);
        if (Xemkqsp.isDisplayed()) {
        	Xemkqsp.click();
        }
    }
    
    public void Xoabolocsp() {
        WebElement Xoaboloc = driver.findElement(xoaboloc);
        if (Xoaboloc.isDisplayed()) {
        	Xoaboloc.click();
        }
    }
    
    public void Cuonxuong() {
        // Cuộn xuống 500 pixel
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");
    }
    // chọn sp từ cao tới thấp
    
    public void Chonsapxepsp() {
        WebElement Chonsapxep = driver.findElement(chonsapxep);
        if (Chonsapxep.isDisplayed()) {
        	Chonsapxep.click();
        }
    }
    
    public void Sanphamcaotoithap() {
        WebElement Sptucaotoithap = driver.findElement(sptucaotoithap);
        if (Sptucaotoithap.isDisplayed()) {
        	Sptucaotoithap.click();
        }
    }
    

    
}
