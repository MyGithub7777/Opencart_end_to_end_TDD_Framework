package testlayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import baselayer.BaseClass;
import pagelayer.Loginpage;

public class LoginTests extends BaseClass {

	private Loginpage loginpage_obj;

	@Test
	public void verify_login_with_valid_details() {
		homepage_obj.clickOnMyAccountLink();
		homepage_obj.clickOnLoginLink();
		loginpage_obj = new Loginpage(driver);

		// Supply credentials for an existing account on the OpenCart site.
		loginpage_obj.login("existing-user@example.com", "your-password");

		Assert.assertEquals(driver.getTitle(), "My Account");
	}
}
