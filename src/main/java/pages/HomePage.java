package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObjects {

    protected WebDriver driver;

    @FindBy
    WebElement e;

    public void HomePage(WebDriver driver) {
        this.driver = driver;
    }


}
