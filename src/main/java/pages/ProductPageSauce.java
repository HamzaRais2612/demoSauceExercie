package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class ProductPageSauce {

	WebDriver driver;
	By ProductsSpanBy= By.xpath("//span[contains(text(), Products) and @class=\"title\"]");
	WebElement ProductsSpanWE;


	By DescriptionDivBy= By.xpath("//div[@class=\"inventory_details_desc large_size\"]");
	WebElement DescriptionDivWE;

	By PrixDivBy= By.xpath("//div[@class=\"inventory_details_price\"]");
	WebElement PrixDivWE;


	By ajouterPanierButtonBy= By.xpath("//button[text()=\"Add to cart\"]");
	WebElement ajouterPanierButtonWE;


	By panierLinkBy= By.xpath("//div[@id=\"shopping_cart_container\"]//child::a");
	WebElement panierLinkWE;


	By yourCartSpanBy= By.xpath("//span[@class=\"title\" and text()=\"Your Cart\"]");
	WebElement yourCartSpanWE;


	By titreProduitDivBy= By.xpath("//div[@class=\"inventory_item_name\"]");
	WebElement titreProduitDivWE;


	By prixProduitDivBy= By.xpath("//div[@class=\"inventory_item_price\"]");
	WebElement prixProduitDivWE;


	By descriptionProduitDivBy= By.xpath("//div[@class=\"inventory_item_desc\"]");
	WebElement descriptionProduitDivWE;


	By removeButtonBy= By.xpath("//button[contains(text(),\"Remove\")]");
	WebElement removeButtonWE;

	By ProductLinkViaNameBy(String ProductName) {
		return By.xpath("//div[text()='"+ProductName+"']/parent::a");
	}







	public ProductPageSauce(WebDriver driverWeb) {
		this.driver=driverWeb;
	}



	public void vverfier_presence_Page_Products() {
		ProductsSpanWE = driver.findElement(ProductsSpanBy);

	}

	public void cliquer_lien_produit_By_name(String ProductName) {
		removeButtonWE = driver.findElement(ProductLinkViaNameBy(ProductName));
		removeButtonWE.click();

	}
	
	
	public void recuperer_et_comparer_Prix_et_description() {
		DescriptionDivWE = driver.findElement(DescriptionDivBy);
		assertEquals(DescriptionDivWE.getText(), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");

		PrixDivWE = driver.findElement(PrixDivBy);
		assertEquals(PrixDivWE.getText(), "$9.99");
	}
	
	public void cliquer_ajouter_Panier() {
		ajouterPanierButtonWE = driver.findElement(ajouterPanierButtonBy);
		ajouterPanierButtonWE.click();

	}
	public void cliquer_Lien_Panier() {
		panierLinkWE = driver.findElement(panierLinkBy);
		panierLinkWE.click();

	}

	public void verifier_page_panier() {
		yourCartSpanWE = driver.findElement(yourCartSpanBy);

	}

	public void verifier_produit_ajoute_au_panier() {
		titreProduitDivWE = driver.findElement(titreProduitDivBy);
		assertEquals(titreProduitDivWE.getText(), "Sauce Labs Bike Light");

		prixProduitDivWE = driver.findElement(prixProduitDivBy);
		assertEquals(prixProduitDivWE.getText(), "$9.99");


		descriptionProduitDivWE = driver.findElement(descriptionProduitDivBy);
		assertEquals(descriptionProduitDivWE.getText(), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");

	}

	public void cliquer_bouton_Remove() {
		removeButtonWE = driver.findElement(removeButtonBy);
		removeButtonWE.click();

	}

	public void verifier_non_presence_produit_By_name(String ProductName) {
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.invisibilityOfElementLocated(ProductLinkViaNameBy(ProductName)));

	}
	
}
