package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class RegistrationPage extends BaseClass{

	
	public RegistrationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();


	
	@FindBy(xpath="//input[@name='username']")
	WebElement userName;
	
	@FindBy(xpath="//input[@name='password1']")
	WebElement pwd1;
	
	@FindBy(xpath="//input[@name='password2']")
	WebElement pwd2;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement submit;
	
	@FindBy(xpath="(//form//input[@type='hidden'])[1]")
	WebElement userNameMsg;
	
	@FindBy(xpath="//div[@class='alert alert-primary']")
	WebElement uNameNACharErrorMsg;
	
	public String getCurrURL() throws Throwable {
		String RegisterPageURL= action.getCurrentURL(getDriver());
		return RegisterPageURL;
	}
	
	public void clickSubmitBtn() {
		action.click(getDriver(), submit);
	}
	
	public HomePage clickSubmitBtnRetHomePage() {
		action.click(getDriver(), submit);
		return new HomePage();
	}
	
	public String hoverOverUsename() {
		action.moveToElement(getDriver(), userName);
		String hoverMsg=userName.getAttribute("validationMessage");
		System.out.println("userName validation Message :" + hoverMsg );
		return hoverMsg;
	}
	
	public String errorMsgUsename() {
		String erroeMsg=userName.getAttribute("validationMessage");
		System.out.println("userName error Message :" + erroeMsg );
		return erroeMsg;
	}
	       
	
	public String errorMsgConfirmPwd() {

		String erroeMsg=pwd2.getAttribute("validationMessage");
		System.out.println("Confrim Password error Message :" + erroeMsg );
		return erroeMsg;
	}
		
	public String typeUserName(String uName) {
		action.getCurrentURL(getDriver());
		action.click(getDriver(), userName);
		action.selectBySendkeys(uName, userName);
		return uName;
		
	}
	
	public String messageCapture() {
		String actHoverMsg = userNameMsg.getText();
		
			return actHoverMsg;
	}
	
	public void takeScreenShot() {
		action.screenShot(getDriver(), "userNameHOvermsg");
	}
	
	public String typePWD1(String pwrd1) {
		action.getCurrentURL(getDriver());
		action.click(getDriver(), pwd1);
		action.selectBySendkeys(pwrd1, pwd1);
		return pwrd1;
		
	}
	
	public String typePWD2(String pwrd2) {
		action.getCurrentURL(getDriver());
		action.click(getDriver(), pwd2);
		action.selectBySendkeys(pwrd2, pwd2);
		return pwrd2;
		
	}
	
	public String readuseNameNACharErrorMsg()
	{
	 String uNameNACharErrMsg =	uNameNACharErrorMsg.getText();
	 return uNameNACharErrMsg;
	}
	
	public void alertErrorMsg() {
		boolean flag = action.Alert(getDriver());
		System.out.println("Flag :" + flag);
		boolean flag1 = action.isAlertPresent(getDriver());
		System.out.println("Flag1 :" + flag1);
		
	}
	
}
