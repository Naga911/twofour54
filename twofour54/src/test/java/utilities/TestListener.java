package utilities;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

import java.io.IOException;


import static utilities.Generic.*;
import static utilities.PropReader.getDeviceName;

@SuppressWarnings("Duplicates")
public class TestListener extends BaseTest implements ITestListener {

    private static ExtentReports extent = ExtentManager.createInstance();
    //private static ExtentTest logger = ExtentManager.logger;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Override
    public synchronized void onStart(ITestContext context) {
        System.out.println("Extent Reports Version 3 Test Suite started!");

        System.out.println(
                System.currentTimeMillis());

    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        System.out.println(context.getName());
        Reporter.addStepLog(context.getName());
        extent.flush();

    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        test.set(extentTest);
     //   extentTest.debug(MarkupHelper.createLabel(ExtentManager.getBrowser() + " " + ExtentManager.getVersion(), ExtentColor.TRANSPARENT));

    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");

    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {

     /*  try {
             System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
            Reporter.addScreenCaptureFromPath(capture());
            //logger.addScreenCaptureFromPath(capture());

            String screenshotPath = capture();
            System.out.println(screenshotPath);
            extent.flush();

            //extent.attachReporter((ExtentReporter) logger);
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

//Name of the thread
        String name = Thread.currentThread().getName().toString().replace("TestNG-test=", " ");
        // name.toString().replace(":", "-");

        //System.out.println("failed case:"+ ThreadMXB);
        //System.out.println("failed case:"+Thread.currentThread().);

        try {
           // ExtentTestManager.getTest().addScreenCaptureFromPath(FailedCaseScreenshot());
            // Reporter.addScreenCaptureFromPath(FailedCaseScreenshot());
            System.out.println(name);
            Reporter.addScreenCaptureFromPath(capture(name));
            //    test.get().log(Status.INFO,"screenshot attached");
        }catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();*/

        }




    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }


    private String composeTestName(ITestResult result) {
        StringBuffer completeFileName = new StringBuffer();

        completeFileName.append(result.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(result.getName()); // method name

        // all the parameters information
        Object[] parameters = result.getParameters();
        for (Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }

        // return the complete name and replace : by - (in the case the emulator have port as device name)
        return completeFileName.toString().replace(":", "-");
    }

    @After
    public void AddDeviceToJson(Scenario scenario) {
        scenario.write("This test was executed on device " + getDeviceName());
    }



}

/*
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " started!"));
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(), result.getMethod().getDescription());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " passed!"));
        test.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Class clazz = result.getTestClass().getRealClass();
        try {
            // this field name must be present and equals in any testcase
            Field field = clazz.getDeclaredField("driver");
            field.setAccessible(true);

            AppiumDriver<?> driver = (AppiumDriver<?>) field.get(result.getInstance());

            File file = driver.getScreenshotAs(OutputType.FILE);

            // the filename is the folder name on test.screenshot.path property plus the completeTestName
            FileUtils.copyFile(file,
                    new File(System.getProperty("user.dir") + "/" + composeTestName(result) + ".png"));

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println((result.getMethod().getMethodName() + " skipped!"));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
    }

    @Override
    public void onStart(ITestContext result) {
        System.out.println("Extent Reports Version 3 Test Suite started!");
    }

    @Override
    public void onFinish(ITestContext result) {
        System.out.println(("Extent Reports Version 3  Test Suite is ending!"));
        extent.flush();
    }


    private String composeTestName(ITestResult result) {
        StringBuffer completeFileName = new StringBuffer();

        completeFileName.append(result.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(result.getName()); // method name

        // all the parameters information
        Object[] parameters = result.getParameters();
        for (Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }

        // return the complete name and replace : by - (in the case the emulator have port as device name)
        return completeFileName.toString().replace(":", "-");
    }
}*/
