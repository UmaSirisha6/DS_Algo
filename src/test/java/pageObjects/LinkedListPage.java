package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class LinkedListPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy(xpath="//a[@href='linked-list']")
	private WebElement linkedList;
	
	@FindBy(linkText="Introduction")
	private WebElement introduction;
		
	@FindBy(linkText="Creating Linked LIst")
	private WebElement creatingLlist;
	
	@FindBy(linkText="Types of Linked List")
	private WebElement typesOfLlist;
	
	@FindBy(linkText="Implement Linked List in Python")
	private WebElement implLlistInPy;

	@FindBy(linkText="Traversal")
	private WebElement traversal;
	
	@FindBy(linkText="Insertion")
	private WebElement insertion;
	
	@FindBy(linkText="Deletion")
	private WebElement deletion;
	
	@FindBy(linkText="Practice Questions")
	private WebElement pracQuestions;
	
	@FindBy(linkText="Try here>>>")
	private WebElement tryHere;
	
    // tryEditor page code enter and run
	@FindBy(xpath="//form[@id='answer_form']/div/div/div/textarea")
	private WebElement enterCode;
	
	@FindBy(xpath="//button[text()='Run']")
	private WebElement run;
	
	@FindBy(xpath="//pre[@id='output']")
	private WebElement outputElem;
	
	public LinkedListPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickLinkedList()
	{
		action.click(getDriver(), linkedList);	
	}
      
	public void clickIntro() {
		action.click(getDriver(), introduction);
	}
	
	public void clickCreatingLlist() {
		action.click(getDriver(), creatingLlist);
	}
	
	public void clickTypesOfLlist() {
		action.click(getDriver(), typesOfLlist);
	}
	
	public void clickImplLlistInPy() {
		action.click(getDriver(), implLlistInPy);
	}
	
	public void clickTraversal() {
		action.click(getDriver(), traversal);
	}
	public void clickinsertion() {
		action.click(getDriver(), insertion);
	}
	public void clickdeletion() {
		action.click(getDriver(), deletion);
	}
	public void clickPracQuestions() {
		action.click(getDriver(), pracQuestions);
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
	public void enterPyCode(String codeInput)
	{
		action.selectBySendkeys(codeInput, enterCode);
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
		String op= action.getText(outputElem);
		return op;
	
	}
	public boolean isRundisplayed()
	{
		boolean flag = run.isDisplayed();
		return flag;
	}
	

}
