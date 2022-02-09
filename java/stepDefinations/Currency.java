package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BurgerPage;
import resources.Utilities;

public class Currency extends Utilities {

	@When("User click on Settings")
	public void user_click_on_settings() throws InterruptedException {
		BurgerPage bp = new BurgerPage(testdriver);
		bp.click_Settings();
	}

	@And("User select Country and Language")
	public void user_select_country_and_language() throws InterruptedException {
		BurgerPage bp = new BurgerPage(testdriver);
		bp.click_CountryLanguageSettings();
	}

	@And("User changes currency from USD to AED")
	public void user_changes_currency_from_usd_to_aed() {
		// to be implemented
	}

	@Then("Selected currency displayed for Deals and Promotions products")
	public void selected_currency_displayed_for_deals_and_promotions_products() {
		// to be implemented

	}

}
