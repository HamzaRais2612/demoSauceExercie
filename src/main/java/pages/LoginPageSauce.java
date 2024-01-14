package pages;



import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPageSauce {
	
	WebDriver driver;
	
	By LoginLogoBy= By.xpath(" //div[@class=\"login_logo\"]");
	WebElement LoginLogoWE;
	
	By LoginInputBy= By.xpath("//input[@id=\"user-name\" and @type=\"text\" ]");
	WebElement LoginInputWE;
	
	By passwordInputBy= By.xpath("//input[@id=\"password\" and @type=\"password\"]");
	WebElement passwordInputWE;	
	
	By loginButtonBy= By.xpath("//input[@id=\"login-button\" and @type=\"submit\"]");
	WebElement loginButtonWE;
	
	By ErrorLoginHeaderBy= By.xpath("//h3[@data-test=\"error\" ]");
	WebElement ErrorLoginHeaderWE;
	
	  
	
	public LoginPageSauce(WebDriver driverWeb) {
		this.driver=driverWeb;
	}
	
	
	
	public void Verifier_Page_Login() {
		LoginLogoWE = driver.findElement(LoginLogoBy);

	}
	
	
	public void login(String login,String pwd) {
		LoginInputWE = driver.findElement(LoginInputBy);
		LoginInputWE.sendKeys(login);
		
		passwordInputWE = driver.findElement(passwordInputBy);
		passwordInputWE.sendKeys(pwd);
		
		loginButtonWE = driver.findElement(loginButtonBy);
		loginButtonWE.click();

	}
	
	public void verifier_Message_Erreur() {
		ErrorLoginHeaderWE = driver.findElement(ErrorLoginHeaderBy);
		String msgErrezur= ErrorLoginHeaderWE.getText();
		assertEquals(msgErrezur, "Epic sadface: Username and password do not match any user in this service");

	}
	
}
