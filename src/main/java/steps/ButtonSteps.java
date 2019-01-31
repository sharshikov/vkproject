package steps;

import Help.Find;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.WebElement;

public class ButtonSteps {
    @Когда("^пользователь нажимает кнопку (.*?)$")
    public void buttonClick(String button) throws InterruptedException {
        WebElement webElement = Find.findElemntByTitle(button);
        webElement.click();
    }
}
