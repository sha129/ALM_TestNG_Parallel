import java.awt.image.RenderedImage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hp.lft.report.ReportException;
import com.hp.lft.report.Reporter;
import com.hp.lft.report.Status;
import com.hp.lft.sdk.*;
import com.hp.lft.sdk.internal.web.BrowserTypeProperty;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;
import com.hp.lft.verifications.*;

import unittesting.*;

public class LeanFtTest extends UnitTestClassBase {

    @BeforeClass
    public void beforeClass() throws Exception {
    }

    @AfterClass
    public void afterClass() throws Exception {
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
    }

    @AfterMethod
    public void afterMethod() throws Exception {
    }

    @Test(dataProvider="BrowserTypes")
    public void parallelDataProviderTest(BrowserType browserTypeToLaunch) throws Exception {
    	Browser browser = BrowserFactory.launch(browserTypeToLaunch);
    	browser.navigate("www.sce.com");
    	browser.sync();
    	
		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("fullLoginEmail")
				.tagName("INPUT")
				.type("text").build()).setValue("onir2b@gmail.com");

		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("fullLoginPassword")
				.tagName("INPUT")
				.type("password").build()).setSecure("Edison123");

		browser.describe(Button.class, new ButtonDescription.Builder()
				.accessibilityName("Log In")
				.buttonType("")
				.name("●Log In")
				.role("button")
				.tagName("SPAN")
				.index(0).build()).click();

		browser.describe(WebElement.class, new WebElementDescription.Builder()
				.className("messageContent")
				.innerText("Sorry, your email and/or password was incorrect. Please try again. Need to make a payment? Pay Now")
				.tagName("DIV").build()).click();

    	
    	
    	//Reporter.reportEvent("Info", "Browser launched: " + browserTypeToLaunch + ", Thread id = " + Thread.currentThread().getId());
    	//browser.close();
    	
    	RenderedImage img = browser.getPage().getSnapshot();
    	
    		Reporter.reportEvent("Verify URL launch", "URL is launched successfully", Status.Passed,img);
    	
    	
    } 
    
    
    
    
	 @DataProvider(name="BrowserTypes", parallel=true)
    public Object[][] dp2(){
    	return new Object[][] {
    		{BrowserType.CHROME},
    		//{BrowserType.FIREFOX},
    		{BrowserType.INTERNET_EXPLORER}
    	};
    }
    
    
    //@Test(invocationCount = 10, threadPoolSize = 3)
	 // public void testMultiInvocation() throws ReportException {
	             //   String msg = "MultiInvocation: Thread id = " + Thread.currentThread().getId();
	             //    Reporter.reportEvent(msg, msg);
	//  }
}

    //@Test
    //public void test_Chrome() throws GeneralLeanFtException, ReportException { testBrowser1(BrowserType.CHROME, "Chrome_1");
    //}

   //@Test
   // public void test_Firefox() throws GeneralLeanFtException, ReportException { testBrowser1(BrowserType.FIREFOX, "IE_1");
  // }
   
   
  // @Test
  	//public void testBrowser1(BrowserType browserType, String category)
     // throws GeneralLeanFtException, ReportException {
      //	String url = "www.sce.com/";
      //	Browser browser = BrowserFactory.launch(browserType);
      	//browser.navigate(url);
      	//browser.sync();
    
  		//browser.describe(EditField.class, new EditFieldDescription.Builder()
  				//.name("fullLoginEmail")
  				//.tagName("INPUT")
  				//.type("text").build()).setValue("shalini");

  		//browser.describe(Button.class, new ButtonDescription.Builder()
  		//	.buttonType("")
  			//.name("Log In/Register")
  			//.tagName("A").build()).click();
      //}

  
   //@Test(dataProvider="BrowserTypes")
   //public Object[][] dp2() {
   //	return new Object[][]{
   		//{BrowserType.CHROME},
   		//{BrowserType.INTERNET_EXPLORER},
   		//{BrowserType.FIREFOX}
   //	};

  // }

   
   
   
   	

    //@Test
    //public void test_IE() throws GeneralLeanFtException, ReportException { testBrowser(BrowserType.INTERNET_EXPLORER, "LAPTOPS");
   // }

    //public void testBrowser(BrowserType browserType, String category)
          //  throws ReportException, GeneralLeanFtException {
       // String url = "http://www.advantageonlineshopping.com/";
       // Browser browser = BrowserFactory.launch(browserType);
       // browser.navigate(url);

       // WebElement categoryElement = browser.describe(WebElement.class,
           // new WebElementDescription.Builder()
               // .className("shop_now roboto-bold ng-binding")
               // .tagName("SPAN")
               // .innerText(category).build());
       // categoryElement.click();

       // browser.sync();

       // WebElement categoryLink = browser.describe(WebElement.class,
           // new WebElementDescription.Builder()
              //  .className("select ng-binding")
              //  .tagName("A")
              //  .innerText(category + " ").build());

    //Verify.areEqual(categoryLink.getInnerText().trim(), category,
                  //  String.format("Make sure you've reached the %s category page", category )); browser.close();
   // }
    
    
    
    
    
   // @Test
   // public void test_Chrome() throws GeneralLeanFtException, ReportException {
    //	testBrowser(BrowserType.CHROME, "TABLETS");
   // }
    
    //@Test
    //public void test_IE () throws GeneralLeanFtException, ReportException {
    //	testBrowser(BrowserType.INTERNET_EXPLORER, "LAPTOPS");
    //}
    
   // @Test
    //public void test_Firefox () throws GeneralLeanFtException, ReportException {
    	//testBrowser(BrowserType.FIREFOX, "MICE");
   // }
    
   // @Test
	//public void testBrowser(BrowserType browserType, String category)
    //throws GeneralLeanFtException, ReportException {
    //	String url = "www.sce.com/";
    //	Browser browser = BrowserFactory.launch(browserType);
    //	browser.navigate(url);
    //	browser.sync();
    	
    	//@DataProvider(name="BrowserTypes", parallel=true)
    	//public Object[][] dp2() {
    		//return new Object[][]{
    			//{BrowserType.CHROME},
    			//{BrowserType.INTERNET_EXPLORER},
    			//{BrowserType.FIREFOX}
    		//};

    	//}
    	
    	
    
    	
		///Browser browser = BrowserFactory.launch(BrowserType.CHROME);

		///browser.navigate("http://www.sce.com/");

		//browser.describe(EditField.class, new EditFieldDescription.Builder()
			//	.name("fullLoginEmail")
			//	.tagName("INPUT")
			//	.type("text").build()).setValue("shalini");

		//browser.describe(Button.class, new ButtonDescription.Builder()
		//	.buttonType("")
			//.name("Log In/Register")
			//.tagName("A").build()).click();

   // }

