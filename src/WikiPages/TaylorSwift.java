/**
 * 
 */
package WikiPages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * @author José Luis Diaz
 *
 */

public class TaylorSwift {
	WebDriver driver;
	@FindBy(id="firstHeading")
		WebElement TSHeader;
	@FindBy(css="#mw-content-text > div > div:nth-child(99)")
		WebElement TSTable;
	@FindBy(className="mwe-popups-extract")
		WebElement ReputationPopUp;
	
	public TaylorSwift(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Validate Albums are shown on Studio Albums Section
	public void ValidateStudioAlbums() {
		new Actions(driver).moveToElement(TSTable).perform();
		List<WebElement> WebElementsLinks = TSTable.findElements(By.tagName("a"));
		String[] TextToFind = {"Taylor Swift","Fearless","Speak Now","Red","1989","Reputation"};
		for(String s : TextToFind) {
			for (WebElement e : WebElementsLinks) {	
				if(e.getText().equals(s)) {
					System.out.println("Album " + e.getText() + " found under Studio Albums Section");
					//Validate Reputation Album Popup
					if(s.equals("Reputation")) {
						new Actions(driver).moveToElement(e).build().perform();
						Assert.assertNotNull(ReputationPopUp.isDisplayed());
						System.out.println(ReputationPopUp.getText());
					}
				}		
			}
		}
	}
}


