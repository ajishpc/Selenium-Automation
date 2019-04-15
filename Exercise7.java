import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Exercise7 {

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
        String volAller=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select/option[5]")).getText();
        System.out.println(volAller);
        new Select(driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select/option[5]"))).selectByVisibleText("Paris");


        //String label3=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[@value='Coach']")).getText();
        //System.out.println(label3);

        //String label4=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[9]/td[2]/font/font/input[1]")).getText();
        //System.out.println(label4);


        //Assert.assertTrue("Flight Details"=label1);
        //Assert.assertTrue("No Preference"=label2);

        //Verifier le SIGN-OFF texte
        //String signoff= driver.findElement(By.linkText("SIGN-OFF")).getText();
        //Assert.assertEquals("SIGN-OFF",signoff);

        //SIGN-OFF ACTION
        //driver.findElement(By.linkText("SIGN-OFF")).click();



        //Modifiable
        //driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("m2i");
        //driver.findElement(By.cssSelector("input[name='userName']")).clear();


    }

}
