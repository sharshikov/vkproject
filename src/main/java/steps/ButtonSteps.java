package steps;

import Help.PageFactory;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.WebElement;

public class ButtonSteps {
    @Когда("^полдьзователь нажимает кнопку (.*)$")
    public void buttonClick(String button) throws InterruptedException {
        WebElement webElement = PageFactory.getInstance().getCurrentPage().getElementByTitle(button);
        webElement.click();
        Thread.sleep(45000);
    }
}
