import au.com.bytecode.opencsv.CSVReader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Verif_CSV {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        //String s = System.setProperty("webdriver.chrome.driver", "C:\\browser_drivers\\chromedriver.exe");
        String s = System.setProperty("webdriver.chrome.driver", "D:\\TEST_Logiciel\\AUTOMATION\\Selenium\\Chrome\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void Jeux_donnees() throws IOException {
        lancementSite();
        //connexion();

        /***********DEBUT CSV**********************/

        String CSV_FILE = "D:\\TEST_Logiciel\\AUTOMATION\\CSV\\data.csv";

        //READ CSV
        CSVReader reader = null;
        try {
            reader = new CSVReader(new FileReader(CSV_FILE));
            String[] cell;
            System.out.println("Etape 1");
            //Reader lit chaque colonne (readNext
            while((cell = reader.readNext())!=null) {
                String colonne1 = cell[0]; // username
                String colonne2 = cell[1]; //password

                System.out.println("Etape 2  - colonne 1 : " + cell[0]);
                //System.out.println("Etape 3  - colonne 2 : " + cell[1]);
                driver.findElement(By.linkText("SIGN-ON")).click();
                driver.findElement(By.name("userName")).sendKeys(colonne1);
                driver.findElement(By.name("password")).sendKeys(colonne2);
                driver.findElement(By.name("login")).click();
                driver.findElement(By.linkText("SIGN-OFF")).click();

            }
        }catch (IOException e) {
            e.printStackTrace();
        }



        /***********FIN CSV************************/


    }
    public void lancementSite(){
        //Lancer URL
        System.out.println("connexion a newtours...");
        driver.get("http://newtours.demoaut.com");
        //driver.get("http://localhost:56/servlets/com.mercurytours.servlet.WelcomeServlet");
    }

    public void connexion() {
        //CLique sur sign on
        driver.findElement(By.linkText("SIGN-ON")).click();

        //Saisir  user et mpd
        //driver.findElement(By.name("userName")).sendKeys("m2i");
        //driver.findElement(By.name("password")).sendKeys("m2i");
        //driver.findElement(By.name("login")).click();
    }







}
