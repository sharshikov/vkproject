package Help;

import Tools.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Find {
    public static WebElement findElemntByTitle(String title) {
        WebElement element;
        try {
            element = PageFactory.getInstance().getCurrentPage().getElementByTitle(title);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
        return element;
    }

    public static WebElement findElemntInFrame(String title){
        (new WebDriverWait(PageFactory.getDriver(), 10))
                .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame"));
               return PageFactory.getInstance().getCurrentPage().getElementByTitle(title);
    }
}
