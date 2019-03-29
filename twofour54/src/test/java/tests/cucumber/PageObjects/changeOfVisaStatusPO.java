package tests.cucumber.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class changeOfVisaStatusPO {

    private static WebElement element = null;


    public static WebElement StartServiceChangeVisaStatus(WebDriver driver) {

        element = driver.findElement(By.xpath("//td[@class='easy424MenuItemContentCell']"));

        return element;

    }

    public static WebElement AcessServiceCheckbox(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@name='accept']"));

        return element;

    }

    public static WebElement AcessServiceButton(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@href='/AP/BPM_Mensajes_Crear.aspx?id=36&pag=107&idPortal=0']//img[@border='0']"));

        return element;

    }

    public static WebElement searchApplicant(WebDriver driver) {

        element = driver.findElement(By.xpath("//table[@class='direction nirbantham']//a[@class='botonojo']"));

        return element;

    }

    public static WebElement FirstnameInWindowPopup(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//html/body/form/div/div/div[4]/div/div/span/span/span/input[@id='503']"));

        return element;

    }

    public static WebElement lastnameInWindowPopup(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//html/body/form/div/div/div[4]/div/div/span/span/span/input[@id='504']"));

        return element;

    }

    public static WebElement ProceedButton(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//a[contains(text(),'Proceed')]"));

        return element;

    }

    public static WebElement serviceTypeNormal(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("(//label[@for='ctrlElementoForm_1132_26633_3_Service_Type_0'])[1]"));

        return element;

    }

    public static WebElement serviceTypeUrgent(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_1132_26633_3_Service_Type_1']"));

        return element;

    }

    public static WebElement currentStatus(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_1132_26749_3_Current_Visa_Status_1']"));

        return element;

    }

    public static WebElement FirtPageNextButton(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        //element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_1132_57012_Next_buttonMandatory']"));
        element = driver.findElement(By.xpath("//input[@value='Next']"));

        return element;

    }

    public static WebElement SecondPageNextButton(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        //element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_2961_70248_Next']"));
        element = driver.findElement(By.xpath("//a[@class='ApEst_7024811']"));

        return element;

    }

    public static WebElement serviceLabel(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//strong[contains(text(),'Change Of  Visa Status')]"));

        return element;

    }



    public static WebElement CancelledResidenceVisaRadio(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.id("ctrlElementoForm_1132_26749_3_Current_Visa_Status_0"));

        return element;

    }
    public static WebElement CancelledEntryRadio(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.id("ctrlElementoForm_1132_26749_3_Current_Visa_Status_1"));

        return element;

    }
    public static WebElement CancelledEmpVISARadio(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.id("ctrlElementoForm_1132_26749_3_Current_Visa_Status_2"));

        return element;

    }
    public static WebElement VisitVISARadio(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.id("ctrlElementoForm_1132_26749_3_Current_Visa_Status_3"));

        return element;

    }
    public static WebElement TouristVISARadio(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.id("ctrlElementoForm_1132_26749_3_Current_Visa_Status_4"));

        return element;

    }
    public static WebElement AttachCancelledResidenceVisa(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_1133_26836_3_Cancelled_residency_visa_Documents_IntInd']"));

        return element;

    }public static WebElement AttachCancelleEntryVisa(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_1133_27104_3_Cancelled_Entry_Visa_Documents_IntInd']"));

        return element;

    }public static WebElement AttachCancelledEmploymentVisa(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_1133_27110_3_Cancelled_Employment_Visa_Documents_IntInd']"));

        return element;

    }public static WebElement AttachVisitVisa(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_1133_27114_3_Visit_Visa_Documents_IntInd']"));

        return element;

    }public static WebElement AttachTouristVisa(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_1133_27116_3_Tourist_Visa_IntInd']"));

        return element;

    }

    public static WebElement uploadFilePlusButtom(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//a[@id='uploader_browse']"));

        return element;

    }
    public static WebElement ProceedToPayment(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//a[contains(@id,'SUBMIT__EVISA_YES')]"));

        return element;

    }
    public static WebElement creditcardRadio(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("(//label[@for='ctrlElementoForm_12783_336114_3_Payment_Methods_2'])[1]"));

        return element;

    }
    public static WebElement CASHRadio(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("(//label[@for='ctrlElementoForm_12783_336114_3_Payment_Methods_0'])[1]"));

        return element;

    }
    public static WebElement CHEQUEradio(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("(//label[@for='ctrlElementoForm_12783_336114_3_Payment_Methods_1'])[1]"));

        return element;

    }
    public static WebElement OnAccount(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        //element = driver.findElement(By.xpath("(//label[@for='ctrlElementoForm_12783_336114_3_Payment_Methods_2'])[1]"));

        return element;

    }
    public static WebElement Submit(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        //element = driver.findElement(By.xpath("(//a[@class='ApEst_33613611'])[1]"));
        //element = driver.findElement(By.xpath("(//a[@id='ctrlElementoForm_12781_336057_submit_mandatory'])[1]"));
        //element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_12783_336134_Submit']"));
        //element = driver.findElement(By.xpath("//a[contains(@id,'submit_mandatory')]"));
        //element = driver.findElement(By.xpath("//a[contains(@text(),'Submit')]"));
        element = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[4]/div[11]/div[1]/div[1]/div[17]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]"));

        return element;

    }
    public static WebElement Paynow(WebDriver driver) {

        //element = driver.findElement(By.xpath("//span[@id='lblHeader']"));
        element = driver.findElement(By.xpath("//a[@class='ApEst_33613711']"));

        return element;

    }
    public static WebElement SRnumber(WebDriver driver) {


        element =driver.findElement(By.id("ctrlElementoForm_12783_336116_3_Service_Request_No"));

        return element;

    }
    public static WebElement OK_successfulSubmission(WebDriver driver) {


        element =driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]"));

        return element;

        //<a onclick="ejecutaAccionCombinada('ctrlElementoForm',513356,0);return false;" id="ctrlElementoForm_18417_513356_Ok" tabindex="1501" class="ApEst_51335611" href="javascript:__doPostBack('ctrlElementoForm$18417_513356_Ok','')" style="" xpath="1">Ok</a>
        //html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/a[1]
    }

}
