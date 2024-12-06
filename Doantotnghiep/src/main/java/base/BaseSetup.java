package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {
    protected WebDriver driver;

    public BaseSetup() {
        setupWebDriver();
    }

    private void setupWebDriver() {
    	WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
