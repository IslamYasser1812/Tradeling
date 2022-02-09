package stepDefinations;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.PDPage;
import pageObjects.SearchResults;
import resources.Utilities;

public class PDP extends Utilities {

	@When("User Search for {string} and select first product")
	public void user_search_for_apple(String searchValue) {
		HomePage hp = new HomePage(testdriver);
		hp.search_Amazon(searchValue);
		SearchResults sr = new SearchResults(testdriver);
		sr.select_First_Product();
	}

	@And("User swipe the product images")
	public void user_swipe_the_product_images() {
		PDPage pDP = new PDPage(testdriver);
		pDP.swipeImage();
	}

	@Then("Price of product displayed")
	public void price_of_product_displayed() {
		PDPage pDP = new PDPage(testdriver);
		assertTrue(pDP.productPrice().contains("AED"));
	}

	@And("Payment Options are displayed")
	public void payment_options_are_displayed() {
		// to be implemented
	}

	@And("Product availability information is displayed")
	public void product_availability_information_is_displayed() throws InterruptedException {
		PDPage pDP = new PDPage(testdriver);
		String availabilityString = pDP.checkProductAvailability();
		assertTrue(availabilityString.contains("Stock"));
	}

	@And("Add to cart functionality works fine")
	public void add_to_cart_functionality_works_fine() throws InterruptedException {
		PDPage pDP = new PDPage(testdriver);
		pDP.click_Add_To_Cart();
		assertTrue(pDP.check_Cart_Added_Confirmation());

	}

}
