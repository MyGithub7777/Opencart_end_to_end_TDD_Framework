package pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	private final WebDriver driver;

	public Loginpage(WebDriver d) {
		driver = d;
	}

	// -------------- Object repository ---------------------
	private final By email_txtbox = By.id("input-email");
	private final By password_txtbox = By.id("input-password");
	private final By login_btn = By.xpath("//input[@value='Login']");
	private final By forgotten_password_link = By.linkText("Forgotten Password");
	private final By warning_message = By.cssSelector(".alert.alert-danger");

	// ---------------- Action methods -----------------------
	public void enterEmail(String email) {
		driver.findElement(email_txtbox).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(password_txtbox).sendKeys(password);
	}

	public void clickOnLoginButton() {
		driver.findElement(login_btn).click();
	}

	public void login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickOnLoginButton();
	}

	public void clickOnForgottenPasswordLink() {
		driver.findElement(forgotten_password_link).click();
	}

	public String getWarningMessage() {
		return driver.findElement(warning_message).getText();
	}
}
