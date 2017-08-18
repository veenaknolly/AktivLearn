package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

public class KeyWordLib {
	
	
	public void ActionScrollDown(RemoteWebDriver driver,int pixel)
	{
		//int p=1200;
		try
		{
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("$(\"#not_right_side\").animate({scrollTop: \""+pixel+"px\"})");
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

}
