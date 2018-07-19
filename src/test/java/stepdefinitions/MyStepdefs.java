package stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthenticationPage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyStepdefs {

    private WebDriver driver;
    private WebDriverWait myWaitVar;
    private By userInfo = By.className("header_user_info");

    @Given("^I am on the Polteq Webshop$")
    public void iAmOnThePolteqWebshop()  {
        // Write code here that turns the phrase above into concrete actions
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        myWaitVar = new WebDriverWait(driver,20);
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @Given("^The homepage displays products$")
    public void theHomepageDisplaysProducts() {
        // Write code here that turns the phrase above into concrete actions
        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();
        Assert.assertTrue("Check if empty element is visible", driver.findElement(By.className("ajax_cart_no_product")).isDisplayed());
    }


    @Then("^I can see the add to cart button for each product$")
    public void iCanSeeTheAddToCartButtonForEachProduct()   {
        // Write code here that turns the phrase above into concrete actions
    }


    @When("^I go to the IPODS page$")
    public void iGoToTheIPODSPage() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.cssSelector("a[title='More about ipod']")).click();
    }


    @And("^I go to the iPod Nano detail page$")
    public void iGoToTheIPodNanoDetailPage() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//a[contains(text(),'iPod Nano')]")).click();
    }


    @And("^I add the iPod Nano to the cart$")
    public void iAddTheIPodNanoToTheCart() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("add_to_cart")).click();
    }


    @Then("^I get a confirmation that the product is added to the shopping cart$")
    public void iGetAConfirmationThatTheProductIsAddedToTheShoppingCart() throws Throwable {
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.icon-check")));
        Assert.assertTrue("Check if empty element is visible",
                driver.findElement(By.cssSelector("i.icon-check")).isDisplayed());
    }

    @Then("^I should not be taken directly to my shopping cart$")
    public void i_should_not_be_taken_directly_to_my_shopping_cart() {
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Proceed to checkout']")));
        Assert.assertTrue("Check if the button to be taken to the checkout is shown",
                driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).isDisplayed());
    }

    @When("^I change the quantity to (\\d+)$")
    public void i_change_the_quantity_to(int arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I get a confirmation that the set quantity of products are added to the cart$")
    public void i_get_a_confirmation_that_the_set_quantity_of_products_are_added_to_the_cart() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I am able to see if the item is in stock$")
    public void i_am_able_to_see_if_the_item_is_in_stock() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am on the authentication page$")
    public void iAmOnTheLoginPage()  {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        homePage.clickLogIn();
    }

    @When("^I enter my credentials$")
    public void iEnterMyCredentials()  {
        // Write code here that turns the phrase above into concrete actions
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.login("maikel.bruin@polteq.com", "bootcamp");
    }

    @Given("^I have an account$")
    public void iHaveAnAccount() {
        // Write code here that turns the phrase above into concrete actions
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.clickCreateNewUser();
        authenticationPage.setNewUserMail("maikel.bruin@polteq.com");
        authenticationPage.isNewUserMailValid();

    }

    @Then("^I should see my user name in the header$")
    public void iShouldSeeMyUserNameInTheHeader()  {
        // Write code here that turns the phrase above into concrete actions
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals("Maikel Bruin", homePage.getUserInfo());


    }

    @When("^I enter my email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_enter_my_email_and_password(String email, String password) {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.login(email, password);
    }

    @Then("^I should see my user name \"([^\"]*)\" in the header$")
    public void i_should_see_my_user_name_in_the_header(String userName) {
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(userName, homePage.getUserInfo());
    }

    @When("^I create a new account with email \"([^\"]*)\"$")
    public void i_create_a_new_account_with_email(String email) {
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.setNewUserMail(email);
    }

    @Then("^I should see whether the email is \"([^\"]*)\"$")
    public void i_should_see_whether_the_email_is(String expectedValidity) {
        String actualValidity = "invalid";
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        if (authenticationPage.isNewUserMailValid()) {
            actualValidity = "valid";
        }
        Assert.assertEquals(expectedValidity, actualValidity);
    }

    @Then("^the product tags should be visible$")
    public void the_product_tags_should_be_visible(DataTable table) {
        List<String> tagList = table.asList(String.class);
        System.out.println(tagList);
        List<WebElement> elementList = driver.findElements(By.cssSelector("[class*='tag_level']"));
        List<String> actualTagList = new ArrayList<>();

        for (WebElement element : elementList) {
            actualTagList.add(element.getText());
        }
        System.out.println(actualTagList);

        for (String tag : tagList) {
            Assert.assertTrue(actualTagList.contains(tag));
        }
    }

}
