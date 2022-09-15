package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class DataStructPage extends BaseClass{
	
	Action action = new Action();

	@FindBy(xpath="//a[@href='data-structures-introduction']")
	private WebElement Data;
	
	@FindBy(xpath="//a[@href='time-complexity']")
	private WebElement timecomplextiy;

	public DataStructPage(){
		PageFactory.initElements(getDriver(), this);
	}
	public void clickDslink() {
		action.click(getDriver(), Data);
	}
	public void ClickTime() {
		action.click(getDriver(), timecomplextiy);
	}

	public String currUrl()
	{
		String CurrUrl = getDriver().getCurrentUrl();
		return CurrUrl;
	}


}
