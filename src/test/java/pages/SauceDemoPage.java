package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage
{
    public SauceDemoPage()
    {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "user-name")
    public WebElement userName;


    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy (xpath = "//*[text()='Sauce Labs Backpack']")
    public WebElement ilkUrunIsim;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public WebElement addToCart;

    @FindBy(className = "shopping_cart_link")
    public WebElement basket;

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    public WebElement eklenenUrun;


}
