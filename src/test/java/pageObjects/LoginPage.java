package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(name="email")
    WebElement emailId;

    @FindBy(name="password")
    WebElement password;

    @FindBy(xpath="//input[@value='Login']")
    WebElement loginBtn;

    public void setEmail(String email)
    {
        emailId.sendKeys(email);
    }
    public void setPassword(String pwd) {
        password.sendKeys(pwd);
    }

    // Click the Login button
    public void clickLogin() {
        loginBtn.click();
    }


}
