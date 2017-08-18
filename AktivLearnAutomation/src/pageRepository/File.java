package pageRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;

public class File {
	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	
	WebElement e;
	
	public File(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//File.properties");
		this.driver=driver;
		
	}

	public Boolean CreateNewFileItem(RemoteWebDriver driver,String FileTitle ,String FileDesc,String FilePath)
	{
		Boolean result=false;
		System.out.println("FileTitle ="+FileTitle);
		System.out.println("FileDesc ="+FileDesc);
		System.out.println("FilePath ="+FilePath);
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		try 
		{
			Thread.sleep(2000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("lnk_NewFile")));
			//Thread.sleep(1000);
			e.click();
			Thread.sleep(1000);
			result=uploadFile(driver, FilePath);
			result=setFileTitle(driver, FileTitle);
			result=clickOnAddItem(driver);
			return result;
		} 
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		//Thread.sleep(5000);
					
	}
	public Boolean uploadFile(RemoteWebDriver driver,String FilePath)
	{

		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=driver.findElement(objmap.getLocator("btn_ChooseFile"));
			//e.click();
			Actions action = new Actions(driver); 
			action.sendKeys(Keys.TAB).build().perform();
			e.sendKeys(FilePath);
			return true;
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean setFileTitle(RemoteWebDriver driver,String FileTitle)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=driver.findElement(objmap.getLocator("txt_FileTitle"));
			e.sendKeys(FileTitle);
			return true;
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean clickOnAddItem(RemoteWebDriver driver)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=driver.findElement(objmap.getLocator("btn_AddItem"));
			e.click();
			return true;
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		
	}

}
