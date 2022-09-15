package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class TreePage extends BaseClass {

	Action action = new Action();
	
	@FindBy(xpath="//a[@href='tree']")
	private WebElement tree;
	
	@FindBy(linkText="Overview of Trees")
	private WebElement ovrvwOfTrees;
	
	@FindBy(linkText="Terminologies")
	private WebElement terminologies ;
	
	@FindBy(linkText="Types of Trees")
	private WebElement typesOfTrees;
	
	@FindBy(linkText="Tree Traversals")
	private WebElement treeTraversals;
	
	@FindBy(linkText="Traversals-Illustration")
	private WebElement travIllustartion ;
	
	@FindBy(linkText="Binary Trees")
	private WebElement binaryTrees ;
	
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
	
	public TreePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	
	public void clickTree()
	{
		action.click(getDriver(), tree);	
	}
	
	public void clickOvrvwOfTrees()
	{
		action.click(getDriver(), ovrvwOfTrees);	
	}
	
	public void clickterminologies()
	{
		action.click(getDriver(), terminologies);	
	}
	
	public void clickTypesOfTrees()
	{
		action.click(getDriver(), typesOfTrees);	
	}
	
	public void clickTreeTraversals()
	{
		action.click(getDriver(), treeTraversals);	
	}
	
	public void clickTravIllustartion()
	{
		action.click(getDriver(), travIllustartion);	
	}
	
	public void clickBinaryTrees()
	{
		action.click(getDriver(), binaryTrees);	
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
	//	String op= action.getText(outputElem);
		String op = outputElem.getText();
		return op;
	
	}
	public boolean isRundisplayed()
	{
		boolean flag = run.isDisplayed();
		return flag;
	}
	
	
}
