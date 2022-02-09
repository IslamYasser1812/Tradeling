package stepDefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage;
import pageObjects.ProductDisplaypage;
import resources.Utilities;

public class DealsAndPromotions extends Utilities {

	@When("User Select Deals from Home Page")
	public void user_Select_Deals_from_Home_Page() {
		HomePage hp = new HomePage(testdriver);
		hp.click_Deals();
	}

	@When("User choose category Computers and sub category Software Department")
	public void user_choose_category_computers_and_sub_category_software_department() throws InterruptedException {
		ProductDisplaypage pDP = new ProductDisplaypage(testdriver);
		pDP.click_Category_Filter();
		pDP.select_Category_Icon("Computers");

		// to be implemented Software section
	}

	@Then("Selected department is displayed")
	public void selected_department_is_displayed() {

		// to be implemented to assert on page title

	}

}
