import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Write_to_csv_Facon_2 {
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        //String s = System.setProperty("webdriver.chrome.driver", "C:\\browser_drivers\\chromedriver.exe");
        String s = System.setProperty("webdriver.chrome.driver", "D:\\TEST_Logiciel\\AUTOMATION\\Selenium\\Chrome\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void  Write_In_CSV() throws IOException {
        lancementSite();
        connexion();

        //Write in CSV
        String CSV_OUTPUT = "D:\\TEST_Logiciel\\AUTOMATION\\CSV\\output.csv";
        Write_saveRecord(CSV_OUTPUT);
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
        driver.findElement(By.name("userName")).sendKeys("m2i");
        driver.findElement(By.name("password")).sendKeys("m2i");
        driver.findElement(By.name("login")).click();
    }
    public void Write_saveRecord(String CSV_OUTPUT){

        try{
            FileWriter fw  = new FileWriter(CSV_OUTPUT);   //File writer  : fw
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String element1 = driver.findElement(By.xpath("//font[@face='ARIAL, HELVETICA'][contains(text(),'Flight ')]")).getText();
            String element2 = driver.findElement(By.xpath("//font[contains(text(),'Preferences')]")).getText();
            //System.out.println("Colonne 1 : "+element1);

            pw.println(element1+","+element2);
            pw.flush();
            pw.close();

            JOptionPane.showMessageDialog(null,"Record saved");

        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
