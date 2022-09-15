package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class GraphPage extends BaseClass {
	

	
	public GraphPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	Action action= new Action();
	
	@FindBy(xpath="//a[@href='graph']")
	WebElement graphLinkOnGraphPage;
	
	@FindBy(xpath="//a[text()='Try here>>>']")
	WebElement tryHereLink;
	
	 @FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	WebElement tryEditor;
	
	@FindBy(xpath="//button[@onclick='runit()']")
	WebElement runBtn;
	
	@FindBy(xpath="//a[text()='Graph Representations']")
	WebElement graphRepreLink;
	
	public String getCurrURL() throws Throwable {
		String graphPageURL=action.getCurrentURL(getDriver());
		return graphPageURL;
	}
	
	public void clickOnGraphOnGraphPage() throws Throwable {
		action.click(getDriver(), graphLinkOnGraphPage);
	}
	
	public void clickOnTryHereLink() throws Throwable {
		action.click(getDriver(),tryHereLink);
	}
	
	public void typeinEditor()	{
		//action.JSStyleChane(getDriver());
//		action.click(getDriver(), tryEditor);
//		System.out.println("clicked on tryeditor");
		action.selectBySendkeys("print 10", tryEditor);
		System.out.println("after sendkeys");
	}
	
	public void clickOnRunBtn() {
		action.click(getDriver(), runBtn);
	}
	public void clickOnGraphRepresentationLink() throws Throwable {
		action.click(getDriver(),graphRepreLink);
			
	}
	
	public void takeScreenShot() {
		action.screenShot(getDriver(), "TypeEditorScreenShot");
	}
	
	


}
