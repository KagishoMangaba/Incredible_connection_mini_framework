package kagishomangaba.pages;

import kagishomangaba.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BasePage {

    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public CataloguePage searchProduct(String productName) {
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.id("search")), productName).build().perform();
        driver.findElement(By.cssSelector("button[title='Search']")).click();
        return new CataloguePage(driver);
    }



    public void goTo() {
        driver.get("https://www.incredible.co.za/");
    }
}





