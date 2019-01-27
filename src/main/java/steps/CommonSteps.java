package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CommonPage;
import ru.yandex.qatools.allure.annotations.Attachment;

public class CommonSteps {
    public static WebDriver driver;
    public static WebDriver getDriver(){
        return driver;
    }
    @Before
    public static void SetUp(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru");
    }
    @After
    public static void tearDown(Scenario scenario){
        if(scenario.isFailed())
            saveAllureScreenshot();
        driver.quit();
    }
    @Когда("^нажал на кнопку (.*?)$")
    public void buttonStep(String href){
        new CommonPage().hrefClick(href);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected static byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
