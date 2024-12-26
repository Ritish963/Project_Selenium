package testCases;

import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass{


    @Test(groups={"regression","master"})
    public void Login()
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccount();
        homePage.loginClick();

        logger.info("open login page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(p.getProperty("username"));
        loginPage.setPassword(p.getProperty("password"));
        loginPage.clickLogin();

        MyAccountPage myAccountPage= new MyAccountPage(driver);
      boolean value =  myAccountPage.returnAccount();
      if(value)
      {
          logger.info("login successfully");
      }


    }
}
