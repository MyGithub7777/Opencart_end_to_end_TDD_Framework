package pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {

	private WebDriver driver;
	public Homepage(WebDriver d) {
		driver = d;
		PageFactory.initElements(driver, this);
	}
	
	//--------------Obj repo ---------------------
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myaccount_link;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement login_link;
	
	@FindBy(xpath="//a[contains(text(),'Register')]")
	private WebElement register_link;
	
	
	//------------ Action methods ----------------
	public void clickOnMyAccountLink()
	{
		myaccount_link.click();
	}
	
	public void clickOnLoginLink()
	{
		login_link.click();
	}
	
	public void clickOnRegisterLink()
	{
		register_link.click();
	}
}
