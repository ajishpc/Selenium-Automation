import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.ref.SoftReference;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchHTest  {

    //Initialisation de l'instance du driver

    protected static WebDriver driver;
    //Ajout du chemin du Driver

    @BeforeClass
    public static void setUp(){

        //Initialisation de l'instance du driver
        String s = System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrateur\\Selenium Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void Rechercher(){

        // Démarrage du navigateur
        driver.get("https://www.accorhotels.com/france/index.fr.shtml");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //Saisir une destination
        driver.findElement(By.cssSelector("input[id='search-destination']")).sendKeys("Lille");
       //select le premier élément dans la liste proposée
        driver.findElement(By.cssSelector(".autocompleteItem__label")).click();

        //Date aujourdh'hui
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        String dayOfMonthStr = String.valueOf(dayOfMonth);
        System.out.println(dayOfMonthStr);

        //Date depart
        int dayDepart=dayOfMonth+1;
        String dayDepartStr = String.valueOf(dayDepart);

        //select In date
        driver.findElement(By.cssSelector("input[id='search-dateIn-boo']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker-group ui-datepicker-group-first')]/table/tbody/tr/td/a[text()='"+dayOfMonth+"']")).click();

        //select Out date
        driver.findElement(By.cssSelector("input[id='search-dateout-boo']")).click();
        driver.findElement(By.xpath("//div[contains(@class,'ui-datepicker-group ui-datepicker-group-first')]/table/tbody/tr/td/a[text()='"+dayDepartStr+"']")).click();

        //Sélectionner la chambre
        Random rand= new Random();

        String chambre= String.valueOf(1+rand.nextInt(7));
        System.out.println("Nombre de chambre"+chambre);

        //Sélectionner l'adulte
        String adulte[] = new String[9];
        String enfants[]= new String[9];
        String enfantAge[][]= new String[9][9];

        //replir les valuers pour l'adultes
        //int h=0;
        System.out.println("Nombres de adultes");
        for (int i=0;i<Integer.parseInt(chambre);i++){
                adulte[i]=String.valueOf(1+rand.nextInt(9));
                System.out.println(adulte[i]);
        }

        //replir les valuers des enfants
        for (int i=0;i<Integer.parseInt(chambre);i++){

                enfants[i]=String.valueOf(rand.nextInt(3));
                System.out.println("Nombre des enfants"+enfants[i]+"pour chambre"+i);
                //e++;
        }

        //remplir les valuers d'age des enfants
        for (int i=0;i<Integer.parseInt(chambre);i++){
            for (int j=0;j<Integer.parseInt(enfants[i]);j++){

                    enfantAge[i][j]=String.valueOf(rand.nextInt(16));
                    System.out.println("age des enfants"+enfantAge[i][j]);
                }
        }

        //select chambre
        new Select(driver.findElement(By.cssSelector("select[name='search.roomNumber']"))).selectByVisibleText(chambre);

        for (int i=0;i<Integer.parseInt(chambre);i++){

                //select adultes
                new Select(driver.findElement(By.cssSelector("select[name='search.roomCriteria["+i+"].adultNumber']"))).selectByVisibleText(adulte[i]);
                //select enfants
                new Select(driver.findElement(By.cssSelector("select[name='search.roomCriteria["+i+"].childrenNumber']"))).selectByVisibleText(enfants[i]);
                for (int j=0;j<Integer.parseInt(enfants[i]);j++){
                    new Select(driver.findElement(By.cssSelector("select[name='search.roomCriteria["+i+"].children["+j+"].age']"))).selectByVisibleText(enfantAge[i][j]);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ie) {}
                }
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,100)", "");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ie) {}

       // driver.findElement(By.cssSelector("button[id='cnil-banner__action-close']")).click();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,200)", "");

        //Cliquer sur rechercher
        driver.findElement(By.className("tSubmit")).click();
    }

}