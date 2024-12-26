package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

    WebDriver driver;

    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//input[@id=\"input-firstname\"]")
    WebElement firstName;
    @FindBy(xpath="//input[@id=\"input-lastname\"]")
    WebElement lastName;
    @FindBy(xpath="//input[@id=\"input-email\"]")
    WebElement email;

    @FindBy(xpath="//input[@id=\"input-telephone\"]")
    WebElement phone;

    @FindBy(xpath="//input[@id=\"input-password\"]")
    WebElement password;
    @FindBy(xpath="//input[@id=\"input-confirm\"]")
    WebElement confirm;

    @FindBy(xpath="//input[@type=\"checkbox\"]")
    WebElement checkBox;

    @FindBy(xpath="//input[@value=\"Continue\"]")
    WebElement submit;

    @FindBy(xpath ="//h1[text()='Your Account Has Been Created!']")
            WebElement msgConfirmation;


    public void setFirstName(String fName)
    {
        firstName.sendKeys(fName);
    }
    public void setLastName(String lName) { lastName.sendKeys(lName); }

    public void setEmail(String emailAdd) { email.sendKeys(emailAdd); }

    public void setPhone(String phoneNumber) { phone.sendKeys(phoneNumber); }

    public void setPassword(String pwd) { password.sendKeys(pwd); }

    public void setConfirm(String confirmPwd) { confirm.sendKeys(confirmPwd); }

    public void clickCheckBox() { checkBox.click(); }

    public void clickSubmit() { submit.click(); }

    public String getConfirmMessage()
    {
        try {
            return msgConfirmation.getText();
        }
        catch(Exception e)
        {
            return e.getMessage();
        }
    }

}
