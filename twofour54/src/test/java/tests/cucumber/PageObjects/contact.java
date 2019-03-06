package tests.cucumber.PageObjects;

import Screens.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class contact {

    private static WebElement element = null;



    public static WebElement PhotoGraphClick(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@title='Edit']"));

        return element;

    }

    public static WebElement SelectFile(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id='selecFile']"));

        return element;

    }
}