package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPageFromFactory extends BasePage {

    //CONSTRUCTOR
    public LoginPageFromFactory(WebDriver givenDriver){
        super(givenDriver);
    }

    //LOCATORS
    //By emailField = By.cssSelector("input[type='email']");
    //By passwordField = By.cssSelector("input[type='password']");
    //By submitBtn = By.cssSelector("button[type='submit']");

    @FindBy(css = "input[type='email']")
    WebElement emailField;

    @FindBy(css = "input[type='password']")
    WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    WebElement submitBtn;

    //PAGE METHODS
    public LoginPageFromFactory provideEmail(String email){
        emailField.sendKeys(email);
        //findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPageFromFactory providePassword(String password){
        passwordField.sendKeys(password);
        //findElement(passwordField).sendKeys();
        return this;
    }
    public LoginPageFromFactory clickSubmit(){
        submitBtn.click();
        //findElement(submitBtn).click();
        return this;
    }

    public void login(){
        provideEmail("demo@class.com");
        providePassword("te$t$tudent");
        clickSubmit();
    }

}

