package stepDefinations;

import java.io.IOException;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BurgerPage;
import pageObjects.ElectronicsPage;
import pageObjects.HomePage;
import pageObjects.TelevisionPage;
import pageObjects.WelcomePage;
import resources.Utilities;

public class Category extends Utilities {

	@Given("User goto home page")
	public void user_goto_home_page() throws IOException, InterruptedException {
		WelcomePage wp = new WelcomePage(testdriver);
		wp.click_Skip_Sign_In();
	}

	@And("User selects shop by department from burger menu")
	public void user_selects_shop_by_department_from_burger_menu() {
		HomePage hp = new HomePage(testdriver);
		hp.click_Burger_Menu();
	}

	@When("User choose category Electronics and sub category TV and Video")
	public void user_choose_category_electronics() throws InterruptedException {
		BurgerPage bp = new BurgerPage(testdriver);
		bp.click_Department_Category("Electronics");
		bp.click_Electronics_SubCategory();
	}

	@And("User Filter with smart TV")
	public void user_filter_with_smart_tv() throws InterruptedException {
		ElectronicsPage ep = new ElectronicsPage(testdriver);
		ep.click_Television_Category();
	}

	@And("User clicks show results")
	public void user_clicks_show_results() throws InterruptedException {
		TelevisionPage tp = new TelevisionPage(testdriver);
		tp.click_Television_Category();

	}

	@Then("Total number of results match the total displayed in filter")
	public void total_number_of_results_match_the_total_displayed_in_filter() {
		// To be implemented

	}

}
