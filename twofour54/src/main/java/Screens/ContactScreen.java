package Screens;


import org.openqa.selenium.WebDriver;
@SuppressWarnings("Duplicates")
public class ContactScreen extends BaseScreen {


    public ContactScreen(WebDriver driver) {
        super(driver);
    }



    public void skipSplashScreen() {
        System.out.println("we are 3 ");

        // clicks(By.xpath(login));

    }

    public  void search(String user, String pass) throws InterruptedException {
        System.out.println("username is :" + user);
        System.out.println("password is :" + pass);

            String use = user;
            String pas = pass;
            Thread.sleep(2000);


            //sendText(login, use);
            //Thread.sleep(2000);
            //sendText(pass, pas);
            //clicks(By.xpath(submitlogin));
        }
    }
    /*public void GoSearch() {
        clicks(By.xpath(GoForSearch));
    }

    public void clickOnFirstItem() {
        clicks(By.xpath(Ele1));
    }
*/

