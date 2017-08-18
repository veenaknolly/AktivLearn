package Utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class StartUp {
	
	public  RemoteWebDriver driver;
	
	
	public RemoteWebDriver setUp()
	{
		//this.driver=driver;
		System.out.println("inside start up");
		System.setProperty("webdriver.chrome.driver","/home/knolly/Downloads/Selenium Files/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
		
	}

}
