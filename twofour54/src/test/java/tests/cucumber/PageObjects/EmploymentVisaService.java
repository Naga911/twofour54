package tests.cucumber.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmploymentVisaService {
    public static WebElement element = null;

    public static WebElement StartService(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@href='/AP/cm/PG106L2/AuraPortal.aspx']"));

        return element;

    }

    public static WebElement AcceptService(WebDriver driver) {

        element = driver.findElement(By.xpath("//input[@name='accept']"));

        return element;

    }

    public static WebElement AccesstheService(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@href='/AP/BPM_Mensajes_Crear.aspx?id=353&pag=107&idPortal=0']//img[@border='0']"));

        return element;

    }

    public static WebElement SearchButton(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_17780_497791_1_Full_Name_of_Employee_Boton']"));

        return element;

    }
    public static WebElement ProeedButton(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[contains(text(),'Proceed')]"));

        return element;

    }

  /*  public static WebElement CurrentVisaStatus(WebDriver driver) {

        element = driver.findElement(By.xpath("//select[@id='ctrlElementoForm_17780_497800_3_Current_Visa_Status']"));

        return element;

    }*/

    public static WebElement EmploymentVisaPriorityNormal(WebDriver driver) {

        element = driver.findElement(By.xpath("(//label[@for='ctrlElementoForm_17780_497779_3_Service_Type_0'])[1]"));
        //div/table[@id='ctrlElementoForm_Frm_17780_497779_3_Service_Type']/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td[1]/span/input

        return element;

    }
    public static WebElement EmploymentVisaPriorityUrgent(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497779_3_Service_Type_1']"));

        return element;

    }
    public static WebElement MedicalTestPriorityNormal(WebDriver driver) {

        element = driver.findElement(By.xpath("(//label[@for='ctrlElementoForm_17780_497780_3_Medical_Test_Service_Priority_0'])[1]"));

        return element;

    }
    public static WebElement MedicalTestPriorityUrgent(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497780_3_Medical_Test_Service_Priority_1']"));

        return element;

    }
    public static WebElement EmiratesIDYes(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497799_3_emirates_ID_to_be_processed_by_twofour54_0']"));

        return element;

    }

    public static WebElement EmiratesIDNo(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497799_3_emirates_ID_to_be_processed_by_twofour54_1']"));

        return element;

    }

    public static WebElement ResidenceVisaPriorityNormal(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497784_3_Residence_Visa_Service_Priority_0']"));

        return element;

    }
    public static WebElement ResidenceVisaPriorityUrgent(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497784_3_Residence_Visa_Service_Priority_1']"));

        return element;
    }


    public static WebElement ResidenceVisaDuration(WebDriver driver) {

        element = driver.findElement(By.xpath("/html[1]/body[1]/form[1]/div[3]/div[2]/div[1]/div[4]/div[2]/div[1]/div[5]/table[1]/tbody[1]/tr[1]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/select[1]"));

        return element;

    }
    public static WebElement HealthInsuranceYes(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497782_3_Apply_Health_Insurance_through_TwoFour543f_0']"));

        return element;

    }

    public static WebElement HealthInsurancePlanCoreSilver(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497790_3_Health_Insurance_Benefits_Plan_0']"));

        return element;

    }
    public static WebElement HealthInsurancePlanEnhancedBronze(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497790_3_Health_Insurance_Benefits_Plan_1']"));

        return element;

    }

    public static WebElement HealthInsurancePlanEnhancedSilver(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497790_3_Health_Insurance_Benefits_Plan_2']"));

        return element;

    }

    public static WebElement HealthInsurancePlanEnhancedGold(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497790_3_Health_Insurance_Benefits_Plan_3']"));

        return element;

    }
    public static WebElement HealthInsurancePlanEnhancedPlatinum(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497790_3_Health_Insurance_Benefits_Plan_4']"));

        return element;

    }
    public static WebElement HealthInsurancePlanPremium(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497790_3_Health_Insurance_Benefits_Plan_5']"));

        return element;

    }
    public static WebElement HealthInsuranceNo(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497782_3_Apply_Health_Insurance_through_TwoFour543f_1']"));

        return element;

    }
    public static WebElement AlreadyHealthInsuranceYes(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497786_3_Already_have_Health_Insurance3f_0']"));

        return element;

    }
    public static WebElement AlreadyHealthInsuranceNo(WebDriver driver) {

        element = driver.findElement(By.xpath("//label[@for='ctrlElementoForm_17780_497786_3_Already_have_Health_Insurance3f_1']"));

        return element;

    }
    public static WebElement Next(WebDriver driver) {

        element = driver.findElement(By.xpath("//a[@id='ctrlElementoForm_17780_497834_Next_buttonmandatory']"));

        return element;

    }
}
