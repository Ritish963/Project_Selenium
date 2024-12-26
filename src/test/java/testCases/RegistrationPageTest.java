package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;


public class RegistrationPageTest extends BaseClass {

    @Test(groups={"sanity","master"})
    public void registration()
    {
        logger.info("opening home page");
        HomePage homePage = new HomePage(driver);
        homePage.clickAccount();
        homePage.clickRegister();
        logger.info("enter registration details");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.setFirstName(randomString());
        registrationPage.setLastName(randomString());
        registrationPage.setEmail(randomString()+"@gmail.com");
        registrationPage.setPhone(randomNumber());

        String password = randomPassword();

        registrationPage.setPassword(password);
        registrationPage.setConfirm(password);
        registrationPage.clickCheckBox();
        registrationPage.clickSubmit();
        String str = registrationPage.getConfirmMessage();
        if(str.equals("Your Account Has Been Created!!"))
        {
            logger.info("Account created");
        }
        else
        {
            logger.error("error");
        }

    }
}
