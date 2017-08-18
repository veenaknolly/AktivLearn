package testCases;

import org.testng.annotations.Test;

import Utils.ExcelUtil;
import Utils.StartUp;
import pageRepository.AssignmentPage;
import pageRepository.ContentPage;
import pageRepository.Course;
import pageRepository.DiscussionPage;
import pageRepository.ExternalLink;
import pageRepository.File;
import pageRepository.HomePage;
import pageRepository.LaunchingPage;
import pageRepository.Quiz;
import pageRepository.TextHeader;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;
// Test Case for Sscenario 1
public class TS1_CourseCreation {
	RemoteWebDriver driver;
	String adminID,adminpwd,CourseName;
	StartUp st=new StartUp();
	LaunchingPage launchobj=new LaunchingPage(driver);
	HomePage hm=new HomePage(driver);
	Course crs=new Course(driver);
	AssignmentPage assgn=new AssignmentPage(driver);
	Quiz qz=new Quiz(driver);
	File fl=new File(driver);
	TextHeader tx=new TextHeader(driver);
	ContentPage cnt=new ContentPage(driver);
	ExternalLink exturl=new ExternalLink(driver);
	DiscussionPage ds=new DiscussionPage(driver);
	
	@BeforeClass
	  public void beforeClass() {
		driver=st.setUp();
	  }
	 @Test(priority=0)
	  public void testStep1_navigateToAktivLearn() throws Exception
	  {
		  Boolean result=false;
		  result=launchobj.navigateToAktivLearn(driver);
		  Assert.assertEquals((Boolean)result, (Boolean)true);
	  }
	  
	  @Test(priority=5)
	  public void testStep2_clickOnStartPlaying()
	  {
		  Boolean result=false;
			// Thread.sleep(2000);
			 result=launchobj.clickOnStartPlaying(driver);
			 Assert.assertEquals((Boolean)result, (Boolean)true);
		  
	  }
	  
	  @Test(priority=10)
	  public void testStep3_logintoAktivLearn()
	  {
		  Boolean result=false;
			// Thread.sleep(2000);
			 result=launchobj.loginToAktivLearn(driver, "veenaknolly@mailinator.com", "qwerty");
			 Assert.assertEquals((Boolean)result, (Boolean)true);
		  
	  }
	  
	 @Test(priority=15)
	 public void testStep4_clickOnAccount()
	 {
		 Boolean result=false;
		 result=hm.clickOnAccount(driver);
		 Assert.assertEquals((Boolean)result, (Boolean)true);
	 }
	 
	 @Test(priority=20)
	 public void testStep5_clickOnCourses()
	 {
		 Boolean result=false;
		 result=hm.clickOnCourses(driver);
		 Assert.assertEquals((Boolean)result, (Boolean)true);
	 }
	 
	 @Test(priority=25)
	 public void testStep6_AddNewCourse()
	 {
		 Boolean result=false;
		// System.out.println("Course Name "+ CourseName);
		 result=hm.AddNewCourse(driver,"Course_auto1");
		 Assert.assertEquals((Boolean)result, (Boolean)true);
		 
	 }
	 @Test(priority=30)
	 public void testStep7_CreateNewModule() throws InterruptedException
	 {
	 	Boolean result=false;
	 		result=crs.CreateNewModule(driver,"Module1");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=crs.CreateNewModule(driver,"Module2");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		Thread.sleep(2000);
	 }
	 @Test(priority=35)
	 public void testStep8_CreateTextHeaderForModule1() throws InterruptedException
	 {
		 Boolean result=false;
	 	result=crs.CreateNewModuleItem(driver, "Module1", "Text header");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=tx.CreateNewTextHeader(driver, "Header1");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		
	 }
	 @Test(priority=40)
	 public void testStep8_CreateAssignmentForModule1()
	 {
		 Boolean result=false;
	 	
	 	try {
	 	result=crs.CreateNewModuleItem(driver, "Module1", "Assignment");
	 	result=assgn.CreateNewAssignment(driver, "Assign1");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	//result=assgn.SettingPropertiesForAssignment(driver, "Assign1");
	 	result=assgn.clickOnEditButtonOfAssignment(driver, "Assign1");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=assgn.setAssignmentPoints(driver, "20");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=assgn.clickOnSaveButton(driver);
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	Thread.sleep(2000);
	 	crs.AccessingModulesPage(driver);

	 	} catch (InterruptedException e) {
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		
	 }
	 
	 @Test(priority=41)
	 public void testStep_ExternalURLtForModule1() throws InterruptedException
	 {
		 Boolean result=false;
	 	
	 	result=crs.CreateNewModuleItem(driver, "Module1", "External URL");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=exturl.setTitle(driver, "THe title");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	Thread.sleep(2000);
	 	result=exturl.selectURLContentType(driver, "video");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=exturl.createNewExternalURLItem(driver, "https://www.youtube.com/watch?v=JGwWNGJdvx8");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);	
	 }

