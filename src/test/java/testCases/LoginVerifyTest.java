package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviderClass;

public class LoginVerifyTest extends BaseClass {

    @Test(dataProvider = "data" ,dataProviderClass = DataProviderClass.class,groups = {"smoke","master"})
    public void LoginTest(String username,String password)
    {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccount();
        homePage.loginClick();

        logger.info("open login page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(username);
        loginPage.setPassword(password);
        loginPage.clickLogin();

//        MyAccountPage myAccountPage= new MyAccountPage(driver);
//        boolean value =  myAccountPage.returnAccount();
//        if(value)
//        {
//            logger.info("login successfully");
//        }


    }
}
