package Practice.DummyProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utility.Util;
import base.TestBase;

public class LoadTest01Test extends TestBase {

	LoadTest01 loginPage;
	Util testUtil;

	public LoadTest01Test(){
		super();
	}

	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoadTest01();	
	}

	@Test(priority=1)
	public void loginPageTitleTest() throws InterruptedException, IOException{
		String title = loginPage.validateLoginPageTitle();
		//Assert.assertEquals(title, "#1 Free CRM for Any Business: Online Customer Relationship Software");
		//Assert.assertEquals(title,"Prime Cloud V5.8.0.0");

		Util.runTimeInfo("info", title);

		if (title.equals("Prime Cloud V5.10.0.0")) {
			Util.runTimeInfo("info", "title is correct!! YAY!!!");
			Assert.assertTrue(true);
		} else {
			Util.runTimeInfo("error", "title is not correct!! BUG BUG BUG!!!");
			Util.takeScreenshotAtEndOfTest();
			Assert.assertTrue(false);
		}

	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

