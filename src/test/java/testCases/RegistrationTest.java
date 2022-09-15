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
import pageObjects.RegistrationPage;
import utility.Log;

public class RegistrationTest extends BaseClass{
	public GetStartedPage getStartedObj = null;
	public HomePage homepageObj = null;
	public RegistrationPage registerObj = null;
	
	
	
	
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
	@Description("Registration Page Check")
	@Story("Story Name: Checking Registarion URL")
	public void registerPageURL() throws Throwable {
		Log.startTestCase("registerPageURL");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		 String actualURL=registerObj.getCurrURL();
		 String expectedURL="https://dsportalapp.herokuapp.com/register";
		 Log.info("Verifying if user is on Registration Page");
		 Assert.assertEquals(actualURL, expectedURL, "Test Failed");
		 Assert.assertEquals(actualURL, expectedURL);
		 Log.info("Test Successful");
		 Log.endTestCase("registerPageURL");
		
	}
	
    @Test(priority=3)
	@Severity(SeverityLevel.NORMAL)
	@Description("UserNAme Hover Message Validation")
	@Story("Story Name: UserNAme Validation Message Check")
	public void usernameHovermsg() throws Throwable {
		Log.startTestCase("usernameHovermsg");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		Thread.sleep(1000);
		String ActHoverMsg = registerObj.hoverOverUsename();
		String ExpHoverMsg = ("Please fill out this field.");
		Log.info("Verifying hovermessage for UserNAme");
		Assert.assertEquals(ActHoverMsg, ExpHoverMsg);
		Log.info("HoverMessage Validation Successful");
		Log.endTestCase("usernameHovermsg");
		
	}
	
	@Test(priority=5)
	@Severity(SeverityLevel.NORMAL)
	@Description("All Empty Fields Register Btn Click Message Check")
	@Story("Story Name: Click Register with All empty Fields")
	public void afterClickingSubmitwithAllEmptyfields() throws Throwable {
		Log.startTestCase("afterClickingSubmitwithAllEmptyfields");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		registerObj.clickSubmitBtn();
		Log.info("ScreenShot to see UserName Error message");
		registerObj.takeScreenShot();
		Log.info("Screenshot taken");
		String ActErrMsg1 = registerObj.errorMsgUsename();
		String ExpErrMsg1 = ("Please fill out this field.");
		Log.info("Verifying Errormessage for UserNAme");
		Assert.assertEquals(ActErrMsg1, ExpErrMsg1);
		Log.info("ErrorMessage Validation Successful");
		Log.endTestCase("afterClickingSubmitwithAllEmptyfields");
		
	}
	
