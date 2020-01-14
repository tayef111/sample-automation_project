package com.automation.qa.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automation.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page Factory -OR

	@FindBy(xpath = "//h2[contains(text(),'Welcome to Shoe Store!')]")
	WebElement Homepagetext;

	@FindBy(xpath = "//input[@id='remind_email_input']")
	WebElement Emailinputfield;

	@FindBy(xpath = "//input[@id='remind_email_submit']")
	WebElement RemaidEmailSumbit;

	@FindBy(xpath = "//div[@class='flash flash_success']")
	WebElement SuccessfullText;

	@FindBy(xpath = "//div[@class='flash alert_danger']")
	WebElement InvalidText;

	// div[@class='flash flash_success']

	@FindBy(xpath = "//input[@id='promo_code_input']")
	WebElement PromoCodeInput;

	@FindBy(xpath = "//input[@id='promo_code_submit']")
	WebElement PronoCodeSumbit;

	@FindBy(xpath = "//input[@id='promo_code_submit']")
	WebElement ResultText;

	@FindBy(xpath = "//select[@id='brand']")
	public WebElement brand_dropdown;

	@FindBy(xpath = "//input[@id='search_button']")
	WebElement submitButton;

	@FindBy(xpath = "//div//h2[contains(text(),'Acorn's Shoes')]")
	WebElement ShoesName;

	private Object nameoftheBrand;

	// h2[contains(text(),"ASICS®'s Shoes")]

	public HomePage() {

		PageFactory.initElements(driver, this);
	}

	public String validatePageTitle() {
		return driver.getTitle();

	}

	public String verifyEmailSubscriptionForNewShoes(String Email) {

		Emailinputfield.clear();
		Emailinputfield.sendKeys(Email);
		RemaidEmailSumbit.click();
		String successfullText = SuccessfullText.getText();
		return successfullText;

	}

	public String verifyinInvalidEmail(String Email) throws InterruptedException {

		Emailinputfield.clear();
		Emailinputfield.sendKeys(Email);
		RemaidEmailSumbit.click();
		Thread.sleep(3000);
		String Text = InvalidText.getText();
		return Text;

	}
	// Can't create Test case because Promocode functionality doesn't work

	public String verifyValidPromoCode(String Promocode) {

		PromoCodeInput.clear();
		PromoCodeInput.sendKeys(Promocode);
		PronoCodeSumbit.click();
		String successfullText = ResultText.getText();
		return successfullText;

	}

	public String verifyInvalidPromoCode(String Promocode) {

		PromoCodeInput.clear();
		PromoCodeInput.sendKeys(Promocode);
		PronoCodeSumbit.click();
		String ResultText = InvalidText.getText();
		return ResultText;

	}

	public String searchByBrand(String brand) throws InterruptedException {
		Select statusDropdown = new Select(brand_dropdown);
		statusDropdown.selectByVisibleText(brand);
		submitButton.click();
		String Name = ShoesName.getText();
		return Name;
	}

	public void printBrandName(){
		
		
		//ArrayList<String> l= new ArrayList<String>();
		
		Select statusDropdown = new Select(brand_dropdown);
		List<WebElement>list=statusDropdown.getOptions();
		for(WebElement totallist: list){
			
			
			System.out.println(totallist.getText());
			//l.add(totallist.getText());
		}
		
	}
	
	
	}

