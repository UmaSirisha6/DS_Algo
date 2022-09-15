package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utility.Log;

import base.BaseClass;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;

public class GetStartedTest extends BaseClass{

	public GetStartedPage getStartedObj = null;
	public HomePage homepageObj = null;


	
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod
       public void tearDown() {
		getDriver().quit();
     }
	
	@Test
	public void getSarted() {
        Log.startTestCase("getStartedMethod");
		
        getStartedObj= new GetStartedPage();
        homepageObj =  getStartedObj.getStarted();
        
		Log.endTestCase("getStartedMethod");
		
	}

}
