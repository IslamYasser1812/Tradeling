package resources;

import java.io.IOException;
import java.net.ServerSocket;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.console.automation.AppiumFramework.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utilities extends Base {

	public static AppiumDriver<MobileElement> testdriver;

	public void driverInit() throws IOException, InterruptedException {
		//service = startServer();
		testdriver = DesiredCapabilities();
	}

	public void driverClosure() {
		service.stop();
	}
	public void driverClosing(AppiumDriver<MobileElement> driver) {
		driver.close();
	}

	public boolean verify_element_Present(MobileElement element) {
		boolean res = false;

		try {
			res = element.isDisplayed();
			// log.info("User found element is present : " + res);
			return res;
		} catch (Exception e) {
			// log.info("User found element is present : " + res);
			return res;
		}
	}

	public static void waitForVisibility(AppiumDriver<MobileElement> driver, MobileElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void scrollToElementByText(AndroidDriver<MobileElement> driver, String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");

	}

	public void scrollUsingTouchActionsByElements(AppiumDriver<MobileElement> driver, MobileElement element)
			throws InterruptedException {
		while (!verify_element_Present(element)) {
			Duration smallWait = Duration.ofMillis(1000);
			Dimension size = driver.manage().window().getSize();
			int startY = (int) (size.height * 0.70);
			int endY = (int) (size.height * 0.30);
			int startX = size.width / 2;

			TouchAction tAction = new TouchAction(driver);
			tAction.press(PointOption.point(startX, startY)).waitAction(WaitOptions.waitOptions(smallWait))
					.moveTo(PointOption.point(startX, endY)).release().perform();
		}
	}

	public void swipeRightToLeftOnElement(int yAxis) {
//		log.info("About to swipe from Right to Left");
		Duration smallWait = Duration.ofMillis(1000);
		Dimension size = testdriver.manage().window().getSize();
		int startX = (int) (size.width - size.width / 15);
		int startY = (int) yAxis;

		int endX = (int) (size.width / 1008.0);
//		int endY = (int) yAxis;

		TouchAction tAction = new TouchAction(testdriver);
		tAction.press(PointOption.point(endX, startY)).waitAction(WaitOptions.waitOptions(smallWait))
				.moveTo(PointOption.point(startX, startY)).release().perform();
//		log.info("Swipe from Right to Left completed");
	}

	public void keypad_Go(AppiumDriver<MobileElement> driver) {
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}
}
