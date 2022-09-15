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
import utility.Log;

public class SignInTest extends BaseClass {

	public GetStartedPage getStartedObj = null;
	public HomePage homepageObj = null;
	public SignInPage signInObj = null;
	
	@BeforeMethod
	public void setup() {
		launchApp(); 
		
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
}
	
	@Test(priority =1 ,dataProvider = "SignIn", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.CRITICAL)
	@Description("SignIn Page Check")
	@Story("Story Name: Checking signin with valid username and password")
	public void signInWithvalidUnameAndPwd(String Username,String Password) throws InterruptedException
	{
		Log.startTestCase("signInWithvalidUnameAndPwd");
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		Log.info("user is going to click on SignIn Link");
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.enterUsername(Username);
		signInObj.enterPwd(Password);
		homepageObj = signInObj.clickSigninRetHomepage();
		Thread.sleep(1000);
	    Log.info("Verifying SignIn Success Method");
	    String actSuccMsg = homepageObj.getSuccessMsg();
	    String expSuccMsg = "You are logged in";
	    Assert.assertEquals(actSuccMsg, expSuccMsg);
	    Log.info("SignIn is Successful");
	    Log.endTestCase("signInWithvalidUnameAndPwd");
	}
	
    @Test(priority = 2, dataProvider = "SignIn", dataProviderClass = DataProviders.class)
    @Severity(SeverityLevel.NORMAL)
	@Description("SignIn Page Check")
	@Story("Story Name: Checking signin with valid username and Invalid password")
	public void signInWithvalidUnameInvalidPwd(String Username,String Password) throws InterruptedException
	{
		Log.startTestCase("signInWithvalidUnameInvalidPwd");
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		Log.info("user is going to click on SignIn Link");
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.enterUsername(Username);
		signInObj.enterPwd("InvalidPwd@123"); // Entering invalid Password
		Log.info("user is going to click on SignIn with invalid Password");
		signInObj.clickSignin();
		Thread.sleep(1000);
		String actUnSuccMsg = signInObj.getSignInUnsuccMsg();
	    String expUnSuccMsg = "Please check your password";
	    Assert.assertEquals(actUnSuccMsg, expUnSuccMsg);
	    Log.info("SignIn is Unsuccessful");
	    Log.endTestCase("signInWithvalidUnameInvalidPwd");
	}
	
	@Test(priority =3, dataProvider = "SignIn", dataProviderClass = DataProviders.class)
	 @Severity(SeverityLevel.NORMAL)
     @Description("SignIn Page Check")
	 @Story("Story Name: Checking signin with Invalid username and valid password")
	public void signInWithInvalidUnamevalidPwd(String Username,String Password) throws InterruptedException
	{
		Log.startTestCase("signInWithInvalidUnamevalidPwd");
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		Log.info("user is going to click on SignIn Link");
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.enterUsername("InvalidUsername@123");// Entering invalid username
		signInObj.enterPwd(Password); 
		Log.info("user is going to click on SignIn with invalid User name");
		signInObj.clickSignin();
		Thread.sleep(1000);
		String actUnSuccMsg = signInObj.getSignInUnsuccMsg();
	    String expUnSuccMsg = "Please check your user id";
	    Assert.assertEquals(actUnSuccMsg, expUnSuccMsg);
	    Log.info("SignIn is Unsuccessful");
	    Log.endTestCase("signInWithInvalidUnamevalidPwd");
	}
	
	@Test(priority = 4)
	@Severity(SeverityLevel.NORMAL)
    @Description("SignIn Page Check")
	@Story("Story Name: Checking signin with Invalid username and Invalid password")
	public void signInWithInvalidUnameInvalidPwd() throws InterruptedException
	{
		Log.startTestCase("signInWithInvalidUnameInvalidPwd");
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		Log.info("user is going to click on SignIn Link");
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.enterUsername("InvalidUsername@123");// Entering invalid user name
		signInObj.enterPwd("InvalidPwd@123");          // Entering invalid password
		Log.info("user is going to click on SignIn with invalid User name and invalid password");
		signInObj.clickSignin();
		Thread.sleep(1000);
		String actUnSuccMsg = signInObj.getSignInUnsuccMsg();
	    String expUnSuccMsg = "Invalid Username and Password";
	    Assert.assertEquals(actUnSuccMsg, expUnSuccMsg);
	    Log.info("SignIn is Unsuccessful");
	    Log.endTestCase("signInWithInvalidUnameInvalidPwd");
	}
	
	@Test(priority = 5 ,dataProvider = "SignIn", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("SignIn Page Check")
	@Story("Story Name: Checking signin with Invalid username and NO password")
	public void signInWithvalidUnameNoPwd(String Username,String Password) throws InterruptedException
	{
		Log.startTestCase("signInWithvalidUnameNoPwd");
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		Log.info("user is going to click on SignIn Link");
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.enterUsername(Username);
		signInObj.clickSignin();
		Thread.sleep(1000);
	    Log.info("Verifying SignIn error message");
	    signInObj.takeScreenShot("FillPasswordFieldError");
	    Log.info("displayed please fill the field error Message");
	    Log.endTestCase("signInWithvalidUnameNoPwd");
	}
	
	@Test(priority = 6 ,dataProvider = "SignIn", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("SignOut Page Check")
	 @Story("Story Name: Checking signOut")
	public void signOut(String Username,String Password) throws InterruptedException
	{
		Log.startTestCase("signOut");
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		Log.info("user is going to click on SignIn Link");
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.enterUsername(Username);
		signInObj.enterPwd(Password);
		homepageObj = signInObj.clickSigninRetHomepage();
		Thread.sleep(1000);
	    Log.info("Verifying SignOut link");
	    homepageObj.clickOnSignOutLink();
	    String actalerttext =homepageObj.getSuccessMsg();
	    String expalarttext = "Logged out successfully";
	    Assert.assertEquals(actalerttext,expalarttext);
	    Log.info("SignOut is Successful");
	    Log.endTestCase("signOut");
	}
}
