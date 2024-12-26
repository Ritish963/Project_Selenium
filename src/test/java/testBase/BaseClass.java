package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

public class BaseClass{

   public static WebDriver driver;
   public Logger logger;
   public Properties p;
    @BeforeClass(groups = {"sanity","smoke","regression","master"})
    @Parameters({"browser","os"})
    public void setUp(String browser,String os) throws IOException {
        FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);
        logger = LogManager.getLogger(this.getClass());
        if(p.getProperty("env_type").equals("local")) {
            switch (browser) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                default:
                    System.out.println("invalid browser");
                    return;
            }
        }
        if(p.getProperty("env_type").equals("remote"))
        {
            DesiredCapabilities des = new DesiredCapabilities();

            //OS
            if(os.equals("windows"))
            {
                des.setPlatform(Platform.WIN11);
            }
            else if(os.equals("linux"))
            {
                des.setPlatform(Platform.LINUX);
            }
            else
            {
                System.out.println("invalid platform");
                return;
            }


            //browser

            if(browser.equals("chrome"))
            {
                des.setBrowserName("chrome");
            }
            else if(browser.equals("edge"))
            {
                des.setBrowserName("MicrosoftEdge");
            }
            else if(browser.equals("firefox"))
            {
                des.setBrowserName("firefox");
            }
            else
            {
                System.out.println("no matching browser");
                return;
            }

            driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),des);


        }

        driver.manage().window().maximize();
        driver.get(p.getProperty("appUrl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass(groups = {"sanity","smoke","regression","master"})
    public void tearDown()
    {
        driver.quit();
    }

    public String randomString()
    {
        return RandomStringUtils.randomAlphabetic(5);
    }
    public String randomNumber()
    {
        return RandomStringUtils.randomNumeric(10);
    }

    public String randomPassword()
    {
        return RandomStringUtils.randomAlphabetic(3)+RandomStringUtils.randomNumeric(3);
    }

    public String captureScreen(String tname) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String targetFilePath = System.getProperty("user.dir") + "/screenshots/" + tname + "_" + timeStamp + ".jpeg";

        // Cast driver object to TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Take screenshot and store as a file format
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination where screenshot will be saved
        File targetFile = new File(targetFilePath);

        // Using renameTo method to store the screenshot in the desired location
        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }

}
