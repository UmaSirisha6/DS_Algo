package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class GetStartedPage extends BaseClass {
	
     
	
	@FindBy(xpath = "//button[@class='btn']")
	WebElement GetStarted;

	Action action = new Action();
	
	public GetStartedPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public HomePage getStarted() {

		action.click(getDriver(), GetStarted);
		return new HomePage();
	}

}
