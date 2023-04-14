package Test;

import Pages.HomePage;
import Pages.WallpaperPage;
import TestBase.WebTestBase;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class WallpaperTest extends WebTestBase {
    public HomePage homePage;
    public WallpaperPage wallpaperPage;

    WallpaperTest() {
        super();
    }

    @BeforeMethod
    public void beforemethod(){
        initialization();
        homePage = new HomePage();
        wallpaperPage = new WallpaperPage();
    }

    @Test
    public void verifyValidation(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeadvertise();
        WallpaperPage wallpaperPage = PageFactory.initElements(driver, WallpaperPage.class);
        wallpaperPage.fillEnquiryForm(
                prop.getProperty("name"),
                prop.getProperty("email"),
                prop.getProperty("mobile"),
                prop.getProperty("pincode")
        );
        softAssert.assertEquals("","","Your name should be match");
        softAssert.assertAll();
    }

    @AfterMethod
    public void aftermethod(){
        driver.close();
    }
}
