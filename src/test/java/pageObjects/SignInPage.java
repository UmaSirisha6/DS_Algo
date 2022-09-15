package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class SignInPage extends BaseClass {
	
	Action action = new Action();
	
	@FindBy(id="id_username")
	private WebElement userName;
	
	@FindBy(id="id_password")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement logIn;
	
	@FindBy(xpath="//a[text()='Register!']") 
	private WebElement register;
	
	@FindBy(linkText="Sign in")
	private WebElement signinbtn;
	
	@FindBy(xpath="//div[@class='alert alert-primary']")
	private WebElement signInUnsuccMsg;
	
	public SignInPage() {
		PageFactory.initElements(getDriver(), this);
		action.click(getDriver(), signinbtn);
	}
	
	public void enterUsername(String uname)
	{
		action.type(userName, uname);
	}
	
	public void enterPwd(String pwd)
	{
		action.type(password, pwd);
	}
	
	public void signin(String uname,String pwd)	{
		
		action.type(userName, uname);
		action.type(password, pwd);
		action.click(getDriver(), logIn);
		
	}
    public void clickSignin() {
    	action.click(getDriver(), logIn);
    }
    
    public void takeScreenShot(String filename) {
		action.screenShot(getDriver(), filename);
	}
    
    public HomePage clickSigninRetHomepage() {
    	action.click(getDriver(), logIn);	
		return new HomePage();
    }
    
    public String getSignInUnsuccMsg()
    {
    	String unsuccMsg = signInUnsuccMsg.getText();
		return unsuccMsg;
    	
    }
  
}
