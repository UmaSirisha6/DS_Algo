package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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
import pageObjects.SignInPage;
import pageObjects.TreePage;
import utility.Log;

public class TreeTest extends BaseClass{

	public GetStartedPage getStartedObj = null;
	public HomePage homepageObj = null;
	public SignInPage signInObj = null;
	public TreePage treeObj = null;
	
	@BeforeClass
	public void openinglink()
	{
		launchApp();
		getStartedObj = new GetStartedPage();
		homepageObj = getStartedObj.getStarted();
		signInObj = homepageObj.clickOnSignInLink();
		signInObj.signin("Dsalgo_Proj","group@pssu");
		
		Log.info("clicking on tree getstarted link"); 
		treeObj =new TreePage();
		treeObj.clickTree();
	}
	@AfterClass
	public void closing()
	{
		getDriver().quit();
	}
	@BeforeMethod
	public void setup() {
		//Log.info("starting test case");
	}
	
	@AfterMethod
	public void tearDown() {
		
		getDriver().navigate().back();
		getDriver().navigate().back();
		//getDriver().quit();
     }
	
	@Test ( priority = 1 )
	@Severity(SeverityLevel.NORMAL)
    @Description("Tree Page Test")
    @Story("Story Name: ovrvwOfTreesPage check")
	public void ovrvwOfTreesPage()
	{
        Log.startTestCase("ovrvwOfTreesPage");
		
		Log.info("clicking on ovrvwOfTreesPage link in tree page");
		treeObj.clickOvrvwOfTrees();
		String actUrl = treeObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/tree/overview-of-trees/";
        Log.info("checking the introduction page url....");
        Assert.assertEquals(actUrl,expUrl);
        
        treeObj.clickTryhere();
        String actTitle = treeObj.gettitle();
        String expTitle = "Assessment";
        Log.info("checking the try Editor page in ovrvwOfTreesPage....");
        Assert.assertEquals(actTitle,expTitle);
        
        Log.info("checking run button in try Editor page ");
        if(treeObj.isRundisplayed())
        {
        	Log.info("Run button displayed in try editor page");
        }
        else 
        {
        	Log.info("Run button NOT displayed in try editor page");
        }
        Log.endTestCase("ovrvwOfTreesPage");
	}
	
	@Test(priority =2 ,dataProvider = "PyCode", dataProviderClass = DataProviders.class)
	@Severity(SeverityLevel.NORMAL)
    @Description("Tree Page Test")
    @Story("Story Name: terminologiesPage check")
    public void terminologiesPage(String codeInput,String ExpOutput) throws InterruptedException  {
		
		Log.startTestCase("terminologiesPage");
		
		Log.info("clicking on terminologies link in Tree page");
		treeObj.clickterminologies();
		String actUrl = treeObj.currUrl();
     String expUrl = "https://dsportalapp.herokuapp.com/tree/terminologies/";
     Log.info("checking the terminologies page url....");
     Assert.assertEquals(actUrl,expUrl);
     
     treeObj.clickTryhere();
     String actTitle = treeObj.gettitle();
     String expTitle = "Assessment";
     Log.info("checking the try Editor page in Creating a Linked List page....");
     Assert.assertEquals(actTitle,expTitle);
     
     treeObj.enterPyCode(codeInput);
     treeObj.clickRun();
     Thread.sleep(1000l);
     String actOutput = treeObj.getOutput();
     
     Log.info("verifying output");
     Assert.assertEquals(actOutput,ExpOutput);
     Log.endTestCase("terminologiesPage");
		
	}
	
	@Test( priority = 3 )
	@Severity(SeverityLevel.NORMAL)
    @Description("Tree Page Test")
    @Story("Story Name: typesOfTreesPage check")
	public void typesOfTreesPage()
	{
       Log.startTestCase("typesOfTreesPage");
		
		Log.info("clicking on Types of Linkelist link in LinkedList page");
		treeObj.clickTypesOfTrees();;
		String actUrl = treeObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/tree/types-of-trees/";
        Log.info("checking the Types of Trees page url....");
        Assert.assertEquals(actUrl,expUrl);
        
        treeObj.clickTryhere();
        String actTitle = treeObj.gettitle();
        String expTitle = "Assessment";
        Log.info("checking the try Editor page in Types of Linked List page....");
        Assert.assertEquals(actTitle,expTitle);
        
        treeObj.enterPyCode();
        treeObj.clickRun();
        String actOutput = treeObj.getOutput();
        String ExpOutput = "10";
        Log.info("verifying output");
        Assert.assertEquals(actOutput,ExpOutput);
        Log.endTestCase("typesOfTreesPage");
	}
	
