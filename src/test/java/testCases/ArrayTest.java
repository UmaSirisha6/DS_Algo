package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.ArrayPage;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import utility.Log;

public class ArrayTest extends BaseClass{
	
	public GetStartedPage getStartedObj = null;
	public HomePage homepageObj = null;
	public SignInPage signInObj = null;
	public ArrayPage arrayPageObj = null;
	
	@BeforeMethod
	public void browsersetup() {
		launchApp(); 
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.signin("Dsalgo_Proj","group@pssu");
		Log.info("clicking on tree getstarted link"); 
		arrayPageObj =new ArrayPage();
		arrayPageObj.clickArrays();
	}

	@AfterClass
	public void tearDown() {
	//	getDriver().quit();
     }
	
	@BeforeClass
	public void setup() {
		//Log.info("starting test case");
	}
	
	@AfterMethod
	public void backnav() {
		
	//	getDriver().navigate().back();
	//	getDriver().navigate().back();
		getDriver().quit();
     }

@Test
	
	public void ArrayPage() {
		Log.startTestCase("ArrayU1rlopen");
		Log.info("user is clickarray page")	;
		String Actualurl=arrayPageObj.currUrl();
		String expected="https://dsportalapp.herokuapp.com/array/";
		Log.info(" is user in array page");
		Assert.assertEquals(Actualurl, expected);
		Log.info("test succesful");
		Log.endTestCase("ArrayPage");
		
	}
	

	@Test
	public void arraypython() {
		Log.startTestCase("Test has stared");
		Log.info("clcikcing over arrayspython");
		arrayPageObj.clickpython();
		String acturl=arrayPageObj.currUrl();
		String expurl="https://dsportalapp.herokuapp.com/array/arrays-in-python/";
		Log.info("checking python array url");
		Assert.assertEquals(acturl, expurl);
		arrayPageObj.clickTryhere();
		arrayPageObj.enterPyCode();
	//	arrayPageObj.enterstring();
		arrayPageObj.clickRun();
		Log.info("taking a screenshot of text editor page");
		arrayPageObj.TakeScreenshort();
		 String actualTitle=arrayPageObj.gettitle();
		 String ExpectTitle="Assessment";
		 
		Assert.assertEquals(actualTitle,ExpectTitle);
		Log.info("Test sucessful");
		Log.endTestCase("Try here operation done");
		
		
		
		
	}
	//@Test
	public void Praticequestios() {
		Log.startTestCase("Test has Started");
		Log.info("clicking on praticequestions");
		arrayPageObj.clickPratice();
		String ActUrl=arrayPageObj.currUrl();
		String expectedurl="https://dsportalapp.herokuapp.com/array/practice";
		Log.info(" check for correct url");
		Assert.assertEquals(ActUrl,expectedurl);
		Log.info("clickingmaxconsective numbers");
		arrayPageObj.clickMax();
	 String actualTitle=arrayPageObj.gettitle();
	 String exptitle="Assessment";
	 Log.info("checking titles");
	 Assert.assertEquals(actualTitle,exptitle);
	 Log.info("cheking for run");
	 if(arrayPageObj.isRundisplayed()) {
		 Log.info("run button id displayed");
		 
	 }
	 else {
		 Log.info("run button is not dispayed");
	 }
	 Log.endTestCase("practice question is done");

	}
}
