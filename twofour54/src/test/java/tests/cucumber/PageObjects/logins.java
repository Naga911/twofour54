package tests.cucumber.PageObjects;

import Screens.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class logins {

    private static WebElement element = null;



    public static WebElement username(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoFormulario_Log_930_22104_Login']"));

        return element;

    }

    public static WebElement password(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoFormulario_Pass_930_22104_Login']"));

        return element;

    }

    public static WebElement submit(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[contains(text(),'LOGIN')]"));

        return element;

    }
}