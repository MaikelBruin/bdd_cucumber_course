package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactUsPage {

    private WebDriver driver;

    @FindBy(css = "input#email")
    private WebElement emailTextField;

    @FindBy(css = "input#id_order")
    private WebElement orderIdTextField;

    @FindBy(css = "textarea#message")
    private WebElement messageTextField;

    @FindBy(css = "button#submitMessage")
    private WebElement sendButton;

    @FindBy(css = ".alert.alert-danger>ol>li")
    private WebElement invalidEmailElement;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;

        // This call sets the WebElement fields.
        PageFactory.initElements(driver, this);
    }
    //TODO fix Select
    public void fillInContactForm(String subject, String email, String orderID, String message){
        Select subjectHeading = new Select(driver.findElement(By.cssSelector("select#id_contact")));
        subjectHeading.selectByVisibleText("Customer service");
        emailTextField.sendKeys(email);
        orderIdTextField.sendKeys(orderID);
        messageTextField.sendKeys(message);
        sendButton.click();
    }

    public String validationMessage(){
        WebElement alertMessageElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".alert.alert-success")));

        return alertMessageElement.getText();
    }

    public String getInvalidEmailMessage(){
        return invalidEmailElement.getText();
    }

    public void fillInEmailAndClick(String email){
        emailTextField.sendKeys(email);
        orderIdTextField.click();
    }
}
