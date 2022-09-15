package pageObjects;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionsinterface.Action;

import base.BaseClass;

public class StackPage extends BaseClass {
	Action action = new Action();
	
	
			
	@FindBy(xpath = "//a[@href='stack']")
	WebElement clickInStack;		
	
	@FindBy(xpath = "//a[@href='operations-in-stack']")
	WebElement operationInStack;
	
	@FindBy(xpath = "//a[@href='implementation']")
	WebElement Implementation;
	
	@FindBy(xpath = "//a[@href='stack-applications']")
	WebElement Application;	
	
	
	@FindBy(xpath = "//a[@class='btn btn-info']")
	WebElement TryHereButton;
	
	@FindBy(xpath = "//form[@id='answer_form']/div/div/div/textarea")
	WebElement Editor;	
	
	
	@FindBy(xpath = "//button[@type='button']")
	WebElement RunButton;
	
	public  StackPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	 public void ClickonStack(){
		  
			action.click(getDriver(), clickInStack);
	 }
	
	public String getCurURL() {
		String StackPageURL=action.getCurrentURL(getDriver());
		return StackPageURL;
		
	}	 
	 public void operationInStack(){
		  
			action.click(getDriver(), operationInStack);
	  }
	 
	 public void implementation(){
		  
			action.click(getDriver(), Implementation);
	  }
	 
	 public void application(){
		  
			action.click(getDriver(),Application);
	  }
	  
     public void clickTryHere() {		  
			action.click(getDriver(), TryHereButton);
	  }
      
     public void typeinEditor(){
		    action.selectBySendkeys("print 10",Editor );
		  	//action.click(getDriver(), Editor);
		  //	Editor.sendKeys(Keys.ENTER);
		  		
	  }
     
     public void typeinStringEditor(String s1){
		    action.selectBySendkeys(s1,Editor );
			
	  }
			
     public void runButton() {
 		action.click(getDriver(), RunButton);
 		//getDriver().navigate().back();
 		
 	}
     public void takeScreenShot() {
    	 action.screenShot(getDriver(), "Editor");
     }
     
    
		
}


	  

