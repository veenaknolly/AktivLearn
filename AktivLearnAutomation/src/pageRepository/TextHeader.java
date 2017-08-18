package pageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;

public class TextHeader {

	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	WebElement e;
	public TextHeader(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//TextHeader.properties");
		this.driver=driver;
		
	}
	public Boolean CreateNewTextHeader(RemoteWebDriver driver,String HeaderName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);

		
		try 
		{
			Thread.sleep(2000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_HeaderName")));
			e.sendKeys(HeaderName);
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
	}
}
