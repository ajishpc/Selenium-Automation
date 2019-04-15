import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;


public class Exercise3 {

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
        driver.navigate().to("http://newtours.demoaut.com/");
        driver.findElement(By.linkText("REGISTER")).click();

        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("First");
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys("Second");
        driver.findElement(By.cssSelector("input[name='phone']")).sendKeys("05402112");
        driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("abc@mail.com");
        driver.findElement(By.cssSelector("input[name='address1']")).sendKeys("120 Rue");
        driver.findElement(By.cssSelector("input[name='address2']")).sendKeys("Nationale");
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys("Lille");
        driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Nord");
        driver.findElement(By.cssSelector("input[name='postalCode']")).sendKeys("59260");
        new Select(driver.findElement(By.cssSelector("select[name='country']"))).selectByVisibleText("FRANCE");
        driver.findElement(By.cssSelector("input[id='email']")).sendKeys("Test1");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Test1");
        driver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys("Test1");
        driver.findElement(By.name("register")).click();

        //Synchronisation
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("SIGN-OFF"))));

        driver.findElement(By.linkText("SIGN-OFF")).click();
    }

}

