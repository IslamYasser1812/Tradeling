package pageObjects;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import resources.Utilities;

public class ElectronicsPage extends Utilities{
	AppiumDriver<MobileElement> driver;
	public ElectronicsPage(AppiumDriver<MobileElement> testdriver) 
	{
		this.driver = testdriver;
		PageFactory.initElements(new AppiumFieldDecorator(testdriver), this);
	}
	
	@AndroidFindBy(accessibility = "<br> ### Televisions")
	MobileElement televisionCategory;
	
	public void click_Television_Category() throws InterruptedException {
		scrollUsingTouchActionsByElements(driver, televisionCategory);
		waitForVisibility(driver, televisionCategory);
		televisionCategory.click();
	}

}
