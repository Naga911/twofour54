package tests;

import Screens.BaseScreen;
import Screens.ContactScreen;
import Screens.SplashScreen;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseTest {


    public static WebDriver driver = BaseScreen.driver;

    public WebDriver getDriver() {

        return driver;
    }


    public WebDriverWait wait;
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
    public void setup(String osname, String BrowserType, String platformVersion) throws IOException {
        System.out.println("TestNG Before");

      /*  //Unlock the device if it is locked.
        final Runtime rt = Runtime.getRuntime();
        rt.exec("adb shell input keyevent 224");*/
        if (driver == null) {
            if (osname.equalsIgnoreCase("Windows")) {
                if (BrowserType.equalsIgnoreCase("firefox")) {
               /* String firefoxDriverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/linux/geckodriver";
                System.setProperty("webdriver.gecko.driver", firefoxDriverPath);*/
                    System.setProperty("webdriver.gecko.driver", "C:\\Users\\NagarajS\\IdeaProjects\\2_iDigiPro\\driver-servers\\geckodriver.exe");
                    File pathBinary = new File("C:\\Program Files\\Mozilla Firefox\\firefox.exe");

                    FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
                    DesiredCapabilities desired = DesiredCapabilities.firefox();
                    FirefoxProfile profile = new FirefoxProfile(new File("C:\\Users\\NagarajS\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\079iupvh.FirefoxProfile"));
                    FirefoxOptions options = new FirefoxOptions().addPreference("security.insecure_password.ui.enabled", false).addPreference("security.insecure_field_warning.contextual.enabled", false);

                    desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
                    options.setProfile(profile);
                    String urls = "https://auradev.twofour54.com/AP/Login.aspx";
                    // options.addArguments("disable-infobars");


                    //ThreadLocalDriver.setTLDriver(new RemoteWebDriver(new URL(urls),desired));
                    driver = new FirefoxDriver(options);
                    //    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
                    driver.get(urls);
                    //  driver.manage().window().maximize();
                }
            }
        }

        //Base Screen Initialization
        //splashScreen = new SplashScreen(ThreadLocalDriver.getTLDriver());
        splashScreen = new SplashScreen(driver);
        contactScreen=new ContactScreen(driver);
        // loginScreen = new LoginScreen(ThreadLocalDriver.getTLDriver());


    }


}
