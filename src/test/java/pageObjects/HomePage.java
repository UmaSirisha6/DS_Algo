package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class HomePage extends BaseClass{

	@FindBy(xpath = "//div[@class='alert alert-primary']")
	WebElement succMsg;
	
	@FindBy (xpath="//a[@href='/logout']")
	WebElement signOutBtn;
	
	@FindBy (xpath="//a[@href='/login']")
	WebElement signInBtn;
	
	@FindBy (xpath="//a[@href='/register']")
	WebElement registerBtn;
	
	@FindBy (xpath="//a[@href='graph']")
	WebElement graphlink;
	
	
	Action action = new Action();
	
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public RegistrationPage clickOnRegisterLink()
	{
		
		action.click(getDriver(), registerBtn);
		return new RegistrationPage() ;
		
	}
	
	public String readAccountCreatedMsg()
	{
		String AccCreSuccessMsg = succMsg.getText();
		return AccCreSuccessMsg;
	}
	
	public String currURL()
	{
		return Action.getDriver().getCurrentUrl();
	}
	
	public HomePage clickOnSignIn()
	{
		action.click(getDriver(), signInBtn);
		SignInPage signinpageObj= new SignInPage();
		signinpageObj.signin("Dsalgo_Proj","group@pssu");
		return new HomePage();
	}
	
	public SignInPage clickOnSignInLink()
	{
		action.click(getDriver(), signInBtn);

		return new SignInPage();
	}
	
	public void clickOnSignOutLink()
	{
		action.click(getDriver(), signOutBtn);
	}
	
	public GraphPage clickOnGraphLink()
	{
		action.click(getDriver(), graphlink);
		return new GraphPage();
	}
	
	  public String getSuccessMsg()
	    {
		  String signinMsg =succMsg.getText();
	    	return signinMsg;
	    }
	  
}
