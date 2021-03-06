
package utilities;




import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.cucumber.listener.ExtentCucumberFormatter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;

import static tests.ThreadLocalDriver.getDriver;

//**********************************************************************************************************
//Description: ExtentReports related operations are done by this class. I added extra functionality such as
//"getCurrentPlatform". In this way, framework can create a report folder and file based on OS.
//Reference: http://extentreports.com/docs/versions/3/java/
//**********************************************************************************************************
@SuppressWarnings("Duplicates")
public class ExtentManager extends ExtentCucumberFormatter {
    public static ExtentReports extent;
    public static ExtentTest logger;
    private static Platform platform;
    private static String reportFileName = "Report.html";
    private static String macPath = System.getProperty("user.dir") + "/TestReport";
    private static String windowsPath = System.getProperty("user.dir") + "\\TestReport";
    private static String macReportFileLoc = macPath + "/" + reportFileName;
    private static String winReportFileLoc = windowsPath + "\\" + reportFileName;

    public ExtentManager(File file) {
        super(file);
    }

    /*public static String getBrowser() {
        logger.info("Getting system browser name . . .");
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        return StringUtils.capitalize(browserName);
    }

    public static String getVersion() {
        logger.info("Getting browser version . . .");
        Capabilities cap = ((RemoteWebDriver) getDriver()).getCapabilities();
        String v = cap.getVersion();
        logger.info("Browser version: " + v);
        return v;
    }*/

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    @BeforeMethod
    public void setup(Method method) {
        String testMethodName = method.getName(); //This will be:verifySaveButtonEnabled
        String descriptiveTestName = method.getAnnotation(Test.class).testName(); //This will be: 'Verify if the save button is enabled'
        ExtentTest test = extent.createTest(descriptiveTestName);

        test.assignAuthor("Nagaraj");

        System.out.println(test);

    }
    //Create an extent report instance
    public static ExtentReports createInstance() {
        platform = getCurrentPlatform();
        String fileName = getReportFileLocation(platform);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
       /* htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);*/
        htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+ "\\extent-config.xml"));
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        return extent;
    }

    //Select the extent report file location based on platform
    private static String getReportFileLocation(Platform platform) {
        String reportFileLocation = null;
        switch (platform) {
            case MAC:
                reportFileLocation = macReportFileLoc;
                createReportPath(macPath);
                System.out.println("ExtentReport Path for MAC: " + macPath + "\n");
                break;
            case WINDOWS:
                reportFileLocation = winReportFileLoc;
                createReportPath(windowsPath);
                System.out.println("ExtentReport Path for WINDOWS: " + windowsPath + "\n");
                break;
            default:
                System.out.println("ExtentReport path has not been set! There is a problem!\n");
                break;
        }
        return reportFileLocation;
    }

    //Create the report path if it does not exist
    private static void createReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!");
            } else {
                System.out.println("Failed to create directory: " + path);
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
    }

    //Get current platform
    private static Platform getCurrentPlatform() {
        if (platform == null) {
            String operSys = System.getProperty("os.name").toLowerCase();
            if (operSys.contains("win")) {
                platform = Platform.WINDOWS;
            } else if (operSys.contains("nix") || operSys.contains("nux")
                    || operSys.contains("aix")) {
                platform = Platform.LINUX;
            } else if (operSys.contains("mac")) {
                platform = Platform.MAC;
            }
        }
        return platform;
    }

}