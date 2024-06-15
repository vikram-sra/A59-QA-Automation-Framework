package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage {

    //CONSTRUCTOR
    public LoginPage(WebDriver givenDriver){
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
    public LoginPage provideEmail(String email){
        emailField.sendKeys(email);
        //findElement(emailField).sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password){
        passwordField.sendKeys(password);
        //findElement(passwordField).sendKeys();
        return this;
    }
    public LoginPage clickSubmit(){
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

