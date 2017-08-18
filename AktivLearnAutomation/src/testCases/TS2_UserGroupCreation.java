package testCases;

import org.testng.annotations.Test;

import Utils.ExcelUtil;
import Utils.StartUp;
import pageRepository.Course;
import pageRepository.HomePage;
import pageRepository.LaunchingPage;
import pageRepository.Quiz;
import pageRepository.UserGroupCreationPage;

import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TS2_UserGroupCreation {
	
	public RemoteWebDriver driver;
	String adminID,adminpwd,CourseName,UserGroupName,UserGroupDesc,CSVFilePath;
	StartUp st=new StartUp();
	LaunchingPage launchobj=new LaunchingPage(driver);
	HomePage hm=new HomePage(driver);
	Course crs=new Course(driver);
	Quiz qz=new Quiz(driver);
	ExcelUtil ex=new ExcelUtil();
	UserGroupCreationPage uspg=new UserGroupCreationPage(driver);
	ArrayList<String> CourseNameList = new ArrayList<String>();
	String path_TestDataExcel="/home/knolly/eclipse-workspace/AktivLearnAutomation/src/dataRepository/TestData.xlsx";
	
	@BeforeClass
	 
	public void Prereqs() 
	{
		ex.CreateXLSLibrary(path_TestDataExcel);
		int Course_IDColNo=ex.getColumnNumber("Overall", "Course ID");
		System.out.println("Course_IDColNo= "+Course_IDColNo);
		int RowNumOverall=ex.getRowNum("Overall",0, "TS1");
		System.out.println("RowNumOverall= "+RowNumOverall);
		String course_id=ex.getCellData("Overall", Course_IDColNo, RowNumOverall);
		int User_IDColNoOverall=ex.getColumnNumber("Overall", "User Group ID");
		String UserGroup_ID=ex.getCellData("Overall", User_IDColNoOverall, RowNumOverall);
		int RowNumCourse=ex.getRowNum("Course", 0, course_id);
		CourseName=ex.getCellData("Course", 1, RowNumCourse);
		adminID=ex.getCellData("Overall", 1, RowNumOverall);
		adminpwd=ex.getCellData("Overall", 2, RowNumOverall);
		System.out.println("UserGroup_ID= "+UserGroup_ID);
		System.out.println("Course ID ="+course_id);
		
		int RowNumUserGrp=0;
		int RowCountUserGrp=ex.getRowCount("User Group");
		System.out.println("RowCountUserGrp="+RowCountUserGrp);
		for(int i=0;i<RowCountUserGrp;i++)
		{
			if(ex.getCellData("User Group", 0,i ).equalsIgnoreCase(UserGroup_ID)&&
					ex.getCellData("User Group", 4,i ).equalsIgnoreCase(course_id))
			{
				System.out.println("i= "+i);
				RowNumUserGrp=i;
				break;
			}
		}
		RowNumUserGrp++;
		System.out.println("Row Num User Grp ="+RowNumUserGrp);
		UserGroupName=ex.getCellData("User Group", 1, RowNumUserGrp+1);
		UserGroupDesc=ex.getCellData("User Group", 2, RowNumUserGrp+1);
		CSVFilePath=ex.getCellData("User Group", 3, RowNumUserGrp+1);
		System.out.println("UserGroupName = "+UserGroupName);
		System.out.println("UserGroupDesc = "+UserGroupDesc);
		System.out.println("CSVFilePath ="+CSVFilePath);
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
 public void testStep3_loginToAktivLearn()
 {
	 Boolean result=false;
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
 
 @Test (priority=5)
 public void testStep5_ClickOnManagerUserGroups() throws InterruptedException
 {
	 Boolean result=false;
	 result=hm.ClickOnManageUserGroupsButton(driver);
	 Thread.sleep(3000);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
	 	 
 }
 
 @Test(priority=6)
 public void testStep6_clickOnCreateUserGroup() throws InterruptedException
 {
	 Boolean result=false;
	 result=uspg.clickOnCreateUserGroup(driver);
	 Thread.sleep(2000);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
 }

 
 @Test(priority=7)
 public void testStep7_enterUserGroupDetails() throws InterruptedException
 {
	 Boolean result=false;
	 result=uspg.enterUserGroupDetails(driver, UserGroupName, UserGroupDesc);
	 Thread.sleep(2000);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
 }
 
 @Test(priority=8)
 public void testStep8_uploadUsers() throws InterruptedException
 {
	 Boolean result=false;
	 result=uspg.uploadUsers(driver, CSVFilePath);
	 Thread.sleep(2000);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
	 	 
 }
 
 @Test(priority=9)
 public void testStep9_chooseCoursesForUserGroup() throws InterruptedException
 {
	 Boolean result=false;
	 CourseNameList.add(CourseName);
	 result=uspg.chooseCoursesForUserGroup(driver, CourseNameList);
	 Thread.sleep(1000);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
 }
 @Test(priority=10)
 public void testStep10_scheduleCourse()
 {
	 Boolean result=false;
	 result=uspg.scheduleCourse(driver, "", "");
	 Assert.assertEquals((Boolean)result, (Boolean)true);
	 
 }
 @Test(priority=11)
 public void testStep11_assignCourseFees()
 {
	 Boolean result=false;
	 result=uspg.assignCourseFees(driver);
	 Assert.assertEquals((Boolean)result, (Boolean)true);
	 
 }
 
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
