package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPageSauce;
import pages.ProductPageSauce;


public class TestPomProductInteractHub {

	String nomProduit="Sauce Labs Bike Light";
	String siteDemo="https://www.saucedemo.com/";
	String username="Hamza";
	WebDriver driver;
	
	@Parameters("browser")
	@SuppressWarnings("deprecation")
	@BeforeTest
	public void Setup(String browser) throws MalformedURLException {

		String hubUrl = "http://localhost:4444/wd/hub";

        // Specify desired capabilities (browser, version, platform, etc.)
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        if (browser.equalsIgnoreCase("chrome")) {
        	capabilities.setBrowserName("chrome");
        	
        } else if (browser.equalsIgnoreCase("firefox")) {
        	capabilities.setBrowserName("firefox");
        	
        } else {
            throw new IllegalArgumentException("Invalid browser parameter");
        }

        // Initialize WebDriver using RemoteWebDriver and hub URL
        driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
        
        driver.manage().window().maximize(); 
	}

	@Test
	public void TestPomProductInteractHub() throws Exception {
		//1
		driver.get(siteDemo);
		
		
		
		
		LoginPageSauce pLoginPageSauce = new LoginPageSauce(driver);
		pLoginPageSauce.Verifier_Page_Login();
		pLoginPageSauce.login("standard_user","secret_sauce");

		ProductPageSauce pProductPageSauce = new ProductPageSauce(driver);
		pProductPageSauce.vverfier_presence_Page_Products();
		pProductPageSauce.cliquer_lien_produit_By_name(nomProduit);
		pProductPageSauce.recuperer_et_comparer_Prix_et_description();
		pProductPageSauce.cliquer_ajouter_Panier();
		pProductPageSauce.cliquer_Lien_Panier();
		pProductPageSauce.verifier_page_panier();
		pProductPageSauce.verifier_produit_ajoute_au_panier();
		pProductPageSauce.cliquer_bouton_Remove();
		pProductPageSauce.verifier_non_presence_produit_By_name(nomProduit);


		

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
