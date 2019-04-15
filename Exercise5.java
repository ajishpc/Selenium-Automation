import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Exercise5 {

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

        //Vérifier que le texte <<Flight Details>> est affiché
        //String label1=driver.findElement(By.xpath("//form[@name='findflight']/table/tbody/tr/td/font[text()='Flight Details']")).getText();
        String label1=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font")).getText();
        System.out.println(label1);

        //Vérifier que le texte <<Flight Details>> est affiché
        String label2=driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select/option[1]")).getText();
        System.out.println(label2);

        Assert.assertTrue("Flight Details".equals(label1) && "No Preference".equals(label2));

        //Vérifier la classe économique sélectionné (checkbox)
        List<WebElement> boutonradio= driver.findElements(By.name("servClass"));
        Assert.assertTrue(boutonradio.get(0).getAttribute("checked").equals("true"));

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

        //String titre1 = driver.getTitle();
        //Comparer le titre avec le texte
        //Assert.assertEquals("Sign-on: Mercury Tours",titre1);

        //Verifier le champ User name

        //Assert.assertEquals("userName",usernamefield);
        //Verifier l'element est present sur le page
        //WebElement usernamefield = driver.findElement(By.cssSelector("input[name='userName']"));
        //Assert.assertEquals(true, usernamefield.isDisplayed());

        //Modifiable
        //driver.findElement(By.cssSelector("input[name='userName']")).sendKeys("m2i");
        //driver.findElement(By.cssSelector("input[name='userName']")).clear();


    }

}
