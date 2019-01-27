package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.CommonSteps;

public class CommonPage {
    public CommonPage() {
        PageFactory.initElements(CommonSteps.getDriver(), this);
    }
    @FindBy(xpath = "//a[@data-id='marke']")
    WebElement buttonMarket;

    public void buttonSt(){
        buttonMarket.click();
    }
}