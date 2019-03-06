package tests.cucumber.steps;

import Screens.ContactScreen;
import Screens.SplashScreen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.ThreadLocalDriver;

public class BaseSteps {

    protected SplashScreen splashScreen = null;
    protected ContactScreen contactScreen = null;
    // protected LoginScreen loginScreen = null;


    protected WebDriverWait wait;

    //Screen Classes Initialization
    protected void setupCucumber1() {

        System.out.println("Cucumber Base Test Before-logins.java-test-cucumber");
//       wait = new WebDriverWait(ThreadLocalDriver.getTLDriver(), 10);
        splashScreen = new SplashScreen(ThreadLocalDriver.getTLDriver());

        //    loginScreen = new LoginScreen(ThreadLocalDriver.getTLDriver());


    }
    protected  void setupCucumber2()
    {
        contactScreen = new ContactScreen(ThreadLocalDriver.getTLDriver());
    }

    protected void teardown() {
        //ThreadLocalDriver.getTLDriver().quit();
    }
}
