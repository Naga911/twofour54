package tests.cucumber.steps;

import Screens.BaseScreen;
import Screens.ContactScreen;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import tests.cucumber.PageObjects.contact;
import tests.cucumber.PageObjects.logins;
import utilities.Generic;

import java.awt.*;
import java.time.Duration;
import java.util.List;
import java.awt.event.InputEvent;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("Duplicates")


public class contactSteps {
    private static WebDriver driver = BaseScreen.driver;

    public static WebDriverWait wait = new WebDriverWait(driver, 20);


    @Before
    public void setupLoginSteps2() {
        System.out.println("Cucumber Before-logins.java-test-cucumber");
        //   setupCucumber2();
        //contactScreen = new ContactScreen(driver);
        Generic.waitForLoad(driver);
    }


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


        // driver.findElement(By.xpath("//*[@id='ctrlElementoForm_11395_288866_3_First_Name']")).sendKeys("hello");
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

   /* @Then("^Enter Mandatory Fields such as ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*) & ([^\"]*)$")
    public void enterMandatoryFieldsSuchAsFirstNameLastNameMotherSNamePassportPlaceOfBirthUAEMobileNoPhoneNoOrigin(String FirstName, String LastName, String MotherName, String Passport, String PlaceofBirth, String UAEMobileNo, String PhoneNoOrigin) throws Throwable {
    }*/

    @Then("^Enter Mandatory Fields such as ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*), ([^\"]*)$")
    public void enterMandatoryFieldsSuchAsFirstNameLastNameMotherSNamePassportPlaceOfBirthUAEMobileNoPhoneNoOriginDOBPassportIDatePassportEDate(String FirstName, String LastName, String MotherName, String Passport, String PlaceofBirth, String UAEMobileNo, String PhoneNoOrigin, String DOB, String PassportIDate, String PassportEDate) throws Throwable {

        wait.until(ExpectedConditions.visibilityOf(contact.PhotoGraphClick(driver))).click();

        // BaseScreen.waitAndClick(By.xpath(contact.PhotoGraphClick));
        //wait.until(ExpectedConditions.visibilityOfElementLocated((By) contact.PhotoGraphClick(driver))).click();
        //contact.PhotoGraphClick(driver).click();
        Thread.sleep(3000);


        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);


        driver.switchTo().frame(5);


        Thread.sleep(8000);
        contact.UploadClick(driver).click();
        Thread.sleep(8000);

        Runtime.getRuntime().exec("C:\\My projects\\B22.exe");
        Thread.sleep(8000);

        //wait.until(ExpectedConditions.visibilityOf(contact.SaveImage(driver))).click();
        contact.SaveImage(driver).click();
        driver.switchTo().defaultContent();
        //wait.until(ExpectedConditions.visibilityOf(contact.FirstName(driver))).click();
        contact.FirstName(driver).sendKeys(FirstName);
        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOf(contact.LastName(driver))).click();
        contact.LastName(driver).sendKeys(LastName);
        Thread.sleep(1000);
        contact.MotherName(driver).sendKeys(MotherName);
        Thread.sleep(1000);
        contact.Passport(driver).sendKeys(Passport);
        Thread.sleep(1000);
        contact.PlaceofBirth(driver).sendKeys(PlaceofBirth);
        Thread.sleep(1000);
        contact.UAEMobileNo(driver).sendKeys(UAEMobileNo);
        Thread.sleep(1000);
        contact.PhoneNoOrigin(driver).sendKeys(PhoneNoOrigin);
        Thread.sleep(2000);


        //****Selection of Salutation
        Generic.webb(contact.Salutation);
        Thread.sleep(7000);

        //****Selection of Gender//
        Generic.webb(contact.Gender);
        Thread.sleep(7000);

        //****Selection of Religion//
        Generic.webb(contact.Religion);
        Thread.sleep(7000);

        //****Selection of Marital Status//
        Generic.webb(contact.MaritalStatus);
        Thread.sleep(7000);

        //****Selection of Nationality//
        Generic.webb(contact.Nationality);
        Thread.sleep(7000);

        //****Selection of Caste//
        Generic.webb(contact.Caste);
        Thread.sleep(7000);

        //****Selection of PhoneNumber//
        Generic.webb(contact.PhoneNo);
        Thread.sleep(7000);

        //****Selection of UAE Mobile #//
        Generic.webb(contact.UAEMobile);
        Thread.sleep(7000);

        //****Selection of Passport Issue Country//
        Generic.webb(contact.Passport);
    }
}





