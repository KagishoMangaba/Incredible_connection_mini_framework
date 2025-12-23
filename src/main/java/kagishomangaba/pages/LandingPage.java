package kagishomangaba.pages;

import kagishomangaba.base.AbstractComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LandingPage extends AbstractComponents {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void searchProduct(String productName) {
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.id("search")), productName).build().perform();
        driver.findElement(By.cssSelector("button[title='Search']")).click();
    }



    public void goTo() {
        driver.get("https://www.incredible.co.za/");
    }
}





