package stepdefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyStepdefs {

    private WebDriver driver;
    private WebDriverWait myWaitVar;


    @Given("^I am on the Polteq Webshop$")
    public void iAmOnThePolteqWebshop()  {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://techblog.polteq.com/testshop/index.php");
    }

    @And("^The homepage displays products$")
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

}
