package tests.cucumber.steps;

import Screens.BaseScreen;
import Screens.ContactScreen;
import Screens.SplashScreen;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.Base.BaseUtil;
import tests.BaseTest;
import tests.ThreadLocalDriver;
import tests.cucumber.PageObjects.logins;
import utilities.Generic;


public class LoginSteps  {

    private WebDriver driver = BaseScreen.driver;
    //SplashScreen splashScreen;


    @Before
    public void setupLoginSteps() {
        System.out.println("Cucumber Before-logins.java-test-cucumber");
        //  setupCucumber1();
        // splashScreen= new SplashScreen(ThreadLocalDriver.getTLDriver());
        Generic.waitForLoad(driver);
    }

    @Given("^([^\"]*) and ([^\"]*)$")
    public void usernameAndPassword(String username, String password) throws Throwable {
        System.out.println("Cucumber Given");


        logins.username(driver).sendKeys(username);
        logins.password(driver).sendKeys(password);

        logins.submit(driver).click();


        //   splashScreen.search(user,pass);
       /* System.out.println(System.getProperty("user.dir"));
        Reporter.addStepLog("hello");*/

    }
}

