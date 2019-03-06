package tests.cucumber.steps;

import Screens.BaseScreen;
import Screens.ContactScreen;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.event.InputEvent;



public class contactSteps  {
    private WebDriver driver = BaseScreen.driver;

    @Before
    public void setupLoginSteps2() {
        System.out.println("Cucumber Before-logins.java-test-cucumber");
     //   setupCucumber2();
        //contactScreen = new ContactScreen(driver);
    }


   /* Wait<WebDriver> Wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(100))
            .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);*/

    @Given("^Hover MyContacts add New Contacts$")
    public void hoverMyContactsAddNewContacts() throws Throwable {

        Thread.sleep(9000);


        Robot rb = new Robot();
        rb.mouseMove(175, 500);

        Thread.sleep(4000);
        Robot rb1 = new Robot();
        rb1.mouseMove(240, 500);

        try {
            rb1.mousePress(InputEvent.BUTTON1_MASK);
            rb1.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(20000);



        String Parent_Window = driver.getTitle();
        //getWindowHandle();
        System.out.println(Parent_Window);
        // Switching from parent window to child window
        for (String Child_Window : driver.getWindowHandles()) {
            driver.switchTo().window(Child_Window);
        }
        Thread.sleep(4000);


        driver.findElement(By.xpath("//*[@id='ctrlElementoForm_11395_288866_3_First_Name']")).sendKeys("hello");
    }

    @And("^Upload PhotoGraph & Enter Basic Information$")
    public void uploadPhotoGraphEnterBasicInformation() throws Throwable {


        // waitForNumberofWindowsToEqual(2);//this method is for wait


        /*String parent = driver.getWindowHandle();
        System.out.println(parent);
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> I1 = s1.iterator();
        while (I1.hasNext()) {
            String Child_window = I1.next();
            if (!parent.equals(Child_window)) {
                driver.switchTo().window(Child_window);
                System.out.println(driver.switchTo().window(Child_window).getTitle());
            }
        }*/




       /* WebElement we = driver.findElement(By.linkText("ctrlElementoForm$ctl995"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", we);
        we.click(); //contact.SelectFile(driver).click();*/

        // WebElement er=driver.findElement(By.xpath("//*/a[@class='grideditbutton']"));
        /*try {
            if (er.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");

                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", er);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }*/
    }


}





