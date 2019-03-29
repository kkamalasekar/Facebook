package com.facebook.signup.pages;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class LandingPage {
	
	//WebDriver driver;
	
	@FindBy(how = How.NAME, using = "firstname")
    private WebElement firstNameTxtBox;
	
	@FindBy(name = "lastname")
	private WebElement surNameTxtBox;
	
	@FindBy(name = "reg_email__")
	private WebElement emailTxtBox;

	@FindBy(name = "reg_email_confirmation__")
	private WebElement emailConfirmBox;
	
	@FindBy(name = "reg_passwd__")
	private WebElement passwordTxtBox;
	
	@FindBy(id = "day")
	private WebElement daySelection;
	
	@FindBy(id = "month")
	private WebElement monthSelection;
	
	@FindBy(id = "year")
	private WebElement yearSelection;
	
	@FindBy(xpath = "//input[@name='sex' and @value='1']")
	private WebElement femaleRadioBtn;
	
	@FindBy(xpath = "//input[@name='sex' and @value='2']")
	private WebElement maleRadioBtn;
	
	@FindBy(name = "websubmit")
	private WebElement signupBtn;
	
	Random rn = new Random();
	
	/*public LandingPage(WebDriver driver) {
		super();
		this.driver = driver;
	}*/
	
	public void enterFirstName(String fName) {
		firstNameTxtBox.sendKeys(fName);
	}
	public void enterSurName(String sName) {
		surNameTxtBox.sendKeys(sName);
	}
	public void enterEmail(String eMail) {
		emailTxtBox.sendKeys(eMail);
	}
	public void confirmEmail(String eMail) {
		emailConfirmBox.sendKeys(eMail);
	}
	public void enterPassword(String pass) {
		passwordTxtBox.sendKeys(pass);
	}
	public void selectDay() {
		Select select = new Select(daySelection);
		select.selectByIndex(rn.nextInt(25)+1);
	}
	public void selectMonth() {
		Select select = new Select(monthSelection);
		select.selectByIndex(rn.nextInt(11)+1);
	}
	public void selectYear() {
		Select select = new Select(yearSelection);
		select.selectByValue("1990");;
	}
	public void selectFemale() {
		femaleRadioBtn.click();
	}
	public void selectMale() {
		maleRadioBtn.click();
	}
	public void clickSignupBtn() {
		signupBtn.click();
	}
	

}
