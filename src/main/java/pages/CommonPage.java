package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.CommonSteps;

import java.util.List;

public class CommonPage {
    public CommonPage() {
        PageFactory.initElements(CommonSteps.getDriver(), this);
    }

    @FindBy(xpath = "//a")
    List<WebElement> href;


    public void hrefClick(String hrefEl) {
        for (WebElement ele : href) {
            if(ele.getText().equals(hrefEl)){
                ele.click();
                return;
            }
        }
    }
}