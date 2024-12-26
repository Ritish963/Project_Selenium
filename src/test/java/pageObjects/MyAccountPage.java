package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public WebDriver driver;
    public MyAccountPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//h2[text()=\"My Account\"]")
    WebElement myAccount;

    public boolean returnAccount()
    {
        return myAccount.isDisplayed();
    }
}
