package TestBase;

import Utils.TestUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class WebTestBase {
    public static WebDriver driver;

    public static Properties prop;

    public WebTestBase() {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/properties/config.properties");
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void initialization() {
        String browserName =prop.getProperty("browsername");
        String name = prop.getProperty("name");
        String email = prop.getProperty("email");
        String mobile = prop.getProperty("mobile");
        String pincode = prop.getProperty("pincode");
        if(browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origin=*");
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new ChromeDriver(options);
        } else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new FirefoxDriver();
        } else if(browserName.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new EdgeDriver();
        } else if(browserName.equalsIgnoreCase("ie")){
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new InternetExplorerDriver();
        } else if(browserName.equalsIgnoreCase("safari")){
            System.setProperty("webdriver.safari.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new SafariDriver();
        } else {
            try{
                throw new Exception("Please Enter Valid Browser Name");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.navigate().to(prop.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT));
        driver.navigate().to("https://www.asianpaints.com/");
        driver.manage().deleteAllCookies();
    }
}
