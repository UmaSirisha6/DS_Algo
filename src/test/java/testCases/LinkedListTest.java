package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DataProviders;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import pageObjects.GetStartedPage;
import pageObjects.HomePage;
import pageObjects.LinkedListPage;
import pageObjects.SignInPage;
import utility.Log;

public class LinkedListTest extends BaseClass{
	
	public GetStartedPage getStartedObj = null;
	public HomePage homepageObj = null;
	public SignInPage signInObj = null;
	public LinkedListPage LlistObj =null;
	
	@BeforeMethod
	public void setup() {
		launchApp();
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.signin("Dsalgo_Proj","group@pssu");
		
		Log.info("clicking on linkedlist getstarted link"); 
		LlistObj =new LinkedListPage();
		LlistObj.clickLinkedList();
	}

	@AfterMethod
	public void tearDown() {
		getDriver().quit();
     }
	
	@Test(priority =1)
	@Severity(SeverityLevel.TRIVIAL)
    @Description("LinkedList Page Test")
	 @Story("Story Name:introductionpage check")
	public void introductionpage()  {
		
		Log.startTestCase("introductionpage");
		
		Log.info("clicking on introduction link in LinkedList page");
		LlistObj.clickIntro();
		String actUrl = LlistObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/linked-list/introduction/";
        Log.info("checking the introduction page url....");
        Assert.assertEquals(actUrl,expUrl);
        
        LlistObj.clickTryhere();
        String actTitle = LlistObj.gettitle();
        String expTitle = "Assessment";
        Log.info("checking the try Editor page in introduction page....");
        Assert.assertEquals(actTitle,expTitle);
        
        Log.info("checking run button in try Editor page ");
        if(LlistObj.isRundisplayed())
        {
        	Log.info("Run button displayed in try editor page");
        }
        else 
        {
        	Log.info("Run button NOT displayed in try editor page");
        }
        Log.endTestCase("introductionpage");
		
	}
	
	  @Test(priority = 2,dataProvider = "PyCode", dataProviderClass = DataProviders.class)
	  @Severity(SeverityLevel.NORMAL)
	  @Description("LinkedList Page Test")
	  @Story("Story Name: creatingLlistpage check")
       public void creatingLlistpage(String codeInput,String ExpOutput)  {
		
		Log.startTestCase("creatingLlistpage");
		
		Log.info("clicking on Creating a Linkelist link in LinkedList page");
		LlistObj.clickCreatingLlist();
		String actUrl = LlistObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/linked-list/creating-linked-list/";
        Log.info("checking the Creating a Linked List page url....");
        Assert.assertEquals(actUrl,expUrl);
        
        LlistObj.clickTryhere();
        String actTitle = LlistObj.gettitle();
        String expTitle = "Assessment";
        Log.info("checking the try Editor page in Creating a Linked List page....");
        Assert.assertEquals(actTitle,expTitle);
        
        LlistObj.enterPyCode(codeInput);
        LlistObj.clickRun();
        String actOutput = LlistObj.getOutput();
        Log.info("verifying output");
        Assert.assertEquals(actOutput,ExpOutput);
        Log.endTestCase("creatingLlistpage");
		
	}
	
