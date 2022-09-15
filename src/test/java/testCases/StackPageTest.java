package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
import pageObjects.SignInPage;
import pageObjects.StackPage;
import utility.Log;

public class StackPageTest extends BaseClass{
	

public GetStartedPage getStartedObj = null;
public HomePage homepageObj = null;
public SignInPage signinObj=null;
public StackPage stackpageobj=null;
	
	
	@BeforeMethod
public void BrowseSetup()
	{
	launchApp();
	getStartedObj = new GetStartedPage();
	homepageObj = getStartedObj.getStarted();
	signinObj = homepageObj.clickOnSignInLink();
	signinObj.signin("swathik","Lokitakshaa");	
	Log.info("clicking on StackPage"); 
	stackpageobj =new StackPage();
	stackpageobj.ClickonStack();
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(priority =1)
	@Severity(SeverityLevel.NORMAL)
    @Description("StackPage Page Test")
	 @Story("Story Name:StackPage URL Check")
public void stackPageURL() {
		
		Log.startTestCase("StackPageURL");
		Log.info("user is going to click on StackPage Link");
		String actualURL=stackpageobj.getCurURL();
		String expectedURL="https://dsportalapp.herokuapp.com/stack/";
		Log.info("Verifying if user is on Stack Page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Test Successful");
		Log.endTestCase("StackPageURL");
		
	}

@Test(priority = 2,dataProvider = "PyCode", dataProviderClass = DataProviders.class)
@Severity(SeverityLevel.NORMAL)
@Description("Stack Page Operation in Stack Test")
@Story("Story Name: Operation in StackPage check")
public void operationInStackPage(String s2,String op) throws Exception {
		
		Log.startTestCase("operationInStackPageURL");
//		getStartedObj= new GetStarted();
//		Log.info("user is going on Home Page");
//		homepageObj=getStartedObj.clickonGetStarted();
//		signinObj=homepageObj.clickOnSignInLink();
//		Log.info("user is going on Stack Page");
		stackpageobj.operationInStack();		
	    String actualURL=stackpageobj.getCurURL();
		String expectedURL="https://dsportalapp.herokuapp.com/stack/operations-in-stack/";
		Log.info("Verifying if user is on Stack Page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Test Successful");
		Log.endTestCase("operationInStackPageURL");
		stackpageobj.clickTryHere();
		//stackpageobj.typeinEditor(); //print10
		stackpageobj.typeinStringEditor(s2);
		stackpageobj.runButton();	
		Log.info("Going on Take Screen Shot");
		stackpageobj.takeScreenShot();
		Log.info("Take Screen Shot Sucessful");
		Log.startTestCase("operationInStackPage success");
		
		
	}
    
@Test(priority = 3)
@Severity(SeverityLevel.NORMAL)
@Description("Stack Page Implementation in Stack Test")
@Story("Story Name: Implementation in StackPage check")
public void implementationInStackPage() throws Exception {
		
		Log.startTestCase("ImplementationInStackPageURL");
		stackpageobj.implementation();		
	    String actualURL=stackpageobj.getCurURL();
		String expectedURL="https://dsportalapp.herokuapp.com/stack/implementation/";
		Log.info("Verifying if user is on Stack Page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Test Successful");
		
		stackpageobj.clickTryHere();
		stackpageobj.typeinEditor();
		stackpageobj.runButton();
		
//		Log.info("Going on Take Screen Shot");
//		stackpageobj.takeScreenShot();
//		Log.info("Take Screen Shot Sucessful");
		Log.endTestCase("ImplementationInStackPageURL");
		
		
	}


@Test(priority = 4)
@Severity(SeverityLevel.NORMAL)
@Description("Stack Page Application in Stack Test")
@Story("Story Name: Application in StackPage check")
public void ApplicationsInStackPage() throws Exception {
	
	Log.startTestCase("ApplicationsInStackPageURL");
	stackpageobj.application();		
    String actualURL=stackpageobj.getCurURL();
	String expectedURL="https://dsportalapp.herokuapp.com/stack/stack-applications/";
	Log.info("Verifying if user is on Stack Page");
	Assert.assertEquals(actualURL, expectedURL);
	Log.info("Test Successful");
	Log.endTestCase("ApplicationsInStackPageURL");
	stackpageobj.clickTryHere();
	stackpageobj.typeinEditor();
	stackpageobj.runButton();
//	Log.info("Going on Take Screen Shot");
//	stackpageobj.takeScreenShot();
//	Log.info("Take Screen Shot Sucessful");
	Log.startTestCase("Application InStackPage success");
	
}


}
