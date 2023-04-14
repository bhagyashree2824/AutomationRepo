package Test;

import Pages.HomePage;
import Pages.LoginPage;
import TestBase.WebTestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends WebTestBase {

    public HomePage homePage;
    //public LoginPage loginPage;

    LoginTest(){
        super();
    }

    @BeforeMethod
    public void beforemethod(){
        initialization();
        homePage = new HomePage();
        //loginPage = new LoginPage();
    }

    @Test
    public void verifyWithValidLoginMobile(){
        homePage.closeadvertise();

// Verify that the page title is correct
        String expectedTitle = "Range of Wall Coverings & Interior Wallpaper for Walls - Asian Paints";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterMethod
    public void aftermethod(){
        driver.close();
    }
}


