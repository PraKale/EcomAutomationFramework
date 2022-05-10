package org.POMpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	private WebDriver driver;
	//WebElements
	private By emailId=By.cssSelector("#email");
	private By pwd=By.cssSelector("#passwd");
	private By forgotPwdLink=By.linkText("Forgot your password?");
	private By login=By.id("SubmitLogin");
	
	//constructors
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	//action methods
	public void enterusername(String uname) {
		driver.findElement(emailId).sendKeys(uname);
	}
	public void enterpwd(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	public void signin() {
		driver.findElement(login).click();
	}
	public Boolean isForgotLinkVisible() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	public String gettitle() {
		return driver.getTitle();
	}
}
