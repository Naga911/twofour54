package utilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SimpleEmulatorCalcTest {

    public WebDriver driver;

    @BeforeTest
    public void setUp() throws Exception {


        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("browserName", "Android");
        capabilities.setCapability("platformVersion", "7.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
        capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
        driver = new RemoteWebDriver(new URL("http://192.168.12.78:4723/wd/hub"), capabilities);
        //driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void bad() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        System.out.println("I came here");
        driver.findElement(By.xpath("//android.widget.Button[@index='7']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.EditText[@text='Search']"))));
        driver.findElement(By.xpath("//android.widget.EditText[@text='Search']")).sendKeys("boots for men");
        wait.until(ExpectedConditions.visibilityOf( driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']"))));
        driver.findElement(By.xpath("//android.widget.LinearLayout[@index='1']")).click();
        //WebElement er = driver.findElement(By.xpath("//android.widget.TextView[@text='Hotels']"));

        driver.findElement(By.xpath("//android.widget.Button[@index='1']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//android.widget.Button[@index='2']"))));
        driver.findElement(By.xpath("//com.android.packageinstaller[@resource-id='permission_allow_button']")).click();

    }
    // Click on CLR button.


    //OR you can use bellow given syntax to click on CLR/DEL button.
    //driver.findElements(By.className("android.view.View")).get(1).findElements(By.className("android.widget.Button")).get(0).click();

    // Click on number 2 button.
        /*driver.findElement(By.className("android.widget.Button[@index='1']")).click();

        
        // Click on + button.
        driver.findElement(By.className("android.widget.Button[@index='3']")).click();

        // Click on number 5 button.
        driver.findElement(By.className("android.widget.Button[@index='2']")).click();

        // Click on = button.
        driver.findElement(By.className("android.widget.Button[@text='=']")).click();

        // Get result from result text box of calc app.
        String result = driver.findElement(By.className("android.widget.EditText")).getText();
        System.out.println("Number sum result is : " + result);
        driver.quit();*/
}
