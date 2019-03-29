package utilities;


import Screens.BaseScreen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static Screens.BaseScreen.driver;

@SuppressWarnings("Duplicates")
public class Generic {


    public static String capture()
            throws Exception {

        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String encodedBase64 = null;
        FileInputStream fileInputStreamReader;
        String filename = UUID.randomUUID().toString();
        try {
            fileInputStreamReader = new FileInputStream(sourceFile);
            byte[] bytes = new byte[(int) sourceFile.length()];
            fileInputStreamReader.read(bytes);
            encodedBase64 = new String(Base64.encodeBase64(bytes));

            String screenShotDestination = System.getProperty("user.dir")
                    + "\\ErrorScreenshots\\" + filename + ".png";

            File destination = new File(screenShotDestination);
            FileUtils.copyFile(sourceFile, destination);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "data:image/png;base64," + encodedBase64;
    }


    public static WebElement webb(String test) {
        String drop_down_values = null;
        WebElement ele = driver.findElement(By.xpath(test));
        String selectedOption8 = new Select(ele).getFirstSelectedOption().getText();
        String Firstoption8 = "";
        String stBusLocation = null;
        if (selectedOption8.equals(Firstoption8)) {
            ele.click();

            WebElement CC = ele;
            Select select = new Select(CC);

            List<WebElement> comCode = select.getOptions();
            for (int i = 0; i < comCode.size(); i++) {
                drop_down_values = comCode.get(i).getText();

            }
            // System.out.println("Selected Values :" + drop_down_values);

            int randomnumbers = ThreadLocalRandom.current().nextInt(1,
                    comCode.size());
            comCode.get(randomnumbers).click();

            if (comCode.get(randomnumbers).isSelected()) {
                stBusLocation = comCode.get(randomnumbers).getText();
                System.out.println("Selected Values: " + stBusLocation);
            }


        } else {

            System.out.println("Dropdown value already selected :"
                    + selectedOption8);

        }
        return ele;
    }

    public static Boolean Elements(WebDriver driver, String id, String resvisaduration) {

        List<WebElement> myList = driver.findElements(By.id(id));
        boolean isExist = false;
        //myList contains all the web elements
        //if you want to get all elements text into array list

        List<String> all_elements_text = new ArrayList<>();
        for (WebElement aMyList : myList) {
            //loading text of each element in to array all_elements_text
            all_elements_text.add(aMyList.getText());
            //to print directly
            System.out.println(aMyList.getText());
            if (all_elements_text.contains(resvisaduration)) {
                isExist = true;
                break;
            }
        }
        return true;
    }

    private static List<WebElement> findElementInWholePage(WebDriver driver) throws InterruptedException {
        List<WebElement> lsEle = null;
        try {
            // Get all FRAMES from selected page
            List<WebElement> lsIFrames = driver.findElements(By.xpath("//iframe"));

            boolean isSwitchedToIframe = false;
            // Iterate through FRAMES (recursive loop)
            for (WebElement weIFrame : lsIFrames) {
                if (lsEle == null || lsEle.size() == 0) {
                    try {
                        isSwitchedToIframe = false;
                        if (!weIFrame.isDisplayed() || weIFrame.getSize().getWidth() <= 1 || weIFrame.getSize().getHeight() <= 1) {
                            continue;
                        }
                        driver.switchTo().frame(weIFrame);
                        isSwitchedToIframe = true;
                    } catch (WebDriverException e) {
                        System.out.printf(e.getMessage());
                    }
                }
            }
        } catch (Exception ex) {
            System.out.printf("Exception: " + ex);
        }
        return lsEle;
    }
    /*public void testUntitled() throws Exception
    {
        String[] exp ={"United Arab Emirates","Oman","Qatar","Kuwait","Bahrain","Saudi Arabia"};
        if (stBusLocation.equals(exp)) {


        }
    }*/

    public static void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
//        WebDriverWait wait = new WebDriverWait(driver, 30);
  //      wait.until(pageLoadCondition);
    }

    public void scrollTillAddToCart() throws InterruptedException {
        System.out.println("Scrolling down");
        for (int i = 0; i <= 1; i++) {
            Dimension size1 = driver.manage().window().getSize();

            int startX = size1.getWidth() / 2;
            System.out.println(startX);
            int startY = size1.getHeight() / 2 + 300;
            System.out.println(startY);
            int endX = 0;
            int endY = (int) (startY * 1 * 0.75);
            //endY= endY/4;
            System.out.println(endY);

            // TouchAction action = new TouchAction(driver);
            //   action.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
            Thread.sleep(2000);


        }
    }

    public String capture(String NameOfThread) throws Exception {


        System.out.println(NameOfThread);
        String nameOfScr = NameOfThread;
/*


        StringBuffer completeFileName = new StringBuffer();
        completeFileName.append(iTestResult.getTestClass().getRealClass().getSimpleName()); // simplified class name
        completeFileName.append("_");
        completeFileName.append(iTestResult.getName()); // method name
        // all the parameters information
        Object[] parameters = iTestResult.getParameters();
        for(Object parameter : parameters) {
            completeFileName.append("_");
            completeFileName.append(parameter);
        }

        String screen=completeFileName.toString().replace(":", "-");
*/

        Date d = new Date();
        //String date1 = d.toString();
        //System.out.println("date1 "+date1);
        SimpleDateFormat mdyFormat = new SimpleDateFormat("dd/MMM/YYYY hh:mm", Locale.ENGLISH);

        Date d1 = d;
        String ScreenDate = mdyFormat.format(d);
        System.out.println(ScreenDate);
        String date2 = ScreenDate.replaceAll("/", "_").replaceFirst(":", "h");
        //.replaceAll(":","_")
        System.out.println(date2);
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String encodedBase64 = null;
        FileInputStream fileInputStreamReader;
        try {
            fileInputStreamReader = new FileInputStream(sourceFile);
            byte[] bytes = new byte[(int) sourceFile.length()];
            fileInputStreamReader.read(bytes);
            //encodedBase64 = new String(java.util.Base64.encodeBase64(bytes));

            //String screenShotDestination = System.getProperty("user.dir") + "\\ErrorScreenshots\\" + NameOfThread + ".png";

            //should create a file "ErrorScreenshots" in project folder
            String screenShotDestination = System.getProperty("user.dir")
                    + "\\ErrorScreenshots\\" + NameOfThread + "/" + date2 + "m" + ".png";

            File destination = new File(screenShotDestination);
            FileUtils.copyFile(sourceFile, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "data:image/png;base64," + encodedBase64;
    }

    public static void hoverWebelement(WebElement HovertoWebElement)
            throws InterruptedException {
        Actions builder = new Actions(BaseScreen.driver);
        builder.moveToElement(HovertoWebElement).perform();

    }
}


