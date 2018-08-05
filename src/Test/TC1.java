package Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import WikiPages.Home;
import WikiPages.TaylorSwift; 

public class TC1 {
	
	WebDriver driver;

	@Test //MainTest
	public void Test() {
		Home home = new Home(driver);
		TaylorSwift taylorswift = new TaylorSwift(driver);
		
		home.SearchWord("Taylor Swift");
		home.SelectEnglishVersion();
		taylorswift.ValidateStudioAlbums();
	}
	
	@BeforeTest
	public void BeforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32_latest\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://wikipedia.org");
		//driver.get("https://en.wikipedia.org/wiki/Taylor_Swift");
		
	}
	@AfterTest
	public void AfterTest() {
		driver.quit();	
	}
}
