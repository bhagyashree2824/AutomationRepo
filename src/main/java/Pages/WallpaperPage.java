package Pages;

import TestBase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WallpaperPage extends WebTestBase {

    @FindBy(id = "enquire-name")
    WebElement enquiryNameTextBox;

    @FindBy(id = "enquire-email")
    WebElement enquiryEmailTextBox;

    @FindBy(id = "enquire-mobile")
    WebElement enquiryMobileTextBox;

    @FindBy(id = "enquire-pincode")
    WebElement enquiryPincodeTextBox;

    @FindBy(xpath = "//*[@id='pdp-request-call-back-form']/div[2]/div[2]/button")
    WebElement enquiryNowBtn;

    public WallpaperPage(){
        PageFactory.initElements(driver,this);
    }

    public void fillEnquiryForm(String username, String emailid, String mobileno, String pincode) {
        enquiryNameTextBox.sendKeys(username);
        enquiryEmailTextBox.sendKeys(emailid);
        enquiryMobileTextBox.sendKeys(mobileno);
        enquiryPincodeTextBox.sendKeys(pincode);
        enquiryNowBtn.click();
    }
}
