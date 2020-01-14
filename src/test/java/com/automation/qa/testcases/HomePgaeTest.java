package com.automation.qa.testcases;


import java.util.ArrayList;
import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.automation.qa.base.TestBase;
import com.automation.qa.pages.HomePage;

public class HomePgaeTest extends TestBase {

	HomePage homepage;

	public HomePgaeTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homepage = new HomePage();
	}

	@Test(priority = 1,groups ={"Smoke","Functional","Regression"})
	public void homePageTittleTest() {

		String ActualTitle = homepage.validatePageTitle();
		Assert.assertEquals(ActualTitle, "Shoe Store: Welcome to the Shoe Store");
		System.out.println("Page Title is - " + ActualTitle);
		Assert.assertEquals(ActualTitle, "Shoe Store: Welcome to the Shoe Store");

	}

	@Test(priority = 2,groups ={"Smoke","Regression"})
	public void verifyValidSubcription() {

		String ConfirmationText = homepage.verifyEmailSubscriptionForNewShoes("tayef111@gmail.com");
		Assert.assertEquals(ConfirmationText,
				"Thanks! We will notify you of our new shoes at this email: tayef111@gmail.com");
		System.out.println(ConfirmationText);

	}

	@Test(priority = 3,groups ={"Smoke","Regression"})
	public void verifyInvalidSubcription() throws InterruptedException {

		String ConfirmationText = homepage.verifyinInvalidEmail("tayef111com");
		if (ConfirmationText.contains("Invalid email format")) {
			Assert.assertEquals(ConfirmationText, "Invalid email format. Ex. name@example.com");
			System.out.println(ConfirmationText);
		} else if (ConfirmationText.contains("Please enter an email address")) {
			Assert.assertEquals(ConfirmationText, "Please enter an email address");
			System.out.println(ConfirmationText);
		} else {

			Assert.fail(ConfirmationText);
			System.out.println(ConfirmationText);
		}

	}

	@Test(priority = 4,groups ={"Smoke","Regression"})
	public void verifyInValidPromocodeMessage() {
		String Message = homepage.verifyInvalidPromoCode("1234abcd");
		if (Message.contains("Invalid")) {
			Assert.assertEquals(Message, "Invalid code format");
			System.out.println(Message);
		} else if (Message.contains("Please enter a promotional code")) {
			Assert.assertEquals(Message, "Please enter a promotional code");
			System.out.println(Message);
		} else {
			System.out.println("Correct Promocode Entererd ");

		}

	}

	@Test(priority=5,groups ={"Smoke","Regression"})
	public void verifyThatUserCanSearchWithSpecificBrandName() throws InterruptedException {
		String Text = homepage.searchByBrand("Acorn");
		System.out.println(Text);
		Assert.assertEquals(Text, "Acorn's Shoes");
	}

	
	@Test(priority=6)
	public void ValidatealltheBrandList(){
		
		homepage.printBrandName();
		//ArrayList<String> expectedresult= new ArrayList<String>();
		//expectedresult.add("Frye");
		//Collections.sort(valuesofthebrand);
		//Collections.sort(expectedresult);
		
	
	}

	
	
	
	@AfterMethod
	public void tearDown() {
		TestBase.quit();
	}

}
