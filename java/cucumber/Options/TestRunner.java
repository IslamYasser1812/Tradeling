package cucumber.Options;

import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;




@CucumberOptions(features = "src/test/java/features", plugin = {"pretty","json:target/jsonReports/cucumber-report.json", "rerun:target/cucumber-reports/rerun.txt" }
,glue = {"src/test/java/stepDefinations"})
public class TestRunner{
	private TestNGCucumberRunner testNGCucumberRunner;
	
@BeforeClass(alwaysRun = true)
public void setUpClass() {
	testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
}

@Test(groups = "cucumber", description = "Runs cucumber features", dataProvider = "features")
public void feature(CucumberFeatureWrapper cucumberFeature) {
	testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
}

@DataProvider
public Object[][] features(){
	return testNGCucumberRunner.provideFeatures();
}

@AfterClass(alwaysRun = true)
public void testDownClass() {
	testNGCucumberRunner.finish();
}

}
