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


    public static String PhotoGraphClick = "//a[@title='Edit']";

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
    public static String BillingAccount = "//select[@id='ctrlElementoForm_11395_288949_1_Billing_account_prefix']";

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

    public static WebElement DOB(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@name='ctrlElementoForm$11395_288876_3_Date_of_Birth']"));

        return element;

    }

    public static WebElement PassportIDate(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoForm_11395_288878_3_Passport_Issue_Date']"));

        return element;

    }

    public static WebElement PassportEDate(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoForm_11395_288877_3_Passport_Expiry_Date']"));

        return element;

    }

    public static WebElement Email(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='ctrlElementoForm_11395_288892_3_Email']"));

        return element;

    }

    public static WebElement UploadPassport(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_11395_288905_3_Passport_Document_IntInd']"));

        return element;

    }

    public static WebElement UploadBrowser(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='uploader_browse']"));

        return element;

    }

    public static WebElement JobTitle(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_11395_288883_1_Job_Title_Boton']"));

        return element;

    }

    public static WebElement ProceedButton(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[contains(text(),'Proceed')]"));

        return element;

    }

    public static WebElement JobCode(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@name='85']"));

        return element;

    }

    public static WebElement NextButton(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@class='ApEst_51614211']"));

        return element;

    }

    public static WebElement NextButton2(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_11397_289002_NEXT']"));

        return element;

    }

    public static WebElement submit(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_11398_289029_SUBMIT']"));

        return element;

    }

    public static WebElement ClassofProcess(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='txtClaseProceso']"));

        return element;

    }

    public static WebElement ServiceDetails(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@id='txtAsunto']"));

        return element;

    }

    public static WebElement ProceedContact(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='cmdBuscar']"));

        return element;

    }

    public static WebElement GridClick(WebDriver driver) {

        element = driver.findElement(By.xpath("//div[@title='Clacket Media FZ LLC']"));

        return element;

    }


}