package providedTestCases;

//import org.junit.After;
import org.junit.Assert;
//import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddProductToCartConfirmationTest {

    private WebDriver driver;
    private WebDriverWait myWaitVar;

//    @Before
    public void setUp(){
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        myWaitVar = new WebDriverWait(driver,20);
    }

//    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void addProductToCartConfirmation(){

        //GIVEN---
        // Open the website
        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();
        Assert.assertTrue("Check if empty element is visible", driver.findElement(By.className("ajax_cart_no_product")).isDisplayed());

        //WHEN----
        //Click on the iPod Tag
        driver.findElement(By.cssSelector("a[title='More about ipod']")).click();

        //AND-WHEN---
        //Click on the iPod NANO
        driver.findElement(By.xpath("//a[contains(text(),'iPod Nano')]")).click();

        //AND-WHEN----
        //Add to cart
        driver.findElement(By.id("add_to_cart")).click();

        //THEN----
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("i.icon-check")));
        Assert.assertTrue("Check if empty element is visible",
                driver.findElement(By.cssSelector("i.icon-check")).isDisplayed());

        //BUT-THEN----
        myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[title='Proceed to checkout']")));
        Assert.assertTrue("Check if the button to be taken to the checkout is shown",
                driver.findElement(By.cssSelector("a[title='Proceed to checkout']")).isDisplayed());
    }
}