	@Test(priority=10, dataProvider="withoutPassword2", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Description("Without giving Confirm Password Click Message Check")
	@Story("Story Name: Password Confirm Field Empty")
	public void afterClickingSubmitwithoutPwdCofirm(String userNAme, String password1) throws Throwable {
		Log.startTestCase("afterClickingSubmitwithoutPwdCofirm");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		registerObj.typeUserName(userNAme);
		registerObj.typePWD1(password1);
		registerObj.clickSubmitBtn();
		Log.info("ScreenShot to see UserName Error message");
		registerObj.takeScreenShot();
		Log.info("Screenshot taken");
		String ActErrMsg2 = registerObj.errorMsgConfirmPwd();
		String ExpErrMsg2 = ("Please fill out this field.");
		Log.info("Verifying Errormessage for confirm password");
		Assert.assertEquals(ActErrMsg2, ExpErrMsg2);
		Log.info("ErrorMessage Validation Successful");
		Log.endTestCase("afterClickingSubmitwithoutPwdCofirm");
		
	}
	
	@Test(priority=35, dataProvider="ValidUNamePWDForAccCreation", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Description("Registration with valid username and passwords")
	@Story("Story Name: Checking Registarion Successful Account Created message")
	public void RegistreTest(String uname, String pswd1,String pswd2) throws Throwable {
		Log.startTestCase("RegistreTest");
		getStartedObj= new GetStartedPage();
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		Log.info("Enter Username and Password");
		registerObj.typeUserName(uname);
		registerObj.typePWD1(pswd1);
		registerObj.typePWD2(pswd2);
		homepageObj = registerObj.clickSubmitBtnRetHomePage();
		Thread.sleep(1000);
	    Log.info("Verifying Accout Created Success Method");
	    String ActSuccessMsg5 =  homepageObj.readAccountCreatedMsg();
	    String ExpSuccessMsg5 = "New Account Created. You are logged in as " +uname;
	    System.out.println("actal msg is :"  +ActSuccessMsg5);
	    System.out.println("expected msg is :"  +ExpSuccessMsg5);
	    Assert.assertEquals(ActSuccessMsg5, ExpSuccessMsg5, "Test failed as displayed message doesn't match with Expected message");		
	     
	    Log.info("Login is Sucess");
	    Log.endTestCase("loginTest");
	}
	
	
	@Test(priority=25, dataProvider="passwordsInNumberFormat", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Description("passwords with number Format check")
	@Story("Story Name: passwords with only numbers")
	public void pwdsOnlyNumErrrMasg(String UName, String pwd1, String pwd2) throws Throwable {
		Log.startTestCase("pwdsOnlyNumErrrMasg");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		registerObj.typeUserName(UName);
		registerObj.typePWD1(pwd1);
		registerObj.typePWD2(pwd2);
		registerObj.clickSubmitBtn();
		Log.info("reading Error Message");
		String ActErrormsg4 = registerObj.readuseNameNACharErrorMsg();
		String ExpErrormsg4 = "Your password can’t be entirely numeric.";
		Log.info("verifying error message");
		try {
			Assert.assertEquals(ActErrormsg4, ExpErrormsg4);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		Log.endTestCase("pwdsOnlyNumErrrMasg");
		
	}
	
	@Test(priority=15, dataProvider="userNAmeNACharacters", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Description("UserName with characters not allowed")
	@Story("Story Name: UserNAme with NA characters")
	public void userNamewithNACharcters(String userNAme, String password1,String password2) throws Throwable {
		Log.startTestCase("userNamewithNACharcters");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		registerObj.typeUserName(userNAme);
		registerObj.typePWD1(password1);
		registerObj.typePWD2(password2);
		registerObj.clickSubmitBtn();
		Log.info("reading Error Message");
		String ActErrormsg1 = registerObj.readuseNameNACharErrorMsg();
		String ExpErrormsg1 = "Please enter a valid username";
		Log.info("verifying error message");
		try {
			Assert.assertEquals(ActErrormsg1, ExpErrormsg1);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		Log.endTestCase("userNamewithNACharcters");
		
	}
	
	//@Test(priority=20, dataProvider="passwordsMisMatch", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Description("passwords dont Match")
	@Story("Story Name: Passwords MisMatch")
	public void passwordMisMatchValidation(String userNAme, String password1,String password2) throws Throwable {
		Log.startTestCase("passwordMisMatchValidation");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		registerObj.typeUserName(userNAme);
		registerObj.typePWD1(password1);
		registerObj.typePWD2(password2);
		registerObj.clickSubmitBtn();
		Log.info("reading Error Message");
		String ActErrormsg1 = registerObj.readuseNameNACharErrorMsg();
		String ExpErrormsg1 = "password_mismatch:The two password fields didn’t match.";
		Log.info("verifying error message");
		try {
			Assert.assertEquals(ActErrormsg1, ExpErrormsg1);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		Log.endTestCase("passwordMisMatchValidation");
		
	}
	
 	@Test(priority=30, dataProvider="passwordsLT8characters", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
	@Description("passwords with Less than 8 characters")
	@Story("Story Name: passwords LT 8 char")
	public void pwdsLT8CharErrrMasg(String uname, String pwd1,String pwd2) throws Throwable {
		Log.startTestCase("pwdsLT8CharErrrMasg");
		getStartedObj= new GetStartedPage();
		Log.info("user is going on Home Page");
		homepageObj=getStartedObj.getStarted();
		Log.info("user is going to click on Register Link");
		registerObj = homepageObj.clickOnRegisterLink();
		registerObj.typeUserName(uname);
		registerObj.typePWD1(pwd1);
		registerObj.typePWD2(pwd2);
		registerObj.clickSubmitBtn();
		Log.info("reading Error Message");
		String ActErrormsg3 = registerObj.readuseNameNACharErrorMsg();
		String ExpErrormsg3 = "Password should contain atleast 8 characters";
		Log.info("verifying error message");
		try {
		Assert.assertEquals(ActErrormsg3, ExpErrormsg3);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		Log.endTestCase("pwdsLT8CharErrrMasg");
		
	}
}
