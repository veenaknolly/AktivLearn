package pageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;

public class DiscussionPage {
	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	
	WebElement e;
	public DiscussionPage(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//DiscussionPage.properties");
		this.driver=driver;
	}
	
	public Boolean CreateNewDiscussion(RemoteWebDriver driver,String DiscussionName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);

		
		try 
		{
			Thread.sleep(1000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("lnk_NewTopic")));
			//Thread.sleep(1000);
			e.click();
			Thread.sleep(1000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_TopicName")));
			e.clear();
			e.sendKeys(DiscussionName);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_AddItemButton")));
			e.click();	
			return true;
		} 
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		//Thread.sleep(5000);
					
	}
}
