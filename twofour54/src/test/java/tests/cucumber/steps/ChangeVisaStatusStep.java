package tests.cucumber.steps;

import Screens.BaseScreen;
import com.aventstack.extentreports.model.Log;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import tests.BaseTest;
import utilities.Generic;
import tests.cucumber.PageObjects.*;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static java.sql.DriverManager.getDriver;

@SuppressWarnings("Duplicates")
public class ChangeVisaStatusStep {

    private static WebDriver driver = BaseScreen.driver;
    public String Parent_Window = driver.getTitle();

    public WebDriverWait wait = new WebDriverWait(driver, 30);


    @Before
    public void setupLoginSteps2() {
        System.out.println("Cucumber Before-logins.java-test-cucumber");
        //   setupCucumber2();
        //contactScreen = new ContactScreen(driver);
        Generic.waitForLoad(driver);
    }


    @Given("^Employment visa should be completed$")
    public void employmentVisaShouldBeCompleted() throws Throwable {
        System.out.println("Employment visa completed");


    }

    @And("^Navigate to Change of visa status service, start service$")
    public void navigateToChangeOfVisaStatusServiceStartService() throws Throwable {

        //Generic.waitForLoad(driver);  //Wait untill te browser loads
        Thread.sleep(25000);

        Robot rb = new Robot();
        rb.mouseMove(100, 300);

        Thread.sleep(2000);
        Robot rb1 = new Robot();
        rb1.mouseMove(200, 300);

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

        /**horizontal scroll as start service button hidden**/
        /*

        WebElement horizontal_scroll = driver.findElement(By.xpath("//table[@class='twc-table']/..//following::th[@id='humidity']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", horizontal_scroll);

        */
        /* Dimension d = new Dimension(1024,768);
        //Resize the current window to the given dimension
        driver.manage().window().setSize(d);
        System.out.println(driver.manage().window().getSize());
        System.out.println("Widnow size decreased");
        */
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(2000,0)");

        //wait.until(ExpectedConditions.visibilityOf(changeOfVisaStatusPO.StartServiceChangeVisaStatus(driver)));
        Thread.sleep(5000);

        changeOfVisaStatusPO.StartServiceChangeVisaStatus(driver).click();


    }

    @Then("^Access the service$")
    public void accessTheService() throws Throwable {

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");

        //wait.until(ExpectedConditions.visibilityOf(changeOfVisaStatusPO.AcessServiceCheckbox(driver)));
        Thread.sleep(5000);

        changeOfVisaStatusPO.AcessServiceCheckbox(driver).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(2000,0)");
        // wait.until(ExpectedConditions.visibilityOf(changeOfVisaStatusPO.AcessServiceCheckbox(driver)));
        Thread.sleep(5000);


        changeOfVisaStatusPO.AcessServiceButton(driver).click();
        Thread.sleep(7000);

        Parent_Window = driver.getTitle();
        //getWindowHandle();
        System.out.println(Parent_Window);
        // Switching from parent window to child window
        for (String Child_Window : driver.getWindowHandles()) {
            driver.switchTo().window(Child_Window);
        }


        driver.manage().window().maximize();
        Thread.sleep(7000);

        changeOfVisaStatusPO.searchApplicant(driver).click();

        /*driver.switchTo().frame(0);
        // find all your iframes
        List<WebElement> iframes = driver.findElements(By.xpath("//body[@class='body-e']/div[2]"));
        // print your number of frames


        List<WebElement> iframe=driver.findElement(By.xpath("//body[@class='body-e']/div/table[1]"));
      */

    }

    @And("^select applicant ([^\"]*),([^\"]*)$")
    public void selectApplicantFirstnameLastname(String firstname, String lastname) throws Throwable {


        //driver.switchTo().frame(0);
        //wait.until(ExpectedConditions.visibilityOf( changeOfVisaStatusPO.FirstnameInWindowPopup(driver)));
        Thread.sleep(5000);

        // String we=driver.findElement(By.xpath("//span[@id='lblHeader']")).getText();
        //String we=driver.findElement(By.xpath("//input[@name='503']")).getText();
        // System.out.println(we);

       /* changeOfVisaStatusPO.FirstnameInWindowPopup(driver).sendKeys("Employee01");
        System.out.println("First name passed");
       */

        WebElement fr = driver.findElement(By.xpath("//body[@class='body-e']/div/table[1]//iframe"));
        driver.switchTo().frame(fr);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);
        // wait.until(ExpectedConditions.visibilityOf(changeOfVisaStatusPO.FirstnameInWindowPopup(driver)));
        Thread.sleep(5000);

