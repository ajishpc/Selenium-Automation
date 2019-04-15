import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class MonPremierTest {

    @Test
    public void startWebDriver() {
        //Ajout du chemin du Driver
        String s = System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrateur\\Selenium Drivers\\chromedriver.exe");

        //Initialisation de l'instance du driver
        WebDriver driver = new ChromeDriver();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

        // Démarrage du navigateur
        driver.get("https://www.google.fr");
        driver.manage().window().maximize();
        driver.navigate().to("http://newtours.demoaut.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {

        }


        // Fermeture du navigateur
        driver.quit();
    }
}
