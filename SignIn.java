import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SignIn {

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
        driver.get("http://newtours.demoaut.com/");
        driver.manage().window().maximize();

        //Log in ACTION
        driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("m2i");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("m2i");
        driver.findElement(By.cssSelector("input[name='login']")).click();

        String titre = driver.getTitle();
        //Comparer le titre avec le texte
        Assert.assertEquals("Find a Flight: Mercury Tours:",titre);

        //Verifier le SIGN-OFF texte
        String signoff= driver.findElement(By.linkText("SIGN-OFF")).getText();
        Assert.assertEquals("SIGN-OFF",signoff);

        //SIGN-OFF ACTION
        driver.findElement(By.linkText("SIGN-OFF")).click();

        String titre1 = driver.getTitle();
        //Comparer le titre avec le texte
        Assert.assertEquals("Sign-on: Mercury Tours",titre1);

        //Verifier le champ User name

        //Assert.assertEquals("userName",usernamefield);
        //Verifier l'element est present sur le page
        WebElement usernamefield = driver.findElement(By.cssSelector("input[name='userName']"));
        Assert.assertEquals(true, usernamefield.isDisplayed());

        //Modifiable
        driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("m2i");
        driver.findElement(By.cssSelector("input[name='userName']")).clear();


    }

}