import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
//import pageFactory.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("vikramjit@testpro.io");
        Thread.sleep(2000);
        loginPage.providePassword("Vv3ZKxcI");
        Thread.sleep(2000);
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException{
        String expectedUrl = "https://qa.koel.app/";
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("invalid@testpro.io");
        Thread.sleep(2000);
        loginPage.providePassword("te$t$tudent");
        Thread.sleep(2000);
        loginPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); // https://qa.koel.app/
    }

   // @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        enterEmail("invalid@testpro.io");
        submit();
        // Expected Result
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }

    //@Test(dataProvider = "NegativeLoginTestData", dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        String expectedUrl = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

}