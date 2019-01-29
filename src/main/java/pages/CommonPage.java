package pages;

import Help.ElementTitle;
import Help.Page;
import Help.PageEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@PageEntry(title = "Главная страница")
public class CommonPage extends Page {
    public CommonPage() {
        PageFactory.initElements(Help.PageFactory.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()='Видео']")
    @ElementTitle("Видео")
    WebElement logo;
}
