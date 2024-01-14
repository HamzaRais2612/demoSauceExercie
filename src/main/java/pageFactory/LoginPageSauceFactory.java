package pageFactory;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageSauceFactory {
	
	WebDriver driver;
	
	@FindBy(xpath="//div[@class=\"login_logo\"]")
	WebElement LoginLogoWE;
	
	@FindBy(xpath="//input[@id=\"user-name\" and @type=\"text\" ]")
	WebElement LoginInputWE;
	
	@FindBy(xpath="//input[@id=\"password\" and @type=\"password\"]")
	WebElement passwordInputWE;	
	
	@FindBy(xpath="//input[@id=\"login-button\" and @type=\"submit\"]")
	WebElement loginButtonWE;
	
	@FindBy(xpath="//h3[@data-test=\"error\" ]")
	WebElement ErrorLoginHeaderWE;
	
	  
	
	public LoginPageSauceFactory(WebDriver driverWeb) {
		this.driver=driverWeb;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void Verifier_Page_Login() {
		LoginLogoWE.getText();
	}
	
	
	public void login(String login,String pwd) {

		LoginInputWE.sendKeys(login);
		
		passwordInputWE.sendKeys(pwd);
		
		loginButtonWE.click();

	}
	
	public void verifier_Message_Erreur() {
		String msgErrezur= ErrorLoginHeaderWE.getText();
		assertEquals(msgErrezur, "Epic sadface: Username and password do not match any user in this service");

	}
	
}