	 @Test(priority=45)
	 public void testStep9_CreateQuizForModule1()
	 {
		 Boolean result=false;
	 	try
	 	{
	 	
//	 	result=qz.AccessingModulesPage(driver);
//	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=crs.CreateNewModuleItem(driver, "Module1", "Quiz");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=qz.CreateNewQuiz(driver, "Normal Quiz");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	Thread.sleep(2000);
	 	result=qz.clickOnEditButtonForQuiz(driver, "Normal Quiz");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=qz.setQuestionBank(driver, "True Or False");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	Thread.sleep(1000);
	 	result=qz.AccessingModulesPage(driver);
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	
	 	}
	 	catch (InterruptedException e) 
	 	{
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 	
	 }

	 @Test(priority=52)
	 public void testStep10_CreateQuizForModule2()
	 {
	 	Boolean result=false;
	 	
	 	
	 	try
	 	{
	 		Thread.sleep(1000);
	 		result=crs.CreateNewModuleItem(driver, "Module2", "Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.CreateNewQuiz(driver, "Game Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.clickOnEditButtonForQuiz(driver, "Game Quiz");
		 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.SetTimeLimit(driver, "2");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.SetGameQuiz(driver, "jumpshot");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.setQuestionBank(driver, "True Or False");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		Thread.sleep(2000);
	 		result=qz.AccessingModulesPage(driver);
	 		Assert.assertEquals((Boolean)result, (Boolean)true);

	 	}
	 	 catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 }

	 @Test(priority=51)
	 public void testStep9_CreateTextHeaderForModule2() throws InterruptedException
	 {
		 Boolean result=false;
	 	
	 	result=crs.CreateNewModuleItem(driver, "Module2", "Text header");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=tx.CreateNewTextHeader(driver, "Header2");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		
	 }
	 @Test(priority=55)
	 public void testStep11_CreateFileForModule2()
	 {
	 	Boolean result=false;
	 	result=crs.CreateNewModuleItem(driver, "Module2", "File");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=fl.CreateNewFileItem(driver, "FileTitle","FileDesc","/home/knolly/Downloads/aktivlearn_sample_user_upload_csv.csv");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	
	 }
	 @Test(priority=56)
	 public void testStep_CreateDiscussionForModule2()
	 {
		 Boolean result=false;
	 	try {
	 	
	 	result=crs.CreateNewModuleItem(driver, "Module2", "Discussion");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=ds.CreateNewDiscussion(driver, "DiscussionName");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	Thread.sleep(1000);
	 	
	 		} 
	 	catch (InterruptedException e) 
	 	{
	 		// TODO Auto-generated catch block
	 		e.printStackTrace();
	 	}
	 	
	 }

	 @Test(priority=60)
	 public void testStep12_CreatePageForModule2()
	 {
	 	Boolean result=false;
	 	result=crs.CreateNewModuleItem(driver, "Module2", "Content Page");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=cnt.CreateNewPage(driver, "PageForModule2");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	
	 }
  @AfterClass
  public void afterClass() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
