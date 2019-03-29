package tests.cucumber.steps;

import Screens.BaseScreen;
import Screens.ContactScreen;
import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import tests.cucumber.PageObjects.contact;
import tests.cucumber.PageObjects.logins;
import tests.cucumber.Transformer.EmailTransform;
import utilities.Generic;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.awt.event.InputEvent;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@SuppressWarnings("Duplicates")


public class contactSteps  {
    private static WebDriver driver = BaseScreen.driver;

    private static WebDriverWait wait = new WebDriverWait(driver, 20);
    private String FN, LN;



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
        FN = FirstName;
        LN = LastName;
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

        /*contact.DOB(driver).sendKeys(DOB);
        Thread.sleep(2000);
        contact.PassportIDate(driver).sendKeys(PassportIDate);
        Thread.sleep(2000);
        contact.PassportEDate(driver).sendKeys(PassportEDate);*/

        System.out.println(PassportEDate);
        contact.DOB(driver).sendKeys(DOB);
        Thread.sleep(2000);
        contact.PassportIDate(driver).sendKeys(PassportIDate);
        Thread.sleep(2000);
        contact.PassportEDate(driver).sendKeys(PassportEDate);

        Thread.sleep(8000);
        contact.UploadPassport(driver).click();
        Thread.sleep(8000);
        driver.switchTo().frame(5);
        contact.UploadBrowser(driver).click();
        Thread.sleep(8000);
        Runtime.getRuntime().exec("C:\\My projects\\MZA.exe");
        Thread.sleep(8000);
    }

    @Then("^I enter Email Address as Email:([^\"]*)$")
    public void iEnterEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {
        Thread.sleep(8000);
        driver.switchTo().defaultContent();
        System.out.println("Email Address is : " + email);
        contact.Email(driver).sendKeys(email);
        Thread.sleep(8000);
        Generic.webb(contact.BillingAccount);

        Thread.sleep(5000);


       /* contact.JobTitle(driver).click();
        Thread.sleep(8000);
        driver.switchTo().frame(5);

        Thread.sleep(8000);
        contact.JobCode(driver).sendKeys("102");
        contact.ProceedButton(driver).click();
        Thread.sleep(6000);*/

        contact.NextButton(driver).click();
        Thread.sleep(20000);
        contact.NextButton(driver).click();
        Thread.sleep(20000);
        contact.NextButton2(driver).click();
        Thread.sleep(20000);
        contact.submit(driver).click();
        Thread.sleep(20000);
       /* driver.findElement(By.xpath("//a[@class='ApEst_30164611']")).click();
        Thread.sleep(8000);*/
        //driver.switchTo().defaultContent();


    }

    @Given("^Verify, Approve contact from Approver ([^\"]*) ([^\"]*)$")
    public void verifyApproveContactFromApproverUsernamePassword(String user, String pass) throws Throwable {
        Thread.sleep(12000);
        //String winHandleBefore = driver.getWindowHandle();
       /* ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());*/
        // driver.switchTo().window(tabs.get(0));

        //  String parentWindow = driver.getWindowHandle();
        /*Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
       //     if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);*/
        String urls = "https://auradev.twofour54.com/Home/Home.aspx";
        driver.get(urls);
        driver.switchTo().alert().sendKeys(user + Keys.TAB + pass);
        driver.switchTo().alert().accept();
        Thread.sleep(4000);
        driver.switchTo().defaultContent();
        //driver.close(); //closing child window
        //       driver.switchTo().window(parentWindow); //cntrl to parent window
        //     }
        //}

        String enws = driver.getTitle();
        System.out.println(enws);
        //driver.switchTo().defaultContent();
        //driver.close();
        System.out.println("we made it till here");
        Thread.sleep(6000);
      /*  String Parent_Window = driver.getTitle();
        //getWindowHandle();
        System.out.println(Parent_Window);
        // Switching from parent window to child window
        for (String Child_Window : driver.getWindowHandles()) {
            driver.switchTo().window(Child_Window);

        }*/
       /* Robot rb = new Robot();
        rb.mouseMove(100, 235);
        Robot rb1 = new Robot();
        rb1.mouseMove(100, 235);
        try {
            rb1.mousePress(InputEvent.BUTTON1_MASK);
            rb1.mouseRelease(InputEvent.BUTTON1_MASK);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //

        Thread.sleep(2000);
        /*String Parent_Window = driver.getTitle();
        //getWindowHandle();
        System.out.println(Parent_Window);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);*/
        // Switching from parent window to child window
        /*for (String Child_Window : driver.getWindowHandles()) {
            WebElement element = driver.findElement(By.id("ifTareasProceso"));
            driver.switchTo().frame(element);
            System.out.println(Child_Window);
        }*/
       /* WebDriverWait wait = new WebDriverWait(driver, 30);
        List<WebElement> lsEle = null;
        try {
            List<WebElement> lsIFrames = driver.findElements(By.xpath("//body[@id='mainBody']//iframe[3]"));
            System.out.println(lsIFrames);
            boolean isSwitchedToIframe = false;
            // Iterate through FRAMES (recursive loop)
            for (WebElement weIFrame : lsIFrames) {
                try {
                    isSwitchedToIframe = false;
                    if (!weIFrame.isDisplayed() || weIFrame.getSize().getWidth() <= 1 || weIFrame.getSize().getHeight() <= 1) {
                    }
                } catch (WebDriverException e) {
                    System.out.printf(e.getMessage());
                }
            }
        } catch (Exception ex) {
            System.out.printf("Exception: " + ex);
        }*/


        WebElement fr = wait.until(presenceOfElementLocated(By.id("marcocentral")));
        driver.switchTo().frame(fr);

        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames);
        WebElement fr1 = wait.until(presenceOfElementLocated(By.xpath("//iframe[contains(@src,'/Home/BPM_Tareas_Lista.aspx?')]")));
        //iframe[contains(@src,'/Home/BPM_TareaPersonal.aspx?')];
        driver.switchTo().frame(fr1);

        WebElement fr2 = wait.until(presenceOfElementLocated(By.id("ifTareasProceso")));
        driver.switchTo().frame(fr2);
        System.out.println("i switched to frame");

        Thread.sleep(3000);

        WebElement ClassofProcesses = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='pnlFiltro']/tbody/tr[2]/td[2]/div/div[3]/input[@id='txtClaseProceso']"))));
        ClassofProcesses.sendKeys("New");
        System.out.println(FN);
        WebElement ServiceDetails = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='pnlFiltro']/tbody/tr[3]/td[4]/div[1]/div[3]/input[@id='txtAsunto']"))));

        ServiceDetails.sendKeys("Emp");

        wait.until(ExpectedConditions.visibilityOf(contact.Proceed(driver))).click();
        Thread.sleep(3000);

        WebElement clik = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//table[@id='dgProcessTask_body_container']/tbody/tr[1]"))));
        clik.click();
        Thread.sleep(12000);

        /*String parentwindowhandler= driver.getWindowHandle(); // store your parent window..
        String subwindowhandler=null;
        Set<String> handles= driver.getWindowHandles();
        Iterator<String> iterator= handles.iterator();
        while(iterator.hasNext()){
            subwindowhandler= iterator.next();
        }*/
        //driver.switchTo().window(subwindowhandler); // switch to child window..
        //Thread.sleep(3000);

      /*  WebElement mytable = driver.findElement(By.xpath("//html[1]/body[1]/div[6]/table[1]"));

        //To locate rows of table.
        List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));

        //To calculate no of rows In table.
        int rows_count = rows_table.size();


        //Loop will execute for all the rows of the table
        for (int row = 0; row < rows_count; row++) {

            //To locate columns(cells) of that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));

            //To calculate no of columns(cells) In that specific row.
            int columns_count = Columns_row.size();
            System.out.println("Number of cells In Row " + row + " are " + columns_count);

            //Loop will execute till the last cell of that specific row.
            for (int column = 0; column < columns_count; column++) {
                //To retrieve text from the cells.
                String celltext = Columns_row.get(column).getText();
                System.out.println("Cell Value Of row number " + row + " and column number " + column + " Is " + celltext);
            }
        }*/
        driver.switchTo().defaultContent();
        WebElement fr5 = wait.until(presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[6]/table[1]/tbody[1]/tr[2]/td[1]/iframe[1][contains(@src,'/Home/BPM_TareaPersonal.aspx?')]")));
        driver.switchTo().frame(fr5);


        WebElement takeownership = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ctrlElementoAnexo_17897_500890_TAKE_OWNERSHIP"))));
        takeownership.click();

        JavascriptExecutor exe1 = (JavascriptExecutor) driver;
        Integer numberOfFrames1 = Integer.parseInt(exe1.executeScript("return window.length").toString());
        System.out.println("Number of iframes on the page are " + numberOfFrames1);

        WebElement next = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ctrlElementoAnexo_17897_500885_NEXT"))));
        next.click();
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement next2 = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ctrlElementoAnexo_11861_302960_NEXT"))));
        //a[@id='ctrlElementoAnexo_11861_302960_NEXT']
        next2.click();
        new WebDriverWait(driver, 20).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        WebElement approve = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("ctrlElementoAnexo_11863_302997_APPROVE"))));
        //a[@id='ctrlElementoAnexo_11861_302960_NEXT']
        approve.click();

    }


    @AfterMethod
    public void teardown() {
        //  driver.quit();
    }
}