 	  @Test(priority =3)
	  @Severity(SeverityLevel.NORMAL)
	  @Description("LinkedList Page Test")
	  @Story("Story Name: typesOfLlistPage check")
	public void typesOfLlistPage()
	{
        Log.startTestCase("typesOfLlistPage");
		
		Log.info("clicking on Types of Linkelist link in LinkedList page");
		LlistObj.clickTypesOfLlist();;
		String actUrl = LlistObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/linked-list/types-of-linked-list/";
        Log.info("checking the Types of Linked List page url....");
        Assert.assertEquals(actUrl,expUrl);
        
        LlistObj.clickTryhere();
        String actTitle = LlistObj.gettitle();
        String expTitle = "Assessment";
        Log.info("checking the try Editor page in Types of Linked List page....");
        Assert.assertEquals(actTitle,expTitle);
        
        LlistObj.enterPyCode();
        LlistObj.clickRun();
        String actOutput = LlistObj.getOutput();
        String ExpOutput = "10";
        Log.info("verifying output");
        Assert.assertEquals(actOutput,ExpOutput);
        Log.endTestCase("typesOfLlistPage");
	}
	  @Test(priority =4)
	  @Severity(SeverityLevel.NORMAL)
	  @Description("LinkedList Page Test")
	  @Story("Story Name: implLlistInPyPage check")
        public void implLlistInPyPage()  {
		
		Log.startTestCase("implLlistInPyPage");
		
		Log.info("clicking on implLlistInPy link in LinkedList page");
		LlistObj.clickImplLlistInPy();
		String actUrl = LlistObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/linked-list/implement-linked-list-in-python/";
        Log.info("checking the implLlistInPy page url....");
        Assert.assertEquals(actUrl,expUrl);
        
        LlistObj.clickTryhere();
        String actTitle = LlistObj.gettitle();
        String expTitle = "Assessment";
        Log.info("checking the try Editor page in implLlistInPy page....");
        Assert.assertEquals(actTitle,expTitle);
        
        Log.info("checking run button in try Editor page ");
        if(LlistObj.isRundisplayed())
        {
        	Log.info("Run button displayed in try editor page");
        }
        else 
        {
        	Log.info("Run button NOT displayed in try editor page");
        }
        Log.endTestCase("implLlistInPyPage");
		
	    }
      @Test (priority =5)
  	  @Severity(SeverityLevel.NORMAL)
	  @Description("LinkedList Page Test")
	  @Story("Story Name:traversalPage check")
        public void traversalPage()  {
    		
    		Log.startTestCase("traversalPage");
    		
    		Log.info("clicking on traversal link in LinkedList page");
    		LlistObj.clickTraversal();
    		String actUrl = LlistObj.currUrl();
            String expUrl = "https://dsportalapp.herokuapp.com/linked-list/traversal/";
            Log.info("checking the traversal page url....");
            Assert.assertEquals(actUrl,expUrl);
            
            LlistObj.clickTryhere();
            String actTitle = LlistObj.gettitle();
            String expTitle = "Assessment";
            Log.info("checking the try Editor page in traversal page....");
            Assert.assertEquals(actTitle,expTitle);
            
            Log.info("checking run button in try Editor page ");
            if(LlistObj.isRundisplayed())
            {
            	Log.info("Run button displayed in try editor page");
            }
            else 
            {
            	Log.info("Run button NOT displayed in try editor page");
            }
            Log.endTestCase("traversalPage");
    		
    	    }
    	@Test(priority =6)
    	  @Severity(SeverityLevel.NORMAL)
  	      @Description("LinkedList Page Test")
  	      @Story("Story Name: insertionPage check")
            public void insertionPage() {
    		
    		Log.startTestCase("insertionPage");
    		
    		Log.info("clicking on insertion link in LinkedList page");
    		LlistObj.clickinsertion();
    		String actUrl = LlistObj.currUrl();
            String expUrl = "https://dsportalapp.herokuapp.com/linked-list/insertion-in-linked-list/";
            Log.info("checking the insertion page url....");
            Assert.assertEquals(actUrl,expUrl);
            
            LlistObj.clickTryhere();
            String actTitle = LlistObj.gettitle();
            String expTitle = "Assessment";
            Log.info("checking the try Editor page in insertion page....");
            Assert.assertEquals(actTitle,expTitle);
            
            Log.info("checking run button in try Editor page ");
            if(LlistObj.isRundisplayed())
            {
            	Log.info("Run button displayed in try editor page");
            }
            else 
            {
            	Log.info("Run button NOT displayed in try editor page");
            }
            Log.endTestCase("insertionPage");
    		
    	    }
        	@Test(priority =7)
        	@Severity(SeverityLevel.NORMAL)
    	    @Description("LinkedList Page Test")
    	    @Story("Story Name: deletionPage check")
            public void deletionPage()  {
        		
        		Log.startTestCase("deletionPage");
        		
        		Log.info("clicking on deletion link in LinkedList page");
        		LlistObj.clickdeletion();
        		String actUrl = LlistObj.currUrl();
                String expUrl = "https://dsportalapp.herokuapp.com/linked-list/deletion-in-linked-list/";
                Log.info("checking the deletion page url....");
                Assert.assertEquals(actUrl,expUrl);
                
                LlistObj.clickTryhere();
                String actTitle = LlistObj.gettitle();
                String expTitle = "Assessment";
                Log.info("checking the try Editor page in deletion page....");
                Assert.assertEquals(actTitle,expTitle);
                
                Log.info("checking run button in try Editor page ");
                if(LlistObj.isRundisplayed())
                {
                	Log.info("Run button displayed in try editor page");
                }
                else 
                {
                	Log.info("Run button NOT displayed in try editor page");
                }
                Log.endTestCase("deletionPage");
        		
        	    }
            
            @Test(priority =8)
            @Severity(SeverityLevel.NORMAL)
    	      @Description("LinkedList Page Test")
    	      @Story("Story Name: pracQuestionsPage check")
            public void pracQuestionsPage() 
            {
            	Log.startTestCase("pracQuestionsPage");
            	LlistObj.clickdeletion();
            	LlistObj.clickPracQuestions();
            	String actUrl = LlistObj.currUrl();
                String expUrl = "https://dsportalapp.herokuapp.com/linked-list/practice";
                Log.info("checking the pracQuestions page url....");
                Assert.assertEquals(actUrl,expUrl);
                Log.endTestCase("pracQuestionsPage");
            }
}
