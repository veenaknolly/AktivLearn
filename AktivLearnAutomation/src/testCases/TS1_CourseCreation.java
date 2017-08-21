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
	 public void testStep8_CreateTextHeader_ContentPagesForModule1() throws InterruptedException
	 {
		 Boolean result=false;
	 	result=crs.CreateNewModuleItem(driver, "Module1", "Text header");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=tx.CreateNewTextHeader(driver, "Content Pages");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		
	 }
 
	 @Test(priority=36)
	 public void testStep12_CreatePageHTMLForModule1()
	 {
	 	Boolean result=false;
	 	result=crs.CreateNewModuleItem(driver, "Module1", "Content Page");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=cnt.CreateNewPage(driver, "Content Page-HTML");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=cnt.clickOnEditButtonPage(driver, "Content Page-HTML");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	cnt.saveChanges(driver);
	 	crs.AccessingModulesPage(driver);
	 	
	 }
	 @Test(priority=37)
	 public void testStep_CreatePageVideoForModule1()
	 {
	 	Boolean result=false;
	 	result=crs.CreateNewModuleItem(driver, "Module1", "Content Page");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=cnt.CreateNewPage(driver, "Content Page-Video");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=cnt.clickOnEditButtonPage(driver, "Content Page-Video");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=cnt.selectLinktoURL(driver,"https://www.youtube.com/watch?v=tdE2-xI3VNE");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	cnt.saveChanges(driver);
	 	crs.AccessingModulesPage(driver);
	 	
	 	
	 }
	 @Test(priority=38)
	 public void testStep_CreatePageImageForModule1()
	 {
	 	Boolean result=false;
	 	result=crs.CreateNewModuleItem(driver, "Module1", "Content Page");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=cnt.CreateNewPage(driver, "Content Page-Image");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=cnt.clickOnEditButtonPage(driver, "Content Page-Image");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=cnt.selectLinktoURL(driver,"http://seasonzindia.in/Sales/Images/Kerala%20honeymoon%20tour%20Packages.jpg");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	cnt.saveChanges(driver);
	 	crs.AccessingModulesPage(driver);
	 	
	 	
 }
	 @Test(priority=39)
	 public void testStep8_CreateTextHeader_QuizzesForModule1() throws InterruptedException
	 {
		 Boolean result=false;
	 	result=crs.CreateNewModuleItem(driver, "Module1", "Text header");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=tx.CreateNewTextHeader(driver, "Quizzes");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 }		
	 
	 @Test(priority=40)
	 public void testStep9_CreateNormalQuizForModule1()
	 {
		 Boolean result=false;
	 	try
	 	{
	 	
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

	 @Test(priority=41)
	 public void testStep10_CreateGameQuizForModule1()
	 {
	 	Boolean result=false;
	 	
	 	
	 	try
	 	{
	 		Thread.sleep(1000);
	 		result=crs.CreateNewModuleItem(driver, "Module1", "Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.CreateNewQuiz(driver, "Game Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.clickOnEditButtonForQuiz(driver, "Game Quiz");
		 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.SetGameQuiz(driver, "jumpshot");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.setQuestionBank(driver, "True Or False");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		Thread.sleep(2000);
	 		result=qz.AccessingModulesPage(driver);
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		Thread.sleep(3000);

	 	}
	 	 catch (InterruptedException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 }
	 
	 @Test(priority=42)
	 public void testStep10_CreateTimeQuizForModule1()
	 {
	 	Boolean result=false;
	 	
	 	
	 	try
	 	{
	 		Thread.sleep(1000);
	 		result=crs.CreateNewModuleItem(driver, "Module1", "Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.CreateNewQuiz(driver, "Time Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.clickOnEditButtonForQuiz(driver, "Time Quiz");
		 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.SetTimeLimit(driver, "2");
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

	 @Test(priority=43)
	 public void testStep_CreateUngradedSurveyQuizForModule1()
	 {
	 	Boolean result=false;
	 	
	 	
	 	try
	 	{
	 		Thread.sleep(1000);
	 		result=crs.CreateNewModuleItem(driver, "Module1", "Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.CreateNewQuiz(driver, "Ungraded Survey Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.clickOnEditButtonForQuiz(driver, "Ungraded Survey Quiz");
		 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.selectQuizType(driver, "Ungraded survey");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
//	 		result=qz.SetQuizDesc(driver, "1914 translation by H. Rackham\\n\" + \n" + 
//	 				"					\"\\\"But I must explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you a complete account of the system, and expound the actual teachings of the great explorer of the truth, the master-builder of human happiness. No one rejects, dislikes, or avoids pleasure itself, because it is pleasure, but because those who do not know how to pursue pleasure rationally encounter consequences that are extremely painful. Nor again is there anyone who loves or pursues or desires to obtain pain of itself, because it is pain, but because occasionally circumstances occur in which toil and pain can procure him some great pleasure. To take a trivial example, which of us ever undertakes laborious physical exercise, except to obtain some advantage from it? But who has any right to find fault with a man who chooses to enjoy a pleasure that has no annoying consequences, or one who avoids a pain that produces no resultant pleasure?\\\"\"");
//	 		Assert.assertEquals((Boolean)result, (Boolean)true);
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

	 @Test(priority=44)
	 public void testStep10_CreateExpiredQuizForModule1()
	 {
	 	Boolean result=false;
	 	
	 	
	 	try
	 	{
	 		Thread.sleep(1000);
	 		result=crs.CreateNewModuleItem(driver, "Module1", "Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.CreateNewQuiz(driver, "Expired Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.clickOnEditButtonForQuiz(driver, "Expired Quiz");
		 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.setDatesForQuiz(driver, "7 Jul at 11:30", "7 Aug at 11:30", "1 Aug at 11:30");
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
	 
	 @Test(priority=45)
	 public void testStep_CreateFutureQuizForModule1()
	 {
	 	Boolean result=false;
	 	
	 	
	 	try
	 	{
	 		Thread.sleep(1000);
	 		result=crs.CreateNewModuleItem(driver, "Module1", "Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.CreateNewQuiz(driver, "Future Quiz");
	 		Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.clickOnEditButtonForQuiz(driver, "Future Quiz");
		 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		result=qz.setDatesForQuiz(driver, "7 Nov at 11:30", "7 Jan 2018 at 11:30", "15 Dec at 11:30");
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
	 	result=tx.CreateNewTextHeader(driver, "Others");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 		
	 }
	 
	 @Test(priority=52)
	 public void testStep_ExternalURLtForModule1() throws InterruptedException
	 {
		 Boolean result=false;
	 	
	 	result=crs.CreateNewModuleItem(driver, "Module2", "External URL");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=exturl.setTitle(driver, "THe title");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	Thread.sleep(2000);
	 	result=exturl.selectURLContentType(driver, "video");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);
	 	result=exturl.createNewExternalURLItem(driver, "https://www.youtube.com/watch?v=JGwWNGJdvx8");
	 	Assert.assertEquals((Boolean)result, (Boolean)true);	
	 }
	 @Test(priority=53)
	 public void testStep8_CreateAssignmentForModule2()
	 {
		 Boolean result=false;
	 	
	 	try {
	 	result=crs.CreateNewModuleItem(driver, "Module2", "Assignment");
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
