package appliHooks;

import java.util.Properties;

import org.ElementsUtils.ConfigReader;
import org.Factory.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory df;
	private WebDriver driver;
	private ConfigReader cf;
	private Properties prop;
	
	@Before(order=0)
	public void getProp() {
		cf=new ConfigReader();
		prop=cf.init_prop();
	}
	@Before(order=1)
	public void launchBrowser() {
		String bName=prop.getProperty("browser");
		df=new DriverFactory();
		driver=df.init_driver(bName);
	}
	
	@After(order=0) 
	public void tearDown() {
		driver.quit();
	}
	@After(order=1)
	public void getScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
		String scName=scenario.getName().replaceAll(" ", "_");
		byte[] source=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(source, "image/png", scName);
		}
	}
}
