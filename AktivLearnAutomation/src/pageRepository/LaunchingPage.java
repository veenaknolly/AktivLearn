package pageRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utils.CreateObjectMap;
import Utils.ExcelUtil;

public class LaunchingPage {
	
	
	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	WebElement e;
	
	
	public LaunchingPage(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//LaunchingPage.properties");
		this.driver=driver;
		
	}
	
	public Boolean navigateToAktivLearn(RemoteWebDriver driver) throws Exception
	{
		
		try
		{
			
			driver.get("https://staging.aktivlearn.com/login/home?type=aktivlearn");
			if(driver.getTitle().equals("Log In to AktivLearn"))
			{
				
				return true;
			}
			else
				return false;
			
		}
		catch(Exception e)
		{
			return false;
		}
	
	}
	
	public Boolean clickOnStartPlaying(RemoteWebDriver driver)
	{
		try
		{
			e=driver.findElement(objmap.getLocator("btn_StartPlaying"));
			e.click();
			return true;
		}
		catch (Exception e1) 
		{	
			e1.printStackTrace();
			return false;
		}
		
	}
	
//	public Boolean loginToAktivLearn(RemoteWebDriver driver,String EmailId,String password)
//	{
//		try
//		{
//			
//			String winHandleBefore = driver.getWindowHandle();
//			e=driver.findElement(objmap.getLocator("btn_StartPlaying"));
//			e.click();
//			for(String winHandle : driver.getWindowHandles()){
//			    driver.switchTo().window(winHandle);
//			 e=driver.findElement(objmap.getLocator("txt_EmailNew"));
//			 e.sendKeys(EmailId);
//			 e=driver.findElement(objmap.getLocator("txt_passwordNew"));
//			 e.sendKeys(password);
//			 e=driver.findElement(objmap.getLocator("btn_LoginNew"));
//			 e.click();
//			 driver.switchTo().window(winHandleBefore);
//			 return true;
//			}
//			
//			
//			
//		} 
//		catch (Exception e1) 
//		{
//			
//			e1.printStackTrace();
//			return false;
//		}
//		
//		return true;
//	}
	
	public Boolean loginToAktivLearn(RemoteWebDriver driver, String EmailId,String password)
	{
		
		try 
		{
			
			e=driver.findElement(objmap.getLocator("txt_Email"));
			e.sendKeys(EmailId);
			e=driver.findElement(objmap.getLocator("txt_password"));
			e.sendKeys(password);
			e=driver.findElement(objmap.getLocator("btn_Login"));
			e.click();
			return true;
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
		
		
	}

}
