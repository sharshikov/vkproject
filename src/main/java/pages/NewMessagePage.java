package pages;

import Tools.Page;
import interfaces.ElementTitle;
import interfaces.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageEntry(title = "Новое сообщение")
public class NewMessagePage extends Page {
    public NewMessagePage(){
        PageFactory.initElements(Tools.PageFactory.getDriver(),this);
    }

    @FindBy(xpath="//body[@id='tinymce']")
    @ElementTitle(value = "Тело письма")
    WebElement bodyMessage;

    @FindBy(xpath="//iframe")
    @ElementTitle(value = "фрейм письма")
    WebElement frame;

    @FindBy(xpath="//textarea[@data-original-name='To']")
    @ElementTitle(value = "Кому")
    WebElement toInput;

    @FindBy(xpath="//div[@data-name='send']")
    @ElementTitle(value = "Отправить")
    WebElement toButton;
}
