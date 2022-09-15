package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;
import base.BaseClass;

public class QueuePage extends BaseClass{
	Action action = new Action();
	
	@FindBy(xpath = "//a[@href='queue']")
	WebElement clickInQueue;	
	
	@FindBy(xpath = "//a[@href='implementation-lists']")
	WebElement ImplementationOfQueueinPython;
	
	@FindBy(xpath = "//a[@href='implementation-collections']")
	WebElement ImplementationUsingCollectionsDeque;
	
	@FindBy(xpath = "//a[@href='Implementation-array']")
	WebElement ImplementationUsingArray;
	
	
	@FindBy(xpath = "//a[@href='QueueOp']")
	WebElement QueueOperation;
	
	
	@FindBy(xpath = "//a[@class='btn btn-info']")
	WebElement TryHereButton;
	
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement Editor;	
	
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement RunButton;
	
	public  QueuePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void ClickonQueue(){
		  
		action.click(getDriver(),clickInQueue);
 }
	
	
	public String getCurURL() {
		String QueuePageURL=action.getCurrentURL(getDriver());
		return QueuePageURL;
		
	}	 
	 public void impofQueueinPython(){
		  
			action.click(getDriver(), ImplementationOfQueueinPython);
	  }
	 
	 public void impUsingCollectionDeque(){
		  
			action.click(getDriver(), ImplementationUsingCollectionsDeque);
	  }
	 
	 public void implementationUsingArray(){
		  
			action.click(getDriver(),ImplementationUsingArray);
	  }
	  
	 public void queueOperation(){
		  
			action.click(getDriver(),QueueOperation);
	  }
	  
     public void clickTryHere() {		  
			action.click(getDriver(), TryHereButton);
	  }
      
     public void typeinEditor(){
		    action.selectBySendkeys("print 50",Editor );
		   Editor.sendKeys(Keys.ENTER);
	  }
			
     public void runButton() {
 		action.click(getDriver(), RunButton);
 		
 		
 	}
     public void takeScreenShot() {
    	 action.screenShot(getDriver(), "Editor");
     }
	public void typeinStringEditor(String s1) {
		action.selectBySendkeys(s1,Editor );
		
		
	}
	
	 
}
