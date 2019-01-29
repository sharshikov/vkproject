package Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageFactory {
    private static WebDriver driver;
    private static PageWrapper PageWrapper;
    public static WebDriver getDriver() {
        if(driver==null) {
            System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static PageWrapper getInstance() {
        if(null==PageWrapper) {
            PageWrapper = new PageWrapper();
        }
        return PageWrapper;
    }

}
