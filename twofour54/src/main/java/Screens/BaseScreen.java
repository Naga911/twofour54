package Screens;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BaseScreen {

    public static WebDriver driver;
    protected static WebDriverWait wait;

    public BaseScreen(WebDriver driver) {
        this.driver = driver;
//        wait = new WebDriverWait(driver, 15);
    }

    protected void waitAndClick(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    protected void clicks(By xpath) {
        waitVisibility(xpath);
        driver.findElement(xpath).click();
    }

    protected void click(By by) {
        waitVisibility(by);
        driver.findElement(by).click();
    }

    protected void hideKeyboard() {
        driver.navigate().back();
    }

    protected boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected List<WebElement> waitAndFindElements(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    protected WebElement waitAndFindElement(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected String getText(By by) {
        return waitAndFindElement(by).getText();
    }

    protected void sendText(String arg1, String text) {

        System.out.println(arg1 + text);
        driver.findElement(By.xpath(arg1)).sendKeys(text);
    }

    protected void assertEquals(String actual, String expected) {
        Assert.assertEquals(actual, expected, "Two texts are not equal!" + "Actual: " + actual + " Expected: " + expected);
    }

    protected void waitVisibility(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


    protected void sendKey(By xpath) {
        waitAndFindElement(xpath).sendKeys();
    }

    protected void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
