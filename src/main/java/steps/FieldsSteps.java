package steps;

import Help.Find;
import Tools.PageFactory;
import cucumber.api.java.ru.Когда;
import org.openqa.selenium.WebElement;

public class FieldsSteps {
    @Когда("^пользователь заполняет поле\"(.*?)\" значением\"(.*?)\"$")
    public void fillField(String title, String field) {
        WebElement webElement = Find.findElemntByTitle(title);
        webElement.sendKeys(field);
    }

    @Когда("^пользователь заполняет во фреймe \"(.*?)\" поле\"(.*?)\" значением\"(.*?)\"$")
    public void fillFieldInFrame(String frameTitle, String title, String field){
        WebElement frameElement = Find.findElemntByTitle(frameTitle);
        PageFactory.getDriver().switchTo().frame(frameElement);
        WebElement webElement = Find.findElemntByTitle(title);
        webElement.sendKeys(field);
        PageFactory.getDriver().switchTo().defaultContent();
    }
}
