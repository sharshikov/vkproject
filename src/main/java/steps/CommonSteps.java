package steps;

import Help.Page;
import Help.PageFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Когда;

import java.util.concurrent.TimeUnit;

public class CommonSteps {
    @Before
    public void SetUp(){
        PageFactory.getDriver().manage().window().maximize();
        PageFactory.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.getDriver().get("https:/www.yandex.ru");
    }
    @After
    public void tearDown(){
        PageFactory.getDriver().quit();
    }
    @Когда("^пользователь находится на странице (.*?)$")
    public void initCurrentPage(String page) throws InterruptedException {
        PageFactory.getInstance().getPage(page,"pages");
    }
}
