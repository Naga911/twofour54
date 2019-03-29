package tests.cucumber.steps;

import Screens.BaseScreen;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.cucumber.PageObjects.EmploymentVisaService;
import utilities.Generic;

import javax.lang.model.util.Elements;
import java.awt.*;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class EmploymentVisa {
    private static WebDriver driver = BaseScreen.driver;

    public static WebDriverWait wait = new WebDriverWait(driver, 20);

    @Before
    public void setupLoginSteps2() {
        System.out.println("Cucumber Before-logins.java-test-cucumber");
        //   setupCucumber2();
        //contactScreen = new ContactScreen(driver);
        //Generic.waitForLoad(driver);
    }


    @Given("^Hover Services, Select Employment, Residence visa Service$")
    public void hoverServicesSelectEmploymentResidenceVisaService() throws Throwable {

        //driver.manage().window().maximize();
        Thread.sleep(25000);
        System.out.println("i am here");

        Robot rb = new Robot();
        rb.mouseMove(175, 300);

        Thread.sleep(4000);
        Robot rb1 = new Robot();
        rb1.mouseMove(250, 300);
        try {
            rb1.mousePress(InputEvent.BUTTON1_MASK);
            rb1.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @And("^Click on Start Service$")
    public void clickOnStartService() throws Throwable {
        Thread.sleep(5000);
        EmploymentVisaService.StartService(driver).click();
    }

    @And("^Scroll, Access the service$")
    public void scrollAccessTheService() throws Throwable {
        ((JavascriptExecutor)
                driver).executeScript("arguments[0].scrollIntoView();", EmploymentVisaService.AcceptService(driver));
        Thread.sleep(2000);
        EmploymentVisaService.AcceptService(driver).click();
        Thread.sleep(3000);
        EmploymentVisaService.AccesstheService(driver).click();

        String Parent_Window = driver.getTitle();
        //getWindowHandle();
        System.out.println(Parent_Window);
        // Switching from parent window to child window
        for (String Child_Window : driver.getWindowHandles()) {
            driver.switchTo().window(Child_Window);
        }
        Thread.sleep(4000);


    }


    @And("^Click on the Search Icon,click on Proceed button$")
    public void clickOnTheSearchIconClickOnProceedButton() throws Throwable {
        System.out.println("Test");
        Thread.sleep(20000);
        WebElement er = wait.until(ExpectedConditions.visibilityOf(EmploymentVisaService.SearchButton(driver)));
        er.click();
        Thread.sleep(8000);

     /*   String Parent_Window = driver.getTitle();
        //getWindowHandle();
        System.out.println(Parent_Window);
        // Switching from parent window to child window
        for (String Child_Window : driver.getWindowHandles()) {
            driver.switchTo().frame(Child_Window);
        }*/
        /*Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow = it.next();
        String childWindow = it.next();
        System.out.println(childWindow);*/
        //driver.switchTo().frame(1);
        Thread.sleep(4000);



        /*String Parent_Window = driver.getCurrentUrl(); //getTitle();
        //getWindowHandle();
        System.out.println(Parent_Window);
        // Switching from parent window to child window
        for (String fr1 : driver.getWindowHandles()) {
            System.out.println(fr1);
            driver.switchTo().frame(fr1);

        }*/
        WebElement fr = driver.findElement(By.xpath("//body[@class='body-e']/div/table[1]//iframe"));
        driver.switchTo().frame(fr);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);
        Thread.sleep(4000);


        System.out.println("i switched to frame");


        // Code to pass the value in First name
        WebElement fn = driver.findElement(By.xpath("//html/body/form/div/div/div[4]/div/div/span/span/span/input[@id='503']"));
        fn.sendKeys("kirti");

        // Code to pass the value in Last name
        WebElement ln = driver.findElement(By.xpath("//html/body/form/div/div/div[4]/div/div/span/span/span/input[@id='504']"));
        ln.sendKeys("patel");

        //Code for Proceed button
        Thread.sleep(2000);
        EmploymentVisaService.ProeedButton(driver).click();
        Thread.sleep(20000);
        driver.switchTo().defaultContent();
        System.out.println("i switched back to  main frame ");
        String s = driver.findElement(By.xpath("//div[@id='ctrlElementoForm_17780_497808_Employment_visa']//span//span//span//strong[contains(text(),'Employment Visa')]")).getText();
        System.out.println(s);



        /*((JavascriptExecutor) driver).executeScript("arguments[0].click()", ee);
        ee.click();*/
        //
        //Thread.sleep(10000);
       /* String s = driver.findElement(By.cssSelector("body.body:nth-child(2) div.panel-filtro:nth-child(5) div:nth-child(1) div:nth-child(1) span:nth-child(1) span:nth-child(1) > span.label-normal")).getText();
        System.out.println(s);
        */
    }

    @And("^Select ([^\"]*),([^\"]*),([^\"]*),([^\"]*),([^\"]*),([^\"]*),([^\"]*),([^\"]*)$")
    public void selectCurrentVisaEmploymentVisaMedicalTestEmiratesIDResidenceVisaResVisaDurationHealthInsuranceHealthInsurancePlan(String CurrentVisa, String EmploymentVisa, String MedicalTest, String EmiratesID, String ResidenceVisa, String ResVisaDuration, String HealthInsurance, String HealthInsurancePlan) throws Throwable {
        WebDriverWait wait2 = new WebDriverWait(driver, 30);
        /*wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.CurrentVisaStatus(driver)));
        EmploymentVisaService.CurrentVisaStatus(driver).sendKeys(CurrentVisa);*/
        Thread.sleep(1000);
        //WebElement EmpVisaPriority = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497779_3_Service_Type_0']"));
        //EmpVisaPriority.click();

        //EmploymentVisa is a String which came from Feature File
       /* if (EmploymentVisa.equalsIgnoreCase("Normal")) {
            //wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.EmploymentVisaPriorityNormal(driver))).click();
            EmploymentVisaService.EmploymentVisaPriorityNormal(driver).click();
        } else if (EmploymentVisa.equalsIgnoreCase("Urgent")) {
            EmploymentVisaService.EmploymentVisaPriorityUrgent(driver).click();
        }
*/
        if (EmploymentVisa.equalsIgnoreCase("Normal"))

        {
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("arguments[0].click();", EmploymentVisaService.EmploymentVisaPriorityNormal(driver));


        } else {
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("arguments[0].click();", EmploymentVisaService.EmploymentVisaPriorityUrgent(driver));
        }


        Thread.sleep(1000);
//Medical Test is a String which came from Feature File

        if (MedicalTest.equalsIgnoreCase("Normal"))

        {
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("arguments[0].click();", EmploymentVisaService.MedicalTestPriorityNormal(driver));


        } else {
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("arguments[0].click();", EmploymentVisaService.MedicalTestPriorityUrgent(driver));
        }



            /*EmploymentVisaService.MedicalTestPriorityNormal(driver).click();
        } else if (MedicalTest.equalsIgnoreCase("Urgent")) {
            EmploymentVisaService.MedicalTestPriorityUrgent(driver).click();
        }*/
        Thread.sleep(1000);

        //Emirates ID is a String which came from Feature File
        if (EmiratesID.equalsIgnoreCase("Yes")) {
            System.out.println("Selected value is Yes");
        } else if (EmiratesID.equalsIgnoreCase("No")) {
            EmploymentVisaService.EmiratesIDNo(driver).click();
        }
        Thread.sleep(1000);
        //Residencevisa is a String which came from Feature File
        if (ResidenceVisa.equalsIgnoreCase("Normal")) {


            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("arguments[0].click();", EmploymentVisaService.ResidenceVisaPriorityNormal(driver));

        } else {
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            jse.executeScript("arguments[0].click();", EmploymentVisaService.ResidenceVisaPriorityUrgent(driver));
        }

           /* EmploymentVisaService.ResidenceVisaPriorityNormal(driver).click();
        } else if (ResidenceVisa.equalsIgnoreCase("Urgent")) {
            EmploymentVisaService.ResidenceVisaPriorityUrgent(driver).click();
        }*/
        /*List liws = Generic.Elements(driver, "ctrlElementoForm_17780_497785_3_Length_of_Residency_Visa");
        System.out.println(liws);*/

        if (Generic.Elements(driver, "ctrlElementoForm_17780_497785_3_Length_of_Residency_Visa", ResVisaDuration)) {
            System.out.println("Hai");
           /* WebElement selects=wait.until(ExpectedConditions.visibilityOf(EmploymentVisaService.ResidenceVisaDuration(driver)));
            selects.click();*/
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", EmploymentVisaService.ResidenceVisaDuration(driver));
            Select duration = new Select(EmploymentVisaService.ResidenceVisaDuration(driver));
            duration.selectByVisibleText(ResVisaDuration);
        } else {
            System.out.println("Hello world");
        }
        if (HealthInsurance.equalsIgnoreCase("Yes"))

        {
            WebElement ewq = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsuranceYes(driver)));
            ewq.click();

            if (HealthInsurancePlan.equalsIgnoreCase("Core Silver")) {


                WebElement cs = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsurancePlanCoreSilver(driver)));
                cs.click();

            }
            if (HealthInsurancePlan.equalsIgnoreCase("Enhanced Bronze"))

            {
                WebElement eb = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsurancePlanEnhancedBronze(driver)));
                eb.click();

            }

            if (HealthInsurancePlan.equalsIgnoreCase("Enhanced Silver")) {

                WebElement es = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsurancePlanCoreSilver(driver)));
                es.click();

            }
            if (HealthInsurancePlan.equalsIgnoreCase("Enhanced Gold")) {

                WebElement eg = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsurancePlanEnhancedGold(driver)));
                eg.click();
            }
            if (HealthInsurancePlan.equalsIgnoreCase("Enhanced Platinum")) {

                WebElement ep = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsurancePlanEnhancedPlatinum(driver)));
                ep.click();

            }
            if (HealthInsurancePlan.equalsIgnoreCase("Premier")) {

                WebElement p = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsurancePlanPremium(driver)));
                p.click();

            }

        }

        if (HealthInsurance.equalsIgnoreCase("No")) {
            WebElement ew = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsuranceNo(driver)));
            ew.click();
            String test = "No";
            if (test.equalsIgnoreCase("No")) {


                WebElement cs = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.AlreadyHealthInsuranceNo(driver)));
                cs.click();
            } else {
                WebElement cs = wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.AlreadyHealthInsuranceYes(driver)));
                cs.click();
            }
        }


        // wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.EmploymentVisaPriority(driver)));
        // EmploymentVisaService.EmploymentVisaPriority(driver).click();
        /*wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.MedicalTestPriority(driver)));
        EmploymentVisaService.MedicalTestPriority(driver).click();
        Thread.sleep(1000);
        wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.EmiratesID(driver)));
        EmploymentVisaService.EmiratesID(driver).click();
        Thread.sleep(1000);
        wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.ResidenceVisaPriority(driver)));
        EmploymentVisaService.ResidenceVisaPriority(driver).click();
        Thread.sleep(1000);
        wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.ResidenceVisaDuration(driver)));
        EmploymentVisaService.ResidenceVisaDuration(driver).sendKeys(ResVisaDuration);
        Thread.sleep(1000);
        wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsurance(driver)));
        EmploymentVisaService.HealthInsurance(driver).click();
        Thread.sleep(1000);
        wait2.until(ExpectedConditions.visibilityOf(EmploymentVisaService.HealthInsurancePlan(driver)));
        EmploymentVisaService.HealthInsurancePlan(driver).click();
        Thread.sleep(1000);*/
    }

    @And("^Click on Next button$")
    public void clickOnNextButton() throws Throwable {
        Thread.sleep(20000);
        WebElement nxt = wait.until(ExpectedConditions.visibilityOf(EmploymentVisaService.Next(driver)));
        nxt.click();
    }
}

