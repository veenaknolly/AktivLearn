package pageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;

public class ContentPage {
	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	
	WebElement e;
	
	public ContentPage(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//ContentPage.properties");
		this.driver=driver;
		
	}
	
	public Boolean CreateNewPage(RemoteWebDriver driver,String PageName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		try 
		{
			Thread.sleep(2000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("lnk_NewPage")));
			e.click();
			Thread.sleep(1000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_PageName")));
			e.clear();
			e.sendKeys(PageName);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_AddItemButton")));
			e.click();	
			return true;
		} 
		catch (Exception e1)
		{
			e1.printStackTrace();
			return false;
		}
		
					
	}

}
