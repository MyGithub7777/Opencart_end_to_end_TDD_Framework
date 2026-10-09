package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;
import pagelayer.Homepage;
import pagelayer.Registerpage;

public class RegisterTests extends BaseClass {

	@Test
	public void verify_Register_with_valid_mandatory_details() throws InterruptedException {

		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnRegisterLink();
		Thread.sleep(5000);
		logger.info("navigated to register page");
		
		registerpage_obj.enterFirstName("Harry");
		registerpage_obj.enterLastName("Potter");
		registerpage_obj.enterEmail("harryp2@gmail.com");
		registerpage_obj.entertelephone("46467696987");
		registerpage_obj.enterPassword("Test@1234");
		registerpage_obj.enterConfirmPassword("Test@1234");
		registerpage_obj.clickOnPrivacyPolicyCheckbox();
		registerpage_obj.clickOnContinueButton();
		Thread.sleep(5000);
		logger.info("Entered data and clicked continue");
		
		String actual_result = driver.getTitle();
		String expected_result = "Your Account Has Been Created!";
		Assert.assertEquals(actual_result, expected_result);
		
	}
	
	@Test
	public void verify_Register_with_invalid_email_detail() throws InterruptedException {
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnRegisterLink();
		Thread.sleep(2000);
		logger.info("navigated to register page");
		
		registerpage_obj.enterFirstName("Harry");
		registerpage_obj.enterLastName("Potter");
		registerpage_obj.enterEmail("harryp.@com");
		registerpage_obj.entertelephone("46467696987");
		registerpage_obj.enterPassword("Test@1234");
		registerpage_obj.enterConfirmPassword("Test@1234");
		registerpage_obj.clickOnPrivacyPolicyCheckbox();
		registerpage_obj.clickOnContinueButton();
		Thread.sleep(2000);
		logger.info("Entered data and clicked continue");
		
		String expected_result = "E-Mail Address does not appear to be valid!";
		String actual_result = registerpage_obj.getEmailErrorMessage();
		Assert.assertEquals(actual_result, expected_result);
	}
	
	@Test
	public void verify_Register_with_duplicate_email_detail() throws InterruptedException {
		
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnRegisterLink();
		Thread.sleep(2000);
		logger.info("navigated to register page");
		
		registerpage_obj.enterFirstName("Harry");
		registerpage_obj.enterLastName("Potter");
		registerpage_obj.enterEmail("harryp1@gmail.com");
		registerpage_obj.entertelephone("46467696987");
		registerpage_obj.enterPassword("Test@1234");
		registerpage_obj.enterConfirmPassword("Test@1234");
		registerpage_obj.clickOnPrivacyPolicyCheckbox();
		registerpage_obj.clickOnContinueButton();
		Thread.sleep(2000);
		logger.info("Entered data and clicked continue");
		
		String expected_result = "Warning: E-Mail Address is already registered!";
		String actual_result = registerpage_obj.getEmailErrorMessage1();
		Assert.assertEquals(actual_result, expected_result);
	}
}
