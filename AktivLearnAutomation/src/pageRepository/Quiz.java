package pageRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.CreateObjectMap;
import Utils.KeyWordLib;

public class Quiz extends KeyWordLib {
	public CreateObjectMap objmap;
	public RemoteWebDriver driver;
	
	WebElement e;
	
	public Quiz(RemoteWebDriver driver) 
	{
		this.objmap=new CreateObjectMap(System.getProperty("user.dir")+"//src//UIMap//Quiz.properties");
		this.driver=driver;
		
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
	
	public Boolean CreateNewQuiz(RemoteWebDriver driver,String QuizName)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);

		
		try 
		{
			Thread.sleep(2000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("lnk_NewQuiz")));
			//Thread.sleep(1000);
			e.click();
			Thread.sleep(1000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_NewQuizName")));
			e.clear();
			e.sendKeys(QuizName);
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
	public Boolean SettingPropertiesForQuiz(RemoteWebDriver driver,String QuizName) throws InterruptedException
	{
	
		
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			Thread.sleep(2000);
			e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'"+QuizName+"')]")));
			e.click();
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_EditButtonQuizPage")));
			e.click();
			ActionScrollDown(driver,1200);
			e=driver.findElement(objmap.getLocator("btn_Save"));
			e.click();
			Thread.sleep(2000);
//			e=driver.findElement(objmap.getLocator("btn_BackBtn"));
//			e.click();
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean clickOnEditButtonForQuiz(RemoteWebDriver driver,String QuizName) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		Thread.sleep(2000);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title,'"+QuizName+"')]")));
			e.click();
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_EditButtonQuizPage")));
			e.click();
		} 
		catch (Exception e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		return true;
	}
	public Boolean SetTimeLimit(RemoteWebDriver driver,String TimeLimit )
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("chk_TimeLimit")));
			e.click();
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_TimeLimit")));
			e.sendKeys(TimeLimit);
			
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public Boolean clickOnSaveButton(RemoteWebDriver driver)
	{
		ActionScrollDown(driver,1200);
		try 
		{
			e=driver.findElement(objmap.getLocator("btn_Save"));
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
	
	public Boolean setQuestionBank(RemoteWebDriver driver,String TypeOfQuestion)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			//Click on the Questions tab 
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("tab_Questions")));
			e.click();
			
			//Click on New Questions Group
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_NewQuestionGroup")));
			e.click();
			
			//Click on Link to Q bank 
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("lnk_LinktoQbank")));
			e.click();
			
			//Select the Qbank 
			e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+TypeOfQuestion+"')]")));
			e.click();
			
			//Click on SelectBank
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_SelectBank")));
			e.click();
			
			//Click on Create Group
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_CreateGroup")));
			e.click();
			Thread.sleep(1000);
			//Click on Save 
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("btn_SaveQBank")));
			e.click();
			
			
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public Boolean SetGameQuiz(RemoteWebDriver driver,String GameType )
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("chk_IsitAGame")));
			e.click();
			e=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'"+GameType+"')]")));
			e.click();
			return true;
			
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean SetQuizDesc(RemoteWebDriver driver,String QuizDesc )
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_QuizDesc")));
			e.sendKeys(QuizDesc);
			return true;
			
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		
	}
	
	public Boolean selectQuizType(RemoteWebDriver driver,String QuizType)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try 
		{
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("drpdwn_QuizType")));
			Select s=new Select(e);
			s.selectByVisibleText(QuizType);
			return true;
		}
		catch(Exception e1)
		{
			e1.printStackTrace();
			return false;
		}
	}
		
	
	public Boolean setDatesForQuiz(RemoteWebDriver driver,String StartDateTime,String EndDateTime,String DueDateTime)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		try 
		{
			Thread.sleep(2000);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_DueDate")));
			e.sendKeys(DueDateTime);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_StartDate")));
			e.clear();
			e.sendKeys(StartDateTime);
			e=wait.until(ExpectedConditions.elementToBeClickable(objmap.getLocator("txt_EndDate")));
			e.clear();
			e.sendKeys(EndDateTime);	
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
