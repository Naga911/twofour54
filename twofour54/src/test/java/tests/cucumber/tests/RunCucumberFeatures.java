package tests.cucumber.tests;


import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;

import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.BaseTest;


import java.io.File;

import static utilities.PropReader.getDeviceName;

@RunWith(Cucumber.class)
@CucumberOptions(
        // tags = "@twofour54Application-login",
        features = {"C:\\twofour54\\twofour54\\src\\test\\java\\tests\\cucumber\\features"},
        tags = {"@twofour54Application-login,@twofour54Application-Contact"},
        //tags = {"@twofour54Application-login,@twofour54Application-Contact,@twofour54Application-employment"},
        glue = {"tests.cucumber.steps"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/reports.html"}
)

@SuppressWarnings("Duplicates")
public class RunCucumberFeatures extends BaseTest {

    private TestNGCucumberRunner testNGCucumberRunner;


    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());

    }

    @Test(groups = "cucumber", description = "Runs LoginCandidate Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println("Cucumber Test Class Inside Test" + getDeviceName());
        System.out.println(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());

    }

    @DataProvider
    public Object[][] features() {
        System.out.println("Data Provider test Class");
        return testNGCucumberRunner.provideFeatures();

    }

    @AfterClass
    public void tearDownClass() {


        Reporter.loadXMLConfig(new File(System.getProperty("user.dir")
                + "\\extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows");
        Reporter.setTestRunnerOutput("Sample test runner output message");
        testNGCucumberRunner.finish();
    }

}

