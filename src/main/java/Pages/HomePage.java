package Pages;

import TestBase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebTestBase {

    @FindBy(xpath ="//button[@id='onetrust-accept-btn-handler']")
    WebElement firstAdvertise;

    @FindBy(xpath ="//div[@id='__st_fancy_popup']//iframe[@class='__st_preview_frame_bpn']")
    WebElement cookiePopupFrame;

    @FindBy(xpath = "//input[@value='Allow']")
    WebElement allowButton;

    @FindBy(xpath = "//a[@data-target='#PAINTSCOLOURS']")
    private WebElement paintAndColorsMenu;

    @FindBy(xpath = "//a[text()='Wallpapers']")
    private WebElement wallpapersSubMenu;


    public HomePage(){
        PageFactory.initElements(driver,this);
    }

//    public void clickOnLoginbtn(){
//        homeLoginbtn.click();
//    }

    public void closeadvertise(){
        firstAdvertise.click();
        // Switch to the cookie popup iframe
        driver.switchTo().frame(cookiePopupFrame);

        // Click on the "Allow" button
        allowButton.click();

        // Switch back to the main content
        driver.switchTo().defaultContent();

        paintAndColorsMenu.click();
        wallpapersSubMenu.click();

    }
}
