package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass {

	@Test(groups = {"master"})
	public void test_account_Registration()
	{
	try
	{
		logger.info("TC_001_AccountRegistration Started.........");
		driver.get(rb.getString("appURL"));
		logger.info("Application is Launched");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Account is Clicked");
		hp.clickRegister();
		logger.info("Register is Clicked");

		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);

		regpage.setFirstName("aabbcc");
		logger.info("First Name Entered");
		regpage.setLastName("sshhff");
		logger.info("Last Name entered");
		regpage.setEmail(randomestring()+"@gmail.com");
		logger.info("Email Entered");
		regpage.setTelephone("98765655");
		logger.info("Phone Number entered");
		regpage.setPassword("abcxyz");
		logger.info("Password id entered");
		regpage.setConfirmPassword("abcxyz");
		logger.info("Reset Password is entered");
		regpage.setPrivacyPolicy();
		logger.info("Privacy policy clicked");

		regpage.clickContinue();
		logger.info("Continue is clicked");

		String confmsg=regpage.getConfirmationMsg();

		if(confmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration is passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			captureScreen(driver, "test_account_Registration");
			logger.error("Account Registration is failed");
			Assert.assertTrue(false);
		
		}
		logger.info("TC_001_AccountRegistration Completed");


	}
	catch(Exception e)
	{
		logger.error("Account Registration is failed");
		Assert.fail();
	}
	}
//	@Test(priority = 2)
//	public void test()
//	{
//		System.out.println("test method executed");
//	}
	
	

}