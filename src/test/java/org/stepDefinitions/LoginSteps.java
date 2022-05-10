package org.stepDefinitions;

import java.util.Properties;

import org.ElementsUtils.ConfigReader;
import org.Factory.DriverFactory;
import org.POMpages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.*;

public class LoginSteps {
	private WebDriver driver=DriverFactory.getDriver();
	private LoginPage lp=new LoginPage(driver);
	private Properties prop;
	private String actTitle;
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    prop=(new ConfigReader()).init_prop();
	    driver.get(prop.getProperty("url"));    
	}

	@When("user gets page title")
	public void user_gets_page_title() {
	    actTitle=driver.getTitle();
	    System.out.println("Title of the page is: "+actTitle);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expTitle) {
	   Assert.assertTrue(actTitle.contains(expTitle));
	}

	@Then("password forgot link should be displayed")
	public void password_forgot_link_should_be_displayed() {
	   Assert.assertTrue(lp.isForgotLinkVisible());
	}

	@When("user enters username as {string}")
	public void user_enters_username_as(String uname) {
	   lp.enterusername(uname);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String pass) {
	   lp.enterpwd(pass);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
	   lp.signin();
	}
}
