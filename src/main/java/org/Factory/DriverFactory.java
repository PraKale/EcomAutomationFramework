package org.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver=new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(String browser) {
		System.out.println("Name of the browser is: "+browser);
		switch(browser) {
		case "chrome":
		{
			WebDriverManager.chromedriver().setup();
			tldriver.set(new ChromeDriver());
			break;
		}
		case "firefox":
		{
			WebDriverManager.firefoxdriver().setup();
			tldriver.set(new FirefoxDriver());
		}
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	}
}
