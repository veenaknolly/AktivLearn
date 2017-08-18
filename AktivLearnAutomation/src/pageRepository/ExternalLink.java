package pageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;

public class ExternalLink {

	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	
	WebElement e;
	
	public ExternalLink(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//ExternalLink.properties");
		this.driver=driver;
		
	}
	
	public Boolean createNewExternalURLItem(RemoteWebDriver driver,String URL)
	{
			WebDriverWait wait=new WebDriverWait(driver,10);

		
		try 
		{
			Thread.sleep(2000);
			setURL(driver, URL);
			Thread.sleep(1000);
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
	
	public Boolean setURL(RemoteWebDriver driver, String URL)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_URL")));
			e.sendKeys(URL);
			return true;
			
			
		}
		catch (Exception e1) {
		
			e1.printStackTrace();
			return false;
		}
		
		
	}
	
	public Boolean setTitle(RemoteWebDriver driver, String Title)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_Title")));
			e.sendKeys(Title);
			return true;		
		}
		catch (Exception e1) 
		{
		
			e1.printStackTrace();
			return false;
		}
		
		
	}
	public Boolean selectURLContentType(RemoteWebDriver driver,String ContentType)
	{
		WebElement e;
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		
		try
		{
			
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("drpdown_URLContentType")));
			Thread.sleep(1000);
			Select s=new Select(e);
			s.selectByValue(ContentType);
			return true;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
}
