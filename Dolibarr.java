import junitparams.FileParameters;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Dolibarr {

    //Initialisation de l'instance du driver

    protected static WebDriver driver;
    //Ajout du chemin du Driver
    @BeforeClass
    public static void SetUp(){

        //Initialisation de l'instance du driver
        String s = System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrateur\\Selenium Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    //@RunWith(JUnitParamsRunner.class)
    @FileParameters("src/main/resources/Test.csv")
    public void PetitJeu(){

        //Démarrage du navigateur Dolibarr
        driver.get("https://demo.dolibarr.org/public/demo/index.php");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='a1profdemoservonly']/a/div/div[2]")).click();




        List<String[]> records = new ArrayList<String[]>();
        String record;
        try{
            BufferedReader file = new BufferedReader(new FileReader("src/main/resources/Test.csv"));
            while ((record = file.readLine()) != null) {
                String fields[] = record.split(",");
                records.add(fields);
                //System.out.println(fields);
            }
            System.out.println(fie);
        }catch (IOException ie){}

        /*FAIRE TABULATION ET LOGIN*/

        //Effacer le champ username
        driver.findElement(By.xpath("//*[@id='username']")).clear();

        //Saisir login
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("demo");

        //Initialisation de l'instance de l'Actions
        Actions builder=new Actions(driver);

        //Faire première tabulation
        builder.sendKeys(Keys.TAB).build().perform();

        //Effacer le champ password
        driver.findElement(By.xpath("//*[@id='password']")).clear();
        //Saisir Mot de passe
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("demo");

        //Faire deuxième tabulation
        builder.sendKeys(Keys.TAB).build().perform();

        //Taper Entrer
        driver.findElement(By.xpath("//*[@id='login_line2']/input")).sendKeys(Keys.ENTER);

        //Capture d'écran
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(src, new File("C:\\Users\\Administrateur\\Pictures\\src.png"));
        }catch (IOException e){}
    }
}
