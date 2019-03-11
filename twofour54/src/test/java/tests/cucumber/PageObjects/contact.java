package tests.cucumber.PageObjects;

import Screens.BaseScreen;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;


public class contact {

    public static WebElement element = null;

    private Wait<WebDriver> mFluentWait(WebDriver driver) {
        return new FluentWait<>(driver).withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(600)).ignoring(NoSuchElementException.class);
    }



    public static String PhotoGraphClick="//a[@title='Edit']";

    //*Dropdown Selection*//
    public static String Salutation = "//select[@id='ctrlElementoForm_11395_288956_3_Mr_Mrs']";
    public static String Gender = "//select[@id='ctrlElementoForm_11395_288875_3_Gender']";
    public static String Religion = "//select[@id='ctrlElementoForm_11395_344421_1_Religion_Prefix']";
    public static String MaritalStatus = "//select[@name='ctrlElementoForm$11395_288884_3_Marital_Status']";
    public static String Caste = "//select[@name='ctrlElementoForm$11395_288900_1_Caste']";
    public static String Nationality = "//select[@id='ctrlElementoForm_11395_288898_1_Nationality_New']";
    public static String UAEMobile = "//select[@id='ctrlElementoForm_11395_288924_3_UAE_Tel_Code']";
    public static String PhoneNo = "//select[@id='ctrlElementoForm_11395_288960_1_Country_Telephone_Codes_Prefix']";
    public static String Passport = "//select[@id='ctrlElementoForm_11395_288881_1_Passport_Issue_Country']";


    public static WebElement PhotoGraphClick(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@title='Edit']"));

        return element;

    }


    public static WebElement UploadPhoto(WebDriver driver) {

        element = driver.findElement(By.xpath("//*[@id='selecFile']"));

        return element;

    }

    public static WebElement UploadClick(WebDriver driver) {

        element = driver.findElement(By.xpath("//div[@id='overInput']/div[2]/div"));

        return element;

    }

    public static WebElement SaveImage(WebDriver driver) {

        element = driver.findElement(By.xpath(" //a[@title='Save Image']"));

        return element;

    }

    public static WebElement FirstName(WebDriver driver) {

        element = driver.findElement(By.xpath(" //input[@id='ctrlElementoForm_11395_288866_3_First_Name']"));

        return element;

    }

    public static WebElement LastName(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoForm_11395_288868_3_Last_Name']"));

        return element;

    }

    public static WebElement MotherName(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoForm_11395_288882_3_Mothers_Name']"));

        return element;

    }

    public static WebElement Passport(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoForm_11395_288879_3_B!_A!_PassPort_Number']"));

        return element;

    }

    public static WebElement PlaceofBirth(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoForm_11395_288929_3_Place_of_Birth']"));

        return element;

    }

    public static WebElement UAEMobileNo(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoForm_11395_288890_3_UAE_Number']"));

        return element;

    }

    public static WebElement PhoneNoOrigin(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoForm_11395_288891_3_C!_B!_A!_Tel_Number']"));

        return element;

    }
}