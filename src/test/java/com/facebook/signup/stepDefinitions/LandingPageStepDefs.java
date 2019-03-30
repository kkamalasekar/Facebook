package com.facebook.signup.stepDefinitions;

/*@After method is commented 
 out for verification purpose
*/
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.facebook.signup.pages.LandingPage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LandingPageStepDefs {

	public WebDriver driver;
	LandingPage lPage = new LandingPage();
	LocalDateTime localDateTime = LocalDateTime.now();
	DateTimeFormatter stamp = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
	String timeStamp = localDateTime.format(stamp);

	@Before
	public void before() {
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir", ".") + "/project.properties");
		FileInputStream fStream = null;
		try {
			fStream = new FileInputStream(file);
			prop.load(fStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		String browser = prop.getProperty("browser");

		switch (browser) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir", ".") + "/bin/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();

			/*
			 * case "fireox": firefox or other browser properties goes in here
			 */
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Given("^user navigates to Facebook homepage$")
	public void user_navigates_to_Facebook_homepage() throws Throwable {
		driver.get("https://www.facebook.com");
		PageFactory.initElements(driver, lPage);
	}

	@Given("^user enters the Firstname and Surname$")
	public void user_enters_the_Firstname_and_Surname() throws Throwable {
		lPage.enterFirstName("John");
		lPage.enterSurName("Snow");
	}

	@Given("^keys in valid email address$")
	public void keys_in_valid_email_address() throws Throwable {
		lPage.enterEmail("FirstLast_" + timeStamp + "@gmail.com");
	}

	@Then("^confirm the email address$")
	public void confirm_the_email_address() throws Throwable {
		lPage.confirmEmail(null);
	}

	@Given("^enters a valid password$")
	public void enters_a_valid_password() throws Throwable {
		lPage.enterPassword("Abc@1234");
	}

	@Then("^keys in DOB as \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
	public void keys_in_DOB_as(String date, String month, String year) throws Throwable {
		lPage.selectDay();
		lPage.selectMonth();
		lPage.selectYear();
	}

	@Then("^selects the Sex as \"([^\"]*)\"$")
	public void selects_the_Sex_as(String sex) throws Throwable {
		if (sex.equalsIgnoreCase("Male")) {
			lPage.selectMale();
		} else if (sex.equalsIgnoreCase("FeMale")) {
			lPage.selectFemale();
		} else {
			System.out.println("Code to throw an exception");
		}
	}

	@Then("^clicks on the signup button$")
	public void clicks_on_the_signup_button() throws Throwable {
		lPage.clickSignupBtn();
	}

	/*
	 * @After public void afterMethod() { System.out.println("Test Completed");
	 * driver.quit(); }
	 */

}
