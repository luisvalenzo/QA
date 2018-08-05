/**
 * 
 */
package WikiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author José Luis Diaz
 *
 */
public class Home {
	private WebDriver driver;

	@FindBy(css="#searchInput")
		WebElement SearchTxtBox;
	
	@FindBy(linkText="English")
		WebElement EnglishLink;
	
	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//Search Taylor Swift on Wikipedia Page
	public void SearchWord(String Word) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(SearchTxtBox));
		SearchTxtBox.sendKeys(Word);
		SearchTxtBox.submit();
	}
	//Select English Version
	public void SelectEnglishVersion() {
		if(driver.findElements(By.linkText("English")).size()!=0) {
			EnglishLink.click();
		}
	}
}