        System.out.println("i switched to frame");

        // Code to pass the value in First name
        //WebElement fn = driver.findElement(By.xpath("//html/body/form/div/div/div[4]/div/div/span/span/span/input[@id='503']"));
        changeOfVisaStatusPO.FirstnameInWindowPopup(driver).sendKeys(firstname);


        // Code to pass the value in Last name
        //WebElement ln = driver.findElement(By.xpath("//html/body/form/div/div/div[4]/div/div/span/span/span/input[@id='504']"));
        changeOfVisaStatusPO.lastnameInWindowPopup(driver).sendKeys(lastname);
        // wait.until(ExpectedConditions.visibilityOf(changeOfVisaStatusPO.ProceedButton(driver)));
        Thread.sleep(5000);
        // WebElement PorceedButton=driver.findElement(By.xpath(" //a[contains(text(),'Proceed')]"));
        changeOfVisaStatusPO.ProceedButton(driver).click();


    }

    @Then("^Select service priority as ([^\"]*)$")
    public void selectServicePriorityAsServicePriority(String ServicePriority) throws Throwable {

        Thread.sleep(5000);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        // WebElement serviceLabel=driver.findElement(By.xpath("//strong[contains(text(),'Change Of  Visa Status')]"));
        System.out.println(changeOfVisaStatusPO.serviceLabel(driver).getText());
        Thread.sleep(5000);

        if (ServicePriority.equalsIgnoreCase("normal")) {
            changeOfVisaStatusPO.serviceTypeNormal(driver).click();
        } else if (ServicePriority.equalsIgnoreCase("urgent")) {
            changeOfVisaStatusPO.serviceTypeUrgent(driver).click();
        }


        //WebElement Active=driver.findElement(By.xpath("//label[@for='ctrlElementoForm_1132_26749_3_Current_Visa_Status_0']"));
        //WebElement Active=driver.findElement(By.id("ctrlElementoForm_1132_26749_3_Current_Visa_Status_0"));
        //String cancelledResidenceVisa = changeOfVisaStatusPO.CancelledResidenceVisaRadio(driver).getAttribute("checked");
        Boolean cancelledResidenceVisa = changeOfVisaStatusPO.CancelledResidenceVisaRadio(driver).isSelected();
        //String cancelledEntryVisa = changeOfVisaStatusPO.CancelledEntryRadio(driver).getAttribute("checked");
        Boolean cancelledEntryVisa = changeOfVisaStatusPO.CancelledEntryRadio(driver).isSelected();

        Boolean cancelledEmploymentVisa = changeOfVisaStatusPO.CancelledEmpVISARadio(driver).isSelected();
        Boolean VisitVisa = changeOfVisaStatusPO.VisitVISARadio(driver).isSelected();
        Boolean TouristVisa = changeOfVisaStatusPO.TouristVISARadio(driver).isSelected();

        // wait.until(ExpectedConditions.visibilityOf(changeOfVisaStatusPO.currentStatus(driver)));
      /*  Thread.sleep(7000);
        changeOfVisaStatusPO.CancelledEntryVisaRadio(driver).click();*/
        //  WebElement NEXTBUTTON=driver.findElement(By.xpath("//a[@id='ctrlElementoForm_1132_57012_Next_buttonMandatory']"));
        // wait.until(ExpectedConditions.visibilityOf(changeOfVisaStatusPO.NextButton(driver)));
        Thread.sleep(5000);
        changeOfVisaStatusPO.FirtPageNextButton(driver).click();
        Thread.sleep(8000);
        changeOfVisaStatusPO.SecondPageNextButton(driver).click();
        /*Thread.sleep(15000);

        *//**To handle unwanted alert message**//*
        Alert unwantedalert=driver.switchTo().alert();
        unwantedalert.sendKeys("MohamedElafifi"+Keys.TAB+"Password123");
        unwantedalert.accept();
        */

        /**Attachments will be changing depending on the visa current status**/


        if (cancelledResidenceVisa) {

            changeOfVisaStatusPO.AttachCancelledResidenceVisa(driver).click();
        } else if (cancelledEntryVisa) {

            changeOfVisaStatusPO.AttachCancelleEntryVisa(driver).click();

        } else if (cancelledEmploymentVisa) {

            changeOfVisaStatusPO.AttachCancelledEmploymentVisa(driver).click();

        } else if (VisitVisa) {

            changeOfVisaStatusPO.AttachVisitVisa(driver).click();

        } else if (TouristVisa) {

            changeOfVisaStatusPO.AttachTouristVisa(driver).click();
        }

        Thread.sleep(5000);
        //Thread.sleep(10000);


        /**switching frame**/
        // WebElement UploadFrame = driver.findElement(By.xpath("//iframe[@id='win_1553068279438']"));
        driver.switchTo().frame(7);
        Thread.sleep(5000);
        //WebElement uploadFile=driver.findElement(By.xpath("//a[@id='uploader_browse']"));
        changeOfVisaStatusPO.uploadFilePlusButtom(driver).click();
        Thread.sleep(5000);


        Runtime run = Runtime.getRuntime();
        run.exec("C:\\Users\\Padmashree M\\IdeaProjects\\twofour54_1103\\uploadDocument.exe");

        Thread.sleep(6000);
        driver.switchTo().defaultContent();

        driver.manage().window().maximize();

        // Thread.sleep(10000);

       /* Alert unwantedalert2=driver.switchTo().alert();
        unwantedalert2.sendKeys("MohamedElafifi"+Keys.TAB+"Password123");
        unwantedalert2.accept();
*/
        Thread.sleep(5000);

        //WebElement ProceedToPayment=driver.findElement(By.xpath("//a[@id='ctrlElementoForm_1133_160135_Submit_button_mandatory']"));
        //WebElement ProceedToPayment=driver.findElement(By.xpath("//a[contains(@id,'Submit_button_mandatory')]"));
        //WebElement ProceedToPayment=driver.findElement(By.xpath("//a[contains(@id,'SUBMIT__EVISA_YES')]"));
        changeOfVisaStatusPO.ProceedToPayment(driver).click();

       /* WebElement SRnumber=driver.findElement(By.xpath(" //span[@id='ctrlElementoForm_12783_336116_3_Service_Request_No']"));
        System.out.println(SRnumber.getText());
       */ //System.out.println(SRnumber.getAttribute();
        Thread.sleep(40000);




/*
    @And("^([^\"]*)$")
    public void paymentmethod(String PaymentMethod) throws Throwable {
        //System.out.println(driver.findElement(By.xpath("//span[contains(text(),'APPROVE')]")).getText());
        // driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
        // Generic.waitForLoad(driver);
        //WebElement ew=driver.findElement(By.xpath("(//label[@for='ctrlElementoForm_12783_336114_3_Payment_Methods_2'])[1]"));

        if (PaymentMethod.equalsIgnoreCase("credit card")) {
            changeOfVisaStatusPO.creditcardRadio(driver).click();
            Thread.sleep(5000);

        *//*driver.findElement(By.xpath("//a[@class='ApEst_33613611']")).click();
        driver.findElement(By.xpath("//a[@class='ApEst_33613711']")).click();*//*
            changeOfVisaStatusPO.Paynow(driver).click();
        } else{
            System.out.println("need to write further code");
        }
    }*/
    }

    @And("^make payment using ([^\"]*)$")
    public void makePaymentUsingPaymentMethod(String PaymentMethod) throws Throwable {

        /**Selecting payment method based on passed value from feature file**/
        if (PaymentMethod.equalsIgnoreCase("credit card")) {
            changeOfVisaStatusPO.creditcardRadio(driver).click();
            System.out.println("clicked on credit card payment");
            String SR = changeOfVisaStatusPO.SRnumber(driver).getText();
            System.out.println("The SR# number is   " + SR);
            Thread.sleep(5000);

        /*driver.findElement(By.xpath("//a[@class='ApEst_33613611']")).click();
        driver.findElement(By.xpath("//a[@class='ApEst_33613711']")).click();*/
            changeOfVisaStatusPO.Paynow(driver).click();
        } else if (PaymentMethod.equalsIgnoreCase("cash")) {
            changeOfVisaStatusPO.CASHRadio(driver).click();
            System.out.println("clicked on cash payment");
            String SR = changeOfVisaStatusPO.SRnumber(driver).getText();
            System.out.println("The SR# number is   " + SR);
            Thread.sleep(3000);
            changeOfVisaStatusPO.Submit(driver).click();

        } else if (PaymentMethod.equalsIgnoreCase("cheque")) {
            changeOfVisaStatusPO.CHEQUEradio(driver).click();
            System.out.println("clicked on CHEQUE payment");
            String SR = changeOfVisaStatusPO.SRnumber(driver).getText();
            System.out.println("The SR# number is   " + SR);
            Thread.sleep(4000);
            changeOfVisaStatusPO.Submit(driver).click();

        }


        /**Capturing SR number for the record**/
        //WebElement SRnumber = driver.findElement(By.id("ctrlElementoForm_12783_336116_3_Service_Request_No"));
        //String SR=changeOfVisaStatusPO.SRnumber(driver).getText();
        //System.out.println("The SR# number is   "+SR);

        /**click on OK on successful submission**/
        Thread.sleep(20000);

        changeOfVisaStatusPO.OK_successfulSubmission(driver).click();


    }

    @Given("^Make bulk payment in cashier portal$")
    public void makeBulkPaymentInCashierPortal() throws Throwable {
        // Thread.sleep(6000);
        /*//driver.switchTo().defaultContent();
       // Thread.sleep(7000);

       *//* String Parent_Window = driver.getTitle();
        //getWindowHandle();
        System.out.println(Parent_Window);
        // Switching from parent window to child window
        Parent_Window=driver.getWindowHandle();*//*

        System.out.println("one more time printing  "+Parent_Window);
        //driver.switchTo().defaultContent();
        System.out.println("This is window handler "+ driver.getWindowHandle());
        String windowhandle=driver.getWindowHandle();

        driver.switchTo().window(windowhandle);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000)");

        //driver.switchTo().window(Parent_Window);
        */
        /**switvh to parent window**/
        // Parent_Window = driver.getTitle();
        //getWindowHandle();
        /*System.out.println(Parent_Window);
        // Switching from parent window to child window
        for (String Child_Window : driver.getWindowHandles()) {
            // driver.switchTo().window(Child_Window);
            if (Child_Window.equals(Parent_Window)){*/
            /*    driver.switchTo().window(Parent_Window);
        System.out.println("you are in parent");*/


        Thread.sleep(6000);

        /**new tab**/
        /*
        try {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "t");
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
        }catch(Exception e){
            System.out.println("Your code dint work");
        }
        */

        /**tried to open new tab
         /*Robot robot=new Robot();
         robot.keyPress(KeyEvent.);*/
/*

        Actions act = new Actions(driver);
        act.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).build().perform();
*/


        /**quit the present window and launch one more window for internal portal**/
       driver.quit();
        /*Thread.sleep(15000);

        driver2=BaseScreen.driver;
        String GuestPortalurl="https://auradev.twofour54.com/Home/";
        driver.get(GuestPortalurl);
        //driver.findElement(By.id("ctrlElementoForm_18346_512863_OK")).click();*/
    }

    /*@And("^Navigate to create reciept$")
    public void navigateToCreateReciept() throws Throwable {

    }

    @Then("^Search ([^\"]*)$")
    public void searchAccountName(String AccountName) throws Throwable {

    }

    @And("^Enter ([^\"]*)$")
    public void enterSRnumber() throws Throwable {

    }*/

    /*@After
    public void CloseBrowser() {
        *//**quit the present window and launch one more window for internal portal**//*
        driver.quit();


    }*/


}