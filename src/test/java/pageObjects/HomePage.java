package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  BasePage{

    WebDriver driver;

    public HomePage(WebDriver driver)
    {
        super(driver);
    }


    @FindBy(xpath="//span[text()=\"My Account\"]")
    WebElement myAccount;


    @FindBy(xpath="//a[text()=\"Register\"]")
    WebElement registerBtn;

    @FindBy(xpath="//a[text()=\"Login\"]")
    WebElement loginBttn;


    public void clickAccount()
    {
        myAccount.click();
    }

    public void clickRegister()
    {
       registerBtn.click();
    }

    public void loginClick()
    {
        loginBttn.click();
    }


}
