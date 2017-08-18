package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Utils.ExcelUtil;
import Utils.StartUp;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;

import org.testng.annotations.Test;

import pageRepository.AssignmentPage;
import pageRepository.Course;
import pageRepository.File;
import pageRepository.HomePage;
import pageRepository.LaunchingPage;
import pageRepository.Quiz;

import org.testng.annotations.BeforeClass;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TS1_CreatingCourseModule {
	
	RemoteWebDriver driver;
	String adminID,adminpwd,CourseName;
	StartUp st=new StartUp();
	LaunchingPage launchobj=new LaunchingPage(driver);
	HomePage hm=new HomePage(driver);
	Course crs=new Course(driver);
	AssignmentPage assgn=new AssignmentPage(driver);
	Quiz qz=new Quiz(driver);
	ExcelUtil ex=new ExcelUtil();
	File fl=new File(driver);
	int rowcount_ts1,RowNum,ItemRowNum,ColumnIndex,ColNoModuleItemPage,RowNoModuleItemPage;
	String MName,Asgn_ID,Quiz_ID,AssignName,ModuleItemID;
	String FileTitle,FileDesc,FilePath;
	String QuizName;
	String path_TestDataExcel="/home/knolly/eclipse-workspace/AktivLearnAutomation/src/dataRepository/TestData.xlsx";



@BeforeClass
 
public void BeforeClass() 
{
	
	ex.CreateXLSLibrary(path_TestDataExcel);
	RowNum=ex.getRowNum("Overall",0, "TS1");
	String course_id=ex.getCellData("Overall", 5, RowNum);
	int CourseRowNum=ex.getRowNum("Course", 0, course_id);
	System.out.println("Course Row Num "+CourseRowNum);
	CourseName=ex.getCellData("Course", 1, CourseRowNum);
	System.out.println("Course ID "+course_id);
	System.out.println("The Row number is "+ RowNum);
	adminID=ex.getCellData("Overall", 1, RowNum);
	adminpwd=ex.getCellData("Overall", 2, RowNum);
	System.out.println("Admin Name="+adminID);
	System.out.println("Admin Pwd="+adminpwd);
	rowcount_ts1=ex.getRowCountForTestScenario("Overall", "TS1");
	System.out.println("Row Count For TS1="+ ex.getRowCountForTestScenario("Overall", "TS1"));
	String[][] overall=new String[10][10];
	driver=st.setUp();
	
}

  @Test(priority=1)
  public void testStep1_navigateToAktivLearn() throws Exception
  {
	  Boolean result=false;
	  result=launchobj.navigateToAktivLearn(driver);
	  Assert.assertEquals((Boolean)result, (Boolean)true);
  }
  
  @Test(priority=2)
  public void testStep2_clickOnStartPlaying()
  {
	  Boolean result=false;
	  result=launchobj.clickOnStartPlaying(driver);
	  Assert.assertEquals((Boolean)result, (Boolean)true);
	  
  }
  
 @Test (priority=3)
 public void testStep3_loginToAktivLearn() throws InterruptedException
 {
	 Boolean result=false;
	// Thread.sleep(2000);
	 result=launchobj.loginToAktivLearn(driver,adminID , adminpwd);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
	 	 
 }
 
 @Test(priority=4)
 public void testStep4_clickOnAccount()
 {
	 Boolean result=false;
	 result=hm.clickOnAccount(driver);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
 }
 
 @Test(priority=5)
 public void testStep5_clickOnCourses()
 {
	 Boolean result=false;
	 result=hm.clickOnCourses(driver);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
 }
 
 @Test(priority=6)
 public void testStep6_AddNewCourse()
 {
	 Boolean result=false;
	// System.out.println("Course Name "+ CourseName);
	 result=hm.AddNewCourse(driver,CourseName);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
	 
 }
 
@Test(priority=7)
public void testStep7_CreateNewModule() throws InterruptedException
{
	Boolean result=false;
	
	for(int i=0;i<rowcount_ts1;i++)
	{
		
		MName=ex.getCellData("Overall", 6, RowNum+i);
		result=crs.CreateNewModule(driver, MName);
		Assert.assertEquals((Boolean)result, (Boolean)true);
		Thread.sleep(2000);
	}
	
}

@Test(priority=8)

public void testStep8_CreateAssignmentForModule1()
{
	System.out.println("Inside Step7");
	Boolean result=false;
	Object[] AssignmentDetails=new Object[10];
	int ColumnCountOfItem;
	MName=ex.getCellData("Overall", 6, RowNum);
	Asgn_ID=ex.getCellData("Overall", 7, RowNum);
	ColumnCountOfItem=ex.getColumnCount("Assignment");
	System.out.println("ColumnCountOfItem "+ ColumnCountOfItem);
	//String ItemValue=getItemValue("SheetName",ColumnOfID,ColumnOfValue,ID);
	//ItemRowNum=ex.getRowNum("Assignment",0, Asgn_ID);
	
	for(int i =1;i<ColumnCountOfItem;i++)
	{
		System.out.println("Inside loop "+ i);
		AssignmentDetails[i]=ex.getItemValue("Assignment", 0,i,Asgn_ID);
		//System.out.println();
	}
	
	try {
	result=crs.CreateNewModuleItem(driver, MName, "Assignment");
	result=assgn.CreateNewAssignment(driver, AssignmentDetails[1].toString());
	Assert.assertEquals((Boolean)result, (Boolean)true);
	result=assgn.SettingPropertiesForAssignment(driver, "Assign1");
		//Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Assert.assertEquals((Boolean)result, (Boolean)true);
		
}

@Test(priority=9)
public void testStep9_CreateQuizForModule1()
{
	System.out.println("Inside Step 8 ");
	Boolean result=false;
	ModuleItemID=ex.readDataFromOverall("TS1", "Module_1", "Quiz ID");
	QuizName=ex.getItemValueOtherSheet("Quiz", 0, "QUIZ NAME", ModuleItemID);
	//int ColumnCountOfItem;
	//Object[] QuizDetails=new Object[20];
	//MName=ex.getCellData("Overall", 6, RowNum);
	//Quiz_ID=ex.getCellData("Overall", 8, RowNum);
	//System.out.println("Quiz_ID"+Quiz_ID );
	//ColumnCountOfItem=ex.getColumnCount("Quiz");
	//System.out.println();
	//for(int i =1;i<ColumnCountOfItem;i++)
	//{
		//System.out.println("Inside loop "+ i);
		//QuizDetails[i]=ex.getItemValue("Quiz", 0,i,Quiz_ID);
		////System.out.println();
	//}
	try {
	
	result=qz.AccessingModulesPage(driver);
	Assert.assertEquals((Boolean)result, (Boolean)true);
	result=crs.CreateNewModuleItem(driver, "Module_1", "Quiz");
	Assert.assertEquals((Boolean)result, (Boolean)true);
	result=qz.CreateNewQuiz(driver, QuizName);
	Assert.assertEquals((Boolean)result, (Boolean)true);
	Thread.sleep(3000);
	result=qz.SettingPropertiesForQuiz(driver, QuizName);
	Assert.assertEquals((Boolean)result, (Boolean)true);
		} 
	catch (InterruptedException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

@Test(priority=10)
public void testStep10_CreateQuizForModule2()
{
	//System.out.println("Inside step 9 ");
	ModuleItemID=ex.readDataFromOverall("TS1", "Module_2", "Quiz ID");
	QuizName=ex.getItemValueOtherSheet("Quiz", 0, "QUIZ NAME", ModuleItemID);
	System.out.println("Module Item ID = "+ModuleItemID);
	System.out.println("QuizName= "+QuizName);
	//int RowNumForMod2=ex.getRowNum("Overall", 6, "Module_2");
	//System.out.println("RowNumForMod2 = "+ RowNumForMod2);
	Boolean result=false;
	//int ColumnCountOfItem;
	//Object[] QuizDetails=new Object[20];
	//MName=ex.getCellData("Overall", 6, RowNumForMod2);
	//Quiz_ID=ex.getCellData("Overall", 8, RowNumForMod2);
	//ColumnCountOfItem=ex.getColumnCount("Quiz");
	//for(int i =1;i<ColumnCountOfItem;i++)
	//{
		//System.out.println("Inside loop "+ i);
		//QuizDetails[i]=ex.getItemValue("Quiz", 0,i,Quiz_ID);
		//System.out.println();
	//}
	
	result=qz.AccessingModulesPage(driver);
	Assert.assertEquals((Boolean)result, (Boolean)true);
	try {
		Thread.sleep(2000);
		result=crs.CreateNewModuleItem(driver, "Module_2", "Quiz");
		Assert.assertEquals((Boolean)result, (Boolean)true);
		Thread.sleep(1000);
		result=qz.CreateNewQuiz(driver, QuizName);
		Assert.assertEquals((Boolean)result, (Boolean)true);
//		result=qz.SettingPropertiesForQuiz(driver, QuizDetails);
//		Assert.assertEquals((Boolean)result, (Boolean)true);
		
		Thread.sleep(2000);
	}
	 catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}

@Test(priority=11)
public void testStep11_CreatePageForModule2()
{
	Boolean result=false;
	//System.out.println("Hi");
	ColumnIndex=ex.getColumnNumber("Overall","File ID" );
	ModuleItemID=ex.readDataFromOverall("TS1", "Module_2", "File ID");	
	//System.out.println("The Column Value in Overall is "+ ex.readDataFromOverall("TS1", "Module_2", "File ID"));
	result=crs.CreateNewModuleItem(driver, "Module_2", "File");
	Assert.assertEquals((Boolean)result, (Boolean)true);
	FileTitle=ex.getItemValueOtherSheet("File", 0, "File Title", ModuleItemID);
	FileDesc=ex.getItemValueOtherSheet("File", 0, "File Description", ModuleItemID);
	FilePath=ex.getItemValueOtherSheet("File", 0, "File Path", ModuleItemID);
	result=fl.CreateNewFileItem(driver, FileTitle,FileDesc,FilePath);
	Assert.assertEquals((Boolean)result, (Boolean)true);
	
}



//@Test
//public void testStep10_ExitingBrowser()
//{
//	driver.quit();
//}

  @AfterClass
  public void afterClass() {
	  
	driver.quit();
	
  }

  

@BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
