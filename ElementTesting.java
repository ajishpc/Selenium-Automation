import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementTesting {

	private WebDriver driver;
	
	//Initialisation de l'instance du driver
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
	}
	//Setup chrome driver
	@Before
	public void setupTest() {
		driver= new ChromeDriver(); 
	}

	@After
	public void teardown() {
		if (driver != null) {
			//driver.quit();
		}
	}	    	
	@Test
	public void test() {

		//WebDriverWait wait = new WebDriverWait(driver, 10);
		
		//Démarrage du navigateur Dolibarr
		driver.get("https://demo.dolibarr.org/public/demo/index.php");
		
		driver.findElement(By.xpath("//*[@id='a1profdemoservonly']/a/div/div[2]")).click();
		
		//Effacer le champ username
		driver.findElement(By.xpath("//*[@id='username']")).clear();
		
		//Saisir login
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("demo");
		
		//Effacer le champ password
		driver.findElement(By.xpath("//*[@id='password']")).clear();
		
		//Saisir Mot de passe
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("demo");
		driver.findElement(By.xpath("//*[@id='login_line2']/input")).click();
		
		//driver.findElement(By
		
	}
}