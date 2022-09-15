package testCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.GetStartedPage;
import pageObjects.GraphPage;
import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import utility.Log;

public class GraphTest extends BaseClass{
	
	public GetStartedPage getStartedObj = null;
	public HomePage homepageObj = null;
	public RegistrationPage registerObj = null;
	public GraphPage graphObj = null;
	
	@BeforeMethod
	public void setup() {
		launchApp(); 
	}
	
	@AfterMethod
	public void tearDown() {
		getDriver().quit();
	}
	
	
	@Test(priority=1)
	@Severity(SeverityLevel.NORMAL)
	@Description("Get Started below Garph Tab gets to Graph Page URL validation")
	@Story("Story Name: Graph Page URL ")
	public void graphPageURL() throws Throwable {
		Log.startTestCase("graphPageURL");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		homepageObj=homepageObj.clickOnSignIn();
		graphObj = homepageObj.clickOnGraphLink();
		 String actualURL=graphObj.getCurrURL();
		 String expectedURL="https://dsportalapp.herokuapp.com/graph/";
		 Log.info("Verifying if user is on Graph Page");
		 Assert.assertEquals(actualURL, expectedURL);
		 Log.info("Test Successful");
		 Log.endTestCase("graphPageURL");
		
	}
	

	@Test(priority=10)
	@Severity(SeverityLevel.NORMAL)
	@Description("Try Here Link on Graph Of Graph Page takes python code")
	@Story("Story Name: Graph of Graph Page Try Here code  ")
	public void TryHereGraphOngraphPageURL() throws Throwable {
		Log.startTestCase("TryHereGraphOngraphPageURL");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		homepageObj=homepageObj.clickOnSignIn();
		graphObj = homepageObj.clickOnGraphLink();
		graphObj.clickOnGraphOnGraphPage();
		graphObj.clickOnTryHereLink();
		//Thread.sleep(1000);
		graphObj.typeinEditor();
		graphObj.clickOnRunBtn();
		Log.info("Taking ScreenShot");
		graphObj.takeScreenShot();
		Log.info("ScreenShot Taken Successfully");
		Log.endTestCase("TryHereGraphOngraphPageURL");
		
	}
	
	@Test(priority=15)
	@Severity(SeverityLevel.NORMAL)
	@Description("GraphRepresentation Link on Graph Page takes to Graphrepresentation URL validation")
	@Story("Story Name: GraphRepresentation of Graph Page")
	
	public void GraphRepreOngraphPageURL() throws Throwable {
		Log.startTestCase("GraphRepreOngraphPageURL");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
	    homepageObj=homepageObj.clickOnSignIn();
		graphObj = homepageObj.clickOnGraphLink();
		graphObj.clickOnGraphRepresentationLink();
		String actualURL=graphObj.getCurrURL();
		String expectedURL="https://dsportalapp.herokuapp.com/graph/graph-representations/";
		Log.info("Verifying if user is on Graph Representation of Graph Page");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Test Successful");
		Log.endTestCase("GraphRepreOngraphPageURL");

	}
	
	@Test(priority=10)
	@Severity(SeverityLevel.NORMAL)
	@Description("Try Here Link on Graphrepresentation Of Graph Page takes python code")
	@Story("Story Name: Graphrepresentation Link of Graph Page Try Here code  ")
	public void TryHereGraphrepresenationOngraphPageURL() throws Throwable {
		Log.startTestCase("TryHereGraphrepresenationOngraphPageURL");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		homepageObj=homepageObj.clickOnSignIn();
		graphObj = homepageObj.clickOnGraphLink();
		graphObj.clickOnGraphRepresentationLink();
		graphObj.clickOnTryHereLink();
		//Thread.sleep(3000);
		graphObj.typeinEditor();
		//Thread.sleep(3000);
		graphObj.clickOnRunBtn();
		Log.info("Taking ScreenShot");
		graphObj.takeScreenShot();
		Log.info("ScreenShot Taken Successfully");
		Log.endTestCase("TryHereGraphrepresenationOngraphPageURL");
		
	}
	

}
