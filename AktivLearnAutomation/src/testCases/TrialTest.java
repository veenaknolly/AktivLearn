package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

public class TrialTest {
	
	RemoteWebDriver driver;
  @Test
  public void f() {
	  
	  driver.get("https://staging.aktivlearn.com/");
	  
	  
  }
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

}
