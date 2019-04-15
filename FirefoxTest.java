import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest{

    @Test
    public void startWebDriver(){
        //Ajout du chemin du Driver
        String s = System.setProperty("webdriver.gecko.driver", "C:\\Users\\Administrateur\\Selenium Drivers\\geckodriver.exe");

        //Initialisation de l'instance du driver
        WebDriver driver = new FirefoxDriver();

        // Démarrage du navigateur
        driver.get("https://www.google.fr");

        // Fermeture du navigateur
        driver.quit();
    }
}
