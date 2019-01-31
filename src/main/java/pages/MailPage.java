package pages;

import Tools.Page;
import interfaces.ElementTitle;
import interfaces.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageEntry(title = "Мэйл")
public class MailPage extends Page {
    public MailPage(){
        PageFactory.initElements(Tools.PageFactory.getDriver(), this);
    }
    @FindBy(xpath="//input[@name='login']")
    @ElementTitle(value = "Логин")
    WebElement loginInput;

    @FindBy(xpath="//input[@name='password']")
    @ElementTitle(value = "Пароль")
    WebElement passwordInput;

    @FindBy(xpath="//input[@value='Войти']")
    @ElementTitle(value = "Войти")
    WebElement inputSubmit;
}
