package utilities;


import Screens.BaseScreen;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

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
        String nameOfScr=NameOfThread;
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

        Date d1=d;
        String ScreenDate = mdyFormat.format(d);
        System.out.println(ScreenDate);
        String date2 = ScreenDate.replaceAll("/", "_").replaceFirst(":","h");
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
                    + "\\ErrorScreenshots\\" + NameOfThread+"/"+date2 +"m" +".png";

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


