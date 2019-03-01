package utilities;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class StartApp {

    private static AndroidDriver driver;


    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Moto Turbo");
        capabilities.setCapability(CapabilityType.VERSION, "6.0.1");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
        capabilities.setCapability("appActivity", "com.amazon.mShop.android.home.HomeActivity");
        driver = new AndroidDriver(new URL("http://192.168.12.78:4723/wd/hub"), capabilities);
        //driver = new AndroidDriver(new URL("http://192.168.190.1:5000/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
    }

    @Test
    public void Search() {

        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);


        try {
            System.out.println("Amazon site launched successfully");
            // Enter search text in the search text box

            driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'skip_sign_in_button')]")).click();

            WebElement Search = driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'rs_search_src_text')]"));
            Search.sendKeys("ch2573");

            driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'iss_search_dropdown_item_text')]")).click();

            WebElement item = driver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'rs_results_image')]"));
            item.click();
            //driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'loc_ux_gps_enter_pincode')]")).click();

            //driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'loc_ux_update_pin_code')]")).click();

            WebElement Usemyloc = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'loc_ux_gps_auto_detect')]"));

            try {
                if (Usemyloc.isEnabled()) {
                    Usemyloc.click();
                    driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'permission_allow_button')]")).click();
                    Usemyloc.click();

                    //item.click();
                    System.out.println("hello2");
                    // Get the size of screen.
                    Dimension size = driver.manage().window().getSize();
                    System.out.println("Size" + size);


                    // Find horizontal point where you wants to swipe. It is in middle of
                    // screen width.

                    System.out.println(size);

                    //Find swipe start and end point from screen's with and height.
                    //Find starty point which is at bottom side of screen.


                   /* int useX = (int) ((double) size.getWidth() * 2);
                    int useY = (int) ((double) size.getHeight() * 2);
                    TouchActions actions = new TouchActions(driver);
                    actions.down(useX, useY).perform();
                    int endX = 0;
                    int endY = (int) (useY * -1 * 0.75);
                    actions.move(endX, endY).perform();
                    actions.up(endX, endY).perform();*/
                    Thread.sleep(6000);
                    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
//Perform the action on the element
                    // element.click();

                    driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'add-to-cart-button')]")).click();

                }





            }catch(Exception e1)
            {
                System.out.println(e1);
            }
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }

    @AfterTest
    public void End() {

        //driver.quit();
    }
}