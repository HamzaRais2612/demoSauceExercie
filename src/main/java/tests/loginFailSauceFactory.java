package tests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.LoginPageSauceFactory;
import pages.LoginPageSauce;

import java.io.*;
import java.util.concurrent.TimeUnit;


public class loginFailSauceFactory {


	String siteDemo="https://www.saucedemo.com/";
	String username="Hamza";
	WebDriver driver;
	
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void Setup() {

		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();  
	}

	@Test
	public void loginFailSauceFactory() throws Exception {
		//1
		driver.get(siteDemo);
		LoginPageSauceFactory pLoginPageSauce = new LoginPageSauceFactory(driver);
		pLoginPageSauce.Verifier_Page_Login();
		pLoginPageSauce.login("formation","selenium");
		pLoginPageSauce.verifier_Message_Erreur();
		

	}

	@AfterTest
	public void Teardown() throws Exception {
		//close browser
		this.takeSnapShot(driver, System.getProperty("user.dir")+"//Screenshots//test.png");

		driver.close();
	}

	private void copyFileUsingStream(File source, File dest) throws IOException {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	private void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

		//Convert web driver object to TakeScreenshot

		TakesScreenshot scrShot =((TakesScreenshot)webdriver);

		//Call getScreenshotAs method to create image file

		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

		//Move image file to new destination

		File DestFile=new File(fileWithPath);
		this.copyFileUsingStream(SrcFile, DestFile);

	}

}
