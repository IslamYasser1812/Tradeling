package stepDefinations;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import resources.Utilities;

public class Hooks extends Utilities {
	
	Logger log = LogManager.getLogger(Hooks.class.getName());
	
	@Before
	public void setUp() throws IOException, InterruptedException {
		driverInit();
	}
	
	@After
	public void endTest(Scenario scenario) {
		if(scenario.isFailed())
		{
			try {
				log.info(scenario.getName() + " is Fail");
				final byte[] screenShot = ((TakesScreenshot) testdriver).getScreenshotAs(OutputType.BYTES);
				scenario.attach(screenShot, "image/png", "Screensot");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		testdriver.quit();
	}

}
