package pageRepository;

import java.util.ArrayList;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;

public class UserGroupCreationPage {
	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	WebElement e;
	
	public UserGroupCreationPage(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//UserGroupCreationPage.properties");
		this.driver=driver;
		
	}
	
	public Boolean clickOnCreateUserGroup(RemoteWebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("lnk_CreateUserGroup")));
			//e=driver.findElement(objmap.getLocator("lnk_CreateUserGroup"));
			e.click();
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	public Boolean enterUserGroupDetails(RemoteWebDriver driver,String UserGrpName,String UserGrpDesc)
	{
		try 
		{
			e=driver.findElement(objmap.getLocator("txt_UserGrpName"));
			e.sendKeys(UserGrpName);
			e=driver.findElement(objmap.getLocator("txt_UserGrpDesc"));
			e.sendKeys(UserGrpDesc);
			e=driver.findElement(objmap.getLocator("btn_NextUserGrpDetails"));
			e.click();
			return true;
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public Boolean uploadUsers(RemoteWebDriver driver,String filePath)
	
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=driver.findElement(objmap.getLocator("btn_ChooseFile"));
			//e.click();
			Actions action = new Actions(driver); 
			action.sendKeys(Keys.TAB).build().perform();
			e.sendKeys(filePath);
			e=driver.findElement(objmap.getLocator("btn_BulkUpload"));
			e.click();
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_AddUsersPopUp")));
			e.click();
			Thread.sleep(2000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_NextAddUsers")));
			e.click();
			return true;
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	public Boolean chooseCoursesForUserGroup(RemoteWebDriver driver,ArrayList CourseName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			int l=CourseName.size();
			for(int i=0;i<l;i++)
			{
				e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'src-components-createUserGroup-form-___CourseToAssign__name___2vV_1') and contains(text(),'"+CourseName.get(i)+"')]")));
				e.click();
				Thread.sleep(2000);
			}
			
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_NextAddUsers")));
			e.click();
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public Boolean scheduleCourse(RemoteWebDriver driver,String StartDateTime,String EndDateTime)
	{
		try 
		{
//			Thread.sleep(1000);  
//			WebElement selectDate = driver.findElement(objmap.getLocator("date_SelectDate"));
//			selectDate.click();
//			//button to move next in calender
//			WebElement nextLink = driver.findElement(objmap.getLocator("lnk_nextDate"));
//			 //button to move previous month in calendar
//		    WebElement previousLink = driver.findElement(objmap.getLocator("lnk_previousDate")); 
//		    //Split the date time to get only the date part
//		    WebElement currentMonthYear = driver.findElement(objmap.getLocator("lbl_currentMonthYear"));
//		    System.out.println("The current month year = "+currentMonthYear.getText());
//	       // String Startdate_dd_MM_yyyy[] = (StartDateTime.split(" ")[0]).split("/");
//	        //get the year difference between current year and year to set in calander
//	        //int yearDiff = Integer.parseInt(Startdate_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
//	        Thread.sleep(1000);
		    
			  
			e=driver.findElement(objmap.getLocator("btn_NextScheduleCourses"));
			e.click();
			Thread.sleep(1000);
			return true;
		} 
		catch (Exception ex)
		{
			
			ex.printStackTrace();
			return false;
		}
		
		
	}
	
	public Boolean assignCourseFees(RemoteWebDriver driver)
	{
		try 
		{
			e=driver.findElement(objmap.getLocator("btn_Finish"));
			e.click();
			return true;
		} catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
	}
	
	
	
	

}
