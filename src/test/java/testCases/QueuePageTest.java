package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.QueuePage;
import pageObjects.SignInPage;

import utility.Log;

public class QueuePageTest extends BaseClass{		
		
		public GetStartedPage getStartedObj = null;
		public HomePage homepageObj = null;
		public SignInPage signinObj=null;
		public QueuePage queuepageobj=null;
			
			
		@BeforeClass
		public void openinglink() throws InterruptedException
		{
		
			//Thread.sleep(10000l);
		}
		@AfterClass
		public void closing()
		{
			getDriver().quit();
		}
		@BeforeMethod
		public void setup() {
			launchApp();
			getStartedObj = new GetStartedPage();
			homepageObj = getStartedObj.getStarted();
			signinObj = homepageObj.clickOnSignInLink();
			signinObj.signin("swathik","Lokitakshaa");
			
			Log.info("clicking on Queue getstarted link"); 
			queuepageobj =new QueuePage();
			queuepageobj.ClickonQueue();
			//Log.info("starting test case");
		}
		
		@AfterMethod
		public void tearDown() {
			
			getDriver().quit();
	     }
			
		@Test(priority =1)
		@Severity(SeverityLevel.NORMAL)
	    @Description("QueuePage Page Test")
		 @Story("Story Name:QueuePage URL Check")	
		public void QueuePageURL() {
				
				Log.startTestCase("QueuePageURL");
//				getStartedObj= new GetStarted();
//				Log.info("user is going on Home Page");
//				homepageObj=getStartedObj.clickonGetStarted();
//				Log.info("user is going to click on QueuePage Link");
//				queuepageobj = homepageObj.clickonQueue();
				String actualURL=queuepageobj.getCurURL();
				String expectedURL="https://dsportalapp.herokuapp.com/queue/";
				Log.info("Verifying if user is on Stack Page");
				Assert.assertEquals(actualURL, expectedURL);
				Log.info("Test Successful");
				Log.endTestCase("QueuePageURL");
				
			}

		@Test(priority =2,dataProvider = "PyCode", dataProviderClass = DataProviders.class)
		@Severity(SeverityLevel.NORMAL)
	    @Description("Queue Page Test")
		 @Story("Story Name:Implementation Of Queue in Python Check")   
		public void ImplementationOfQueueinPython(String s2,String op) throws Exception {
				
				Log.startTestCase("ImplementationOfQueueinPythonURL");
				queuepageobj.impofQueueinPython();		
			    String actualURL=queuepageobj.getCurURL();
				String expectedURL="https://dsportalapp.herokuapp.com/queue/implementation-lists/";
				Log.info("Verifying if user is on Stack Page");
				Assert.assertEquals(actualURL, expectedURL);
				Log.info("Test Successful");
				Log.endTestCase("ImplementationOfQueueinPythonURL");
				queuepageobj.clickTryHere();
				queuepageobj.typeinEditor();
				queuepageobj.typeinStringEditor(s2);
				queuepageobj.runButton();
				//Thread.sleep(5000);
				Log.info("Going on Take Screen Shot");
				queuepageobj.takeScreenShot();
				Log.info("Take Screen Shot Sucessful");
				Log.startTestCase("ImplementationOfQueueinPythonURL success");
				
			}
		
		    
		@Test(priority = 3)
		@Severity(SeverityLevel.NORMAL)
	    @Description("Queue Page Test")
		 @Story("Story Name:Implementation Using Collections Deque Check")   
		public void ImplementationUsingCollectionsDeque() throws Exception {
				
			Log.startTestCase("Implementation Using Collections Deque URL");
			queuepageobj.impUsingCollectionDeque();		
		    String actualURL=queuepageobj.getCurURL();
			String expectedURL="https://dsportalapp.herokuapp.com/queue/implementation-collections/";
			Log.info("Verifying if user is on  Implementation Using Collections Deque Page");
			Assert.assertEquals(actualURL, expectedURL);
			Log.info("Test Successful");
			Log.endTestCase("Implementation Using Collections Deque URL");
			queuepageobj.clickTryHere();
			queuepageobj.typeinEditor();
			//queuepageobj.typeinStringEditor(s2);
			queuepageobj.runButton();
			//Thread.sleep(5000);
			Log.info("Going on Take Screen Shot");
			queuepageobj.takeScreenShot();
			Log.info("Take Screen Shot Sucessful");
			Log.startTestCase("Implementation Using Collections Deque success");
				
			}
		
		
		
		@Test(priority = 4)
		public void ImplementationUsingArray() {
			
			Log.startTestCase("Implementation Using Array URL");
			queuepageobj.implementationUsingArray();		
		    String actualURL=queuepageobj.getCurURL();
			String expectedURL="https://dsportalapp.herokuapp.com/queue/Implementation-array/";
			Log.info("Verifying if user is on Queue Page");
			Assert.assertEquals(actualURL, expectedURL);
			Log.info("Test Successful");
			Log.endTestCase("ImplementationUsingArrayURL");
			queuepageobj.clickTryHere();
			queuepageobj.typeinEditor();
			queuepageobj.runButton();
			Log.info("Going on Take Screen Shot");
			queuepageobj.takeScreenShot();
			Log.info("Take Screen Shot Sucessful");
			Log.startTestCase("Implementation Using Array In Queue Page success");
			
		}
		
	
		
		
		@Test(priority = 5)
		public void QueueOperation() {
			
			Log.startTestCase("Queue Operation URL");
			queuepageobj.queueOperation();		
		    String actualURL=queuepageobj.getCurURL();
			String expectedURL="https://dsportalapp.herokuapp.com/queue/QueueOp/";
			Log.info("Verifying if user is on Queue Operation Page");
			Assert.assertEquals(actualURL, expectedURL);
			Log.info("Test Successful");
			Log.endTestCase("QueueOperationURL");
			queuepageobj.clickTryHere();
			queuepageobj.typeinEditor();
			queuepageobj.runButton();
			Log.info("Going on Take Screen Shot");
			queuepageobj.takeScreenShot();
			Log.info("Take Screen Shot Sucessful");
			Log.startTestCase("Queue Operation In Queue Page success");
			
			
		}
		
}



