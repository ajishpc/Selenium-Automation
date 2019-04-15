import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class DataDriven {

    private static WebDriver driver;

    @Before
    public void setUp() {
        String s = System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrateur\\Selenium Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //Démarrage du navigateur Dolibarr
        driver.get("https://demo.dolibarr.org/public/demo/index.php");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id='a1profdemoservonly']/a/div/div[2]")).click();


    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private String username;
    private String password;

    @Parameters
    public static Collection testData() throws IOException {
        return getTestData("C:\\Users\\Administrateur\\IdeaProjects\\seleniumjava\\src\\main\\resources\\Test.csv");
    }

    public dataDrivenJUnitTestWithCSV(String username, String password) {
        this.username = userName;
        this.password = password;
    }

    public static Collection<String[]> getTestData(String fileName)
            throws IOException {
        List<String[]> records = new ArrayList<String[]>();
        String record;
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while ((record = file.readLine()) != null) {
            String fields[] = record.split(",");
            records.add(fields);
        }
        file.close();
        return records;
    }

    @Test
    public void loginDolibarr() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By
                    .xpath("//*[@id='u_0_1']")));
        } catch (TimeoutException ex) {
            Assert.fail("Not loaded");
        }

// Ajoute first name
        WebElement fname = driver.findElement(By.xpath("//*[@id='u_0_1']"));
        fname.click();
        fname.clear();
        fname.sendKeys(username);

// Ajoute password
        WebElement pass = driver.findElement(By.xpath("//*[@id='u_0_a']"));
        pass.click();
        pass.clear();
        pass.sendKeys(password);

// Cliquer sur login
        WebElement reg = driver.findElement(By.xpath("//*[@id='u_0_i']"));
        reg.click();

        try {
            WebDriverWait wait2 = new WebDriverWait(driver, 10);
            wait2.until(ExpectedConditions.visibilityOfElementLocated(By
                    .cssSelector("#u_0_f i.sx_2bac47")));
        } catch (NoSuchElementException e) {
            Assert.fail("The element is not appeared.");
        }
    }
}
