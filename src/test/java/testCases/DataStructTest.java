package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.DataStructPage;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.SignInPage;
import utility.Log;

public class DataStructTest extends BaseClass {
	public GetStartedPage getStartedObj = null;
	public HomePage homepageObj = null;
	public SignInPage signInObj = null;
	public DataStructPage DsPageObj = null;
	
	@BeforeMethod
	public void browsersetup() {
		launchApp(); 
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.signin("Dsalgo_Proj","group@pssu");
		Log.info("clicking on Data Structure getstarted link"); 
		DsPageObj =new DataStructPage();
		DsPageObj.clickDslink();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
     }
	
	@Test
	public void clciktimecomplex() {
		Log.startTestCase("check time complex link");
		DsPageObj.ClickTime();
		String actUrl=DsPageObj.currUrl();
		String expUrl="https://dsportalapp.herokuapp.com/data-structures-introduction/time-complexity/";
		Log.info("checking the correct url");
		Assert.assertEquals(actUrl, expUrl);
		Log.info("check time complex link");
	}

}