	@Test ( priority = 4 )
	@Severity(SeverityLevel.NORMAL)
    @Description("Tree Page Test")
    @Story("Story Name: treeTraversalsPage check")
	public void treeTraversalsPage()
	{
        Log.startTestCase("treeTraversalsPage");
		
		Log.info("clicking on treeTraversalsPage link in tree page");
		treeObj.clickTreeTraversals();
		String actUrl = treeObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/tree/tree-traversals/";
        Log.info("checking the introduction page url....");
        Assert.assertEquals(actUrl,expUrl);
        
        treeObj.clickTryhere();
        String actTitle = treeObj.gettitle();
        String expTitle = "Assessment";
        Log.info("checking the try Editor page in treeTraversalsPage....");
        Assert.assertEquals(actTitle,expTitle);
        
        Log.info("checking run button in try Editor page ");
        if(treeObj.isRundisplayed())
        {
        	Log.info("Run button displayed in try editor page");
        }
        else 
        {
        	Log.info("Run button NOT displayed in try editor page");
        }
        Log.endTestCase("treeTraversalsPage");
	}
	
	@Test ( priority = 5 )
	@Severity(SeverityLevel.NORMAL)
    @Description("Tree Page Test")
    @Story("Story Name: travIllustartionPage check")
	public void travIllustartionPage()
	{
        Log.startTestCase("travIllustartionPage");
		
		Log.info("clicking on travIllustartion link in tree page");
		treeObj.clickTravIllustartion();
		String actUrl = treeObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/tree/traversals-illustration/";
        Log.info("checking the travIllustartion page url....");
        Assert.assertEquals(actUrl,expUrl);
        
        treeObj.clickTryhere();
        String actTitle = treeObj.gettitle();
        String expTitle = "Assessment";
        Log.info("checking the try Editor page in travIllustartionPage....");
        Assert.assertEquals(actTitle,expTitle);
        
        Log.info("checking run button in try Editor page ");
        if(treeObj.isRundisplayed())
        {
        	Log.info("Run button displayed in try editor page");
        }
        else 
        {
        	Log.info("Run button NOT displayed in try editor page");
        }
        Log.endTestCase("travIllustartionPage");
	}
	
	@Test ( priority = 6 )
	@Severity(SeverityLevel.NORMAL)
    @Description("Tree Page Test")
    @Story("Story Name: binaryTreesPage check")
	public void binaryTreesPage()
	{
        Log.startTestCase("binaryTreesPage");
		
		Log.info("clicking on binaryTrees Page link in tree page");
		treeObj.clickBinaryTrees();
		String actUrl = treeObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/tree/binary-trees/";
        Log.info("checking the binaryTrees page url....");
        Assert.assertEquals(actUrl,expUrl);
        
        treeObj.clickTryhere();
        String actTitle = treeObj.gettitle();
        String expTitle = "Assessment";
        Log.info("checking the try Editor page in binaryTreesPage....");
        Assert.assertEquals(actTitle,expTitle);
        
        Log.info("checking run button in try Editor page ");
        if(treeObj.isRundisplayed())
        {
        	Log.info("Run button displayed in try editor page");
        }
        else 
        {
        	Log.info("Run button NOT displayed in try editor page");
        }
        Log.endTestCase("binaryTreesPage");
	}
	
	 
 @Test( priority = 7 )
 @Severity(SeverityLevel.NORMAL)
 @Description("Tree Page Test")
 @Story("Story Name: pracQuestionsPage check")
    public void pracQuestionsPage() 
    {
    	Log.startTestCase("pracQuestionsPage");
    	treeObj.clickBinaryTrees();
    	treeObj.clickPracQuestions();
    	String actUrl = treeObj.currUrl();
        String expUrl = "https://dsportalapp.herokuapp.com/tree/practice";
        Log.info("checking the pracQuestions page url....");
        Assert.assertEquals(actUrl,expUrl);
        Log.endTestCase("pracQuestionsPage");
    }
}
