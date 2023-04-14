package Pages;

import TestBase.WebTestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WebTestBase {

    @FindBy(id = "loginMobile")
    WebElement inputLogin;

    @FindBy(xpath = "//button[@class='modal__variant-login--submit'")
    WebElement submitBtn;

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    public void Login(String phone){
        inputLogin.sendKeys(phone);
        submitBtn.click();
    }

}
