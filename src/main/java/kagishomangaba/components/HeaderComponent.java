package kagishomangaba.components;

import kagishomangaba.base.AbstractComponents;
import kagishomangaba.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent  extends AbstractComponents {

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = ".action.showcart" )
    WebElement cartHeader;

    ShoppingCartPage goToCart() {
        waitForElementToBeClickable(cartHeader , "cart button");
        return new ShoppingCartPage(driver );



    }

}
