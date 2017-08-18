package pageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;

public class HomePage {
	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	
	WebElement e;
	
	public HomePage(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//HomePage.properties");
		this.driver=driver;
		
	}
	
	public Boolean clickOnAccount(RemoteWebDriver driver)
	{
		try 
		{
			e=driver.findElement(objmap.getLocator("lnk_veena'sSubaccount"));
			e.click();
			return true;
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public Boolean AddNewCourse(RemoteWebDriver driver,String CourseName)
	{
		Boolean[] result=new Boolean[3];
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_AddNewCourse")));
			e.click();
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_CourseName")));
			e.sendKeys(CourseName);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_AddCourse")));
			e.click();
			Thread.sleep(5000);
			//a[contains(@class,'course-tile')]//div[contains(text(),'"+CourseName+"')]
			e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class,'course-tile')]//div[contains(text(),'"+CourseName+"')]")));
			e.click();
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("$(\"#not_right_side\").animate({scrollTop: \"600px\"})");
			Thread.sleep(2000);
			return true;
			
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public Boolean ClickOnAktivLearnImg(RemoteWebDriver driver)
	{
		
		Boolean[] result=new Boolean[3];
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("imglnk_AktivLearn")));
			e.click();
			e=driver.findElement(objmap.getLocator("lnk_veena'sSubaccount"));
			e.click();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean clickOnCourses(RemoteWebDriver driver)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_Courses")));
			e.click();
		} 
		catch (Exception e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return true;
	}
	
	public Boolean selectCourseFromList(RemoteWebDriver driver,String CourseName)
	{
		
		Boolean[] result=new Boolean[3];
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			ClickOnAktivLearnImg(driver);
			clickOnCourses(driver);
			e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[contains(@class,'courses')]//div[contains(text(),'"+CourseName+"')]")));
			e.click();
			Thread.sleep(2000);
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean ClickOnManageUserGroupsButton(RemoteWebDriver driver)
	{
		
		Boolean[] result=new Boolean[3];
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_UserGroups")));
			e.click();
		return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void deleteCourse(RemoteWebDriver driver,String CourseName)
	{
		Boolean result=false;
		selectCourseFromList(driver,CourseName);
		
		
	}

}
