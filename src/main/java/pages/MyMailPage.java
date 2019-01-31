package pages;

import Tools.Page;
import interfaces.ElementTitle;
import interfaces.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageEntry(title = "Моя почта")
public class MyMailPage extends Page {
    public MyMailPage(){
        PageFactory.initElements(Tools.PageFactory.getDriver(),this);
    }
    @FindBy(xpath="//span[text()='Написать письмо']")
    @ElementTitle(value = "Написать письмо")
    WebElement createMessage;
}
