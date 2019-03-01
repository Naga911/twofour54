package tests.cucumber.PageObjects;

import Screens.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class contact {

    private static WebElement element = null;

    WebDriver driver = BaseScreen.driver;

    public static WebElement AddContact(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id='ob_em_mc']/tbody/tr/td[3]"));

        return element;


    }
}