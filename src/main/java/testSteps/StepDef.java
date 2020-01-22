package testSteps;

import cucumber.api.java.en.*;
import driver.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepDef  {
      public static WebDriver driver;

    @Given("^customer is on login page$")
    public void customer_is_on_login_page() throws Throwable {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://ui.freecrm.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    String url= driver.getCurrentUrl();
        Assert.assertEquals("https://ui.freecrm.com/",url);
    }

    @When("^customer enters emailId and password$")
    public void customer_enters_emailId_and_password() throws Throwable {
        driver.findElement(By.name("email")).sendKeys("poonamr.1999@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Test@123");
    }

    @When("^customer clicked on login button$")
    public void customer_clicked_on_login_button() throws Throwable {
        driver.findElement(By.xpath("//div[@class='ui fluid large blue submit button']")).click();
    }

    @Then("^customer should be on homepage$")
    public void customer_should_be_on_homepage() throws Throwable {
        String title = driver.getTitle();
        Assert.assertEquals("Cogmento CRM",title);
    }
    @Then("^customer clicked on setting icon$")
    public void customer_clicked_on_setting_icon() throws Throwable {
        ////div[@class='menu transition']
        driver.findElement(By.cssSelector("#top-header-menu > div.right.menu > div.ui.buttons > div > i")).click();
        }

    @Then("^customer clicked on logout button$")
    public void customer_clicked_on_logout_button() throws Throwable {
        driver.findElement(By.linkText("Log Out")).click();
    }
}
