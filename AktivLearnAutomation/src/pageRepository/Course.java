package pageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;
import Utils.KeyWordLib;
import net.sourceforge.htmlunit.corejs.javascript.ast.Assignment;

public class Course extends KeyWordLib {
	
		public CreateObjectMap objmap;
		public RemoteWebDriver driver;
		
		WebElement e;
		
		public Course(RemoteWebDriver driver) 
		{
			this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//Course.properties");
			this.driver=driver;
			
		}
		
		public Boolean CourseHomePage(RemoteWebDriver driver)
		{
			return true;
		}
		
		public Boolean AccessingModulesPage(RemoteWebDriver driver)
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			try {
				e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("drpdwn_GoTo")));
				e.click();
				e=driver.findElement(objmap.getLocator("drpdwn_GoTo_Home"));
				e.click();
				ActionScrollDown(driver,1200);
				return true;
				} 
			catch (Exception e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
			
		}
		
		public Boolean CreateNewModule(RemoteWebDriver driver,String ModuleName)
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
			try 
			{
				e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_plusAddModule")));
				e.click();
				driver.findElement(objmap.getLocator("txt_NewModuleName")).sendKeys(ModuleName);
				driver.findElement(objmap.getLocator("btn_AddModuleButton")).click();
				return true;
			}
			catch (Exception e1)
			{
				
				e1.printStackTrace();
				return false;
			}
		}
		
		public Boolean CreateNewModuleItem(RemoteWebDriver driver,String ModuleName,String ModuleItem)
		{
			WebElement e;
			WebDriverWait wait=new WebDriverWait(driver,10);
			
			
			try
			{
				System.out.println("Module Item = "+ModuleItem);
				e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label,'"+ModuleName+"')]//button[contains(@class,'add_module_item_link btn')]")));
				e.click();
				e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("drpdown_moduleItemSelect")));
				Thread.sleep(1000);
				Select s=new Select(e);
				s.selectByVisibleText(ModuleItem);
				
				return true;
			}
			catch(Exception ex)
			{
				return false;
			}
		}
		
		public Boolean CreateNewAssignment(RemoteWebDriver driver,String AssignmentName,String ModuleName)
		{
			WebDriverWait wait=new WebDriverWait(driver,10);
//			e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@aria-label,'"+ModuleName+"')]//button[contains(@class,'add_module_item_link btn')]")));
//			e.click();
			
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
		
	
		
		public Boolean SettingPropertiesForAssignment(RemoteWebDriver driver,Object[] AssignmentDetails) throws InterruptedException
		{
			String AssignmentName=AssignmentDetails[1].toString();
			String AssignmentDesc=AssignmentDetails[2].toString();
			String Points=AssignmentDetails[3].toString();
			String SubmissionType=AssignmentDetails[4].toString();
			String SubType=AssignmentDetails[5].toString();
			Thread.sleep(5000);
			WebDriverWait wait=new WebDriverWait(driver,10);
			try
			{
				e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'"+AssignmentName+"')]")));
				e.click();
				e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_EditButtonAssignmentPage")));
				e.click();
				Thread.sleep(1000);
				e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_AssignmentPoints")));
				e.sendKeys(Points);
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
