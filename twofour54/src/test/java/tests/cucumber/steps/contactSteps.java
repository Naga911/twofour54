package tests.cucumber.steps;

import Screens.BaseScreen;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tests.cucumber.PageObjects.contact;
import utilities.Generic;

public class contactSteps {
    WebDriver driver = BaseScreen.driver;

    @Given("^Hover MyContacts add New Contacts$")
    public void hoverMyContactsAddNewContacts() throws Throwable {

        WebElement login = contact.AddContact(driver);
        try {
            Generic.hoverWebelement(login);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}




