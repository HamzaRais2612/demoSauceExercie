package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;


public class ProductPageSauceFactory {

	WebDriver driver;
	@FindBy(xpath="//span[contains(text(), Products) and @class=\"title\"]")
	WebElement ProductsSpanWE;


	@FindBy(xpath="//div[@class=\"inventory_details_desc large_size\"]")
	WebElement DescriptionDivWE;

	@FindBy(xpath="//div[@class=\"inventory_details_price\"]")
	WebElement PrixDivWE;


	@FindBy(xpath="//button[text()=\"Add to cart\"]")
	WebElement ajouterPanierButtonWE;


	@FindBy(xpath="//div[@id=\"shopping_cart_container\"]//child::a")
	WebElement panierLinkWE;


	@FindBy(xpath="//span[@class=\"title\" and text()=\"Your Cart\"]")
	WebElement yourCartSpanWE;


	@FindBy(xpath="//div[@class=\"inventory_item_name\"]")
	WebElement titreProduitDivWE;


	@FindBy(xpath="//div[@class=\"inventory_item_price\"]")
	WebElement prixProduitDivWE;


	@FindBy(xpath="//div[@class=\"inventory_item_desc\"]")
	WebElement descriptionProduitDivWE;


	By removeButtonBy= By.xpath("//button[contains(text(),\"Remove\")]");
	WebElement removeButtonWE;









	public ProductPageSauceFactory(WebDriver driverWeb) {
		this.driver=driverWeb;
		PageFactory.initElements(driver, this);
	}

	By ProductLinkViaNameBy(String ProductName) {
		return By.xpath("//div[text()='"+ProductName+"']/parent::a");
	}


	public void vverfier_presence_Page_Products() {
		ProductsSpanWE.getText();

	}

	public void cliquer_lien_produit_By_name(String ProductName) {
		removeButtonWE = driver.findElement(ProductLinkViaNameBy(ProductName));
		removeButtonWE.click();

	}
	
	
	public void recupérer_et_comparer_Prix_et_description() {
		assertEquals(DescriptionDivWE.getText(), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");

		assertEquals(PrixDivWE.getText(), "$9.99");
	}
	
	public void cliquer_ajouter_Panier() {
		ajouterPanierButtonWE.click();

	}
	public void cliquer_Lien_Panier() {
		panierLinkWE.click();

	}

	public void verifier_page_panier() {
		yourCartSpanWE.getText();
		

	}

	public void verifier_produit_ajouté_au_panier() {
		assertEquals(titreProduitDivWE.getText(), "Sauce Labs Bike Light");

		assertEquals(prixProduitDivWE.getText(), "$9.99");


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
