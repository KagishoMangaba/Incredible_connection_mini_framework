package kagishomangaba.pages;

import kagishomangaba.Abstractcomponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CataloguePage extends AbstractComponents {

    private WebDriver driver;

    public CataloguePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver , this);
    }





}

