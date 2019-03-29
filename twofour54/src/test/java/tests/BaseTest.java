package tests;

import Screens.BaseScreen;
import Screens.ContactScreen;
import Screens.SplashScreen;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static tests.ThreadLocalDriver.getDriver;
import static utilities.ExtentManager.logger;


public class BaseTest {


    //public WebDriver driver;


    /*public WebDriver getDriver() {

        return driver;
    }
*/

    public WebDriverWait wait;
    protected static WebDriver driver;
    //private ThreadLocalDriver threadLocalDriver = new ThreadLocalDriver();
    //Base Screens for all cases
    protected SplashScreen splashScreen = null;
    protected ContactScreen contactScreen = null;

   /* protected TutorialScreen tutorialScreen = null;
    protected SelectionScreen selectionScreen = null;
    protected CandidateMainScreen candidateMainScreen = null;*/

    @BeforeMethod
    @Parameters({"osname", "BrowserType", "platformVersion"})
    @SuppressWarnings("Duplicates")
    public void setup(String osname, String BrowserType, String platformVersion) throws Exception {
        System.out.println("TestNG Before");
        String urls = "https://auradev.twofour54.com/AP/Login.aspx";
      /*  //Unlock the device if it is locked.
        final Runtime rt = Runtime.getRuntime();
        rt.exec("adb shell input keyevent 224");*/
        if (driver == null) {
            if (osname.equalsIgnoreCase("Windows")) {
                DesiredCapabilities desired = null;
                if (BrowserType.equalsIgnoreCase("firefox")) {
               /* String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/geckodriver";
                System.setProperty("webdriver.gecko.driver", firefoxDriverPath);*/
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\NagarajS\\IdeaProjects\\2_iDigiPro\\driver-servers\\geckodriver.exe");

                    desired = new DesiredCapabilities();
                    desired.setCapability("osname", osname);
                    desired.setCapability("BrowserType", BrowserType);
                    desired.setCapability("platformVersion", platformVersion);
                    File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

                    FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);

                    FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\NagarajS\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\079iupvh.FirefoxProfile"));
                    FirefoxOptions options = new FirefoxOptions().addPreference("security.insecure_password.ui.enabled", false).addPreference("security.insecure_field_warning.contextual.enabled", false);

                    desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
                    options.setProfile(profile);

                    driver = new FirefoxDriver(options);
                    driver.get(urls);
                    //splashScreen = new SplashScreen(driver);
                    //contactScreen=new ContactScreen(driver);
                }
              /*  if (BrowserType.equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver",
                            "C:\\twofour54\\twofour54\\Drivers\\chromedriver.exe");
                    desired = DesiredCapabilities.chrome();
                    desired.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    desired.setBrowserName("chrome");
                    desired.setPlatform(Platform.WINDOWS);
                    driver = new ChromeDriver();

                }*/
               // ThreadLocalDriver.setTLDriver(new RemoteWebDriver(new URL(urls), desired));
               driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            }


            splashScreen = new SplashScreen(driver);
            contactScreen = new ContactScreen(driver);


        }


    }

   /* @SuppressWarnings("Duplicates")
    public static String getBrowser() {
        logger.info("Getting system browser name . . .");
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        return StringUtils.capitalize(browserName);
    }

    @SuppressWarnings("Duplicates")
    public static String getVersion() {
        logger.info("Getting browser version . . .");
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        String v = cap.getVersion();
        logger.info("Browser version: " + v);
        return v;
    }*/

}
