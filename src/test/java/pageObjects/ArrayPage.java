package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class ArrayPage extends BaseClass{
	Action action = new Action();

	@FindBy(xpath="//a[@href='array']")
	private WebElement Array;

		
	@FindBy(linkText="Arrays in Python")
	private WebElement ClickPython ;

	@FindBy(linkText="Arrays Using  List")
	private WebElement Llist;

	@FindBy(linkText="Basic Operation in Lists")
	private WebElement opeLists;

	@FindBy(linkText="Applications of Array ")
	private WebElement Application;

	@FindBy(linkText="Practice Questions")
	private WebElement pratice;

	@FindBy(linkText="Try here>>>")
	private WebElement tryHere;

	// tryEditor page code enter and run
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	private WebElement enterCode;

	@FindBy(xpath="//button[text()='Run']")
	private WebElement run;

	@FindBy(xpath="//pre[@id='output']")
	private WebElement outputElem;
	@FindBy(linkText="Max Consecutiove Ones")
	private WebElement Max;

	public ArrayPage() 
	{
		PageFactory.initElements(getDriver(), this);
	}

	public void clickArrays()
	{
		action.click(getDriver(), Array);	
	}
	  
	public void clickpython(){
		action.click(getDriver(),ClickPython );
	}

	public void clickList() {
		action.click(getDriver(),Llist );
	}

	public void clickbasicOperation() {
		action.click(getDriver(), opeLists);
	}

	public void clickApp() {
		action.click(getDriver(), Application);
	}

	public void clickPratice() {
		action.click(getDriver(), pratice);
	}

	public void clickMax() {
		action.click(getDriver(), Max);
	}

	public String gettitle()
	{
		String title = getDriver().getTitle();
		return title;
	}

	public String currUrl()
	{
		String CurrUrl = getDriver().getCurrentUrl();
		return CurrUrl;
	}

	public void clickTryhere()
	{
		action.click(getDriver(), tryHere);
	}
	public void enterstring() {
		action.selectBySendkeys("print hellow", enterCode);
	}

	public void enterPyCode()
	{
		action.selectBySendkeys("print 10", enterCode);
	}

	public void clickRun()
	{
		action.click(getDriver(), run);
	}

	public String getOutput()
	{
		String op= outputElem.getText();
		return op;

	}
	public boolean isRundisplayed()
	{
		boolean flag = run.isDisplayed();
		return flag;
	}
	public void TakeScreenshort() {
		action.screenShot(getDriver(), "codeenter");

	}
}
