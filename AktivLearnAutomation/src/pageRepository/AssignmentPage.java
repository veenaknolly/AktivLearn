package pageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;
import Utils.KeyWordLib;

public class AssignmentPage extends KeyWordLib {

	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	WebElement e;
	
	public AssignmentPage(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//AssignmentPage.properties");
		this.driver=driver;
		
	}
	
	
	public Boolean CreateNewAssignment(RemoteWebDriver driver,String AssignmentName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		
		try 
		{
			
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("lnk_NewAssignment")));
			e.click();
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_NewAssignmentName")));
			e.sendKeys(AssignmentName);
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
	
	public Boolean setAssignmentPoints(RemoteWebDriver driver,String AssignmentPoints)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		
		try 
		{
			
			ActionScrollDown(driver,600);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_AssignmentPoints")));
			e.sendKeys(AssignmentPoints);	
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
	
	public Boolean clickOnSaveButton(RemoteWebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		
		try 
		{
			
			ActionScrollDown(driver,600);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_Save")));
			e.click();	
			Thread.sleep(1000);
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
	
	public Boolean clickOnEditButtonOfAssignment(RemoteWebDriver driver,String AssignmentName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			Thread.sleep(3000);
			e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'"+AssignmentName+"')]")));
			e.click();
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_EditButtonAssignmentPage")));
			e.click();
			Thread.sleep(1000);
			return true;
		}
		catch (Exception e1)
		{
			
			e1.printStackTrace();
			return false;
		}
	}
	

	public Boolean SettingPropertiesForAssignment(RemoteWebDriver driver,String AssignmentName) throws InterruptedException
	{
//		String AssignmentName=AssignmentDetails[1].toString();
//		String AssignmentDesc=AssignmentDetails[2].toString();
//		String Points=AssignmentDetails[3].toString();
//		String SubmissionType=AssignmentDetails[4].toString();
//		String SubType=AssignmentDetails[5].toString();
		Thread.sleep(5000);
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'"+AssignmentName+"')]")));
			e.click();
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_EditButtonAssignmentPage")));
			e.click();
			Thread.sleep(1000);
//			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_AssignmentPoints")));
//			e.sendKeys(Points);
			e=driver.findElement(objmap.getLocator("drpdwn_AssignmentType"));
			ActionScrollDown(driver,1200);
			e=driver.findElement(objmap.getLocator("btn_Save"));
			e.click();
			Thread.sleep(1000);
			
			return true;
		} 
		catch (Exception e1)
		{
			
			e1.printStackTrace();
			return false;
		}
		
		
		
	}
		
		
	

}
