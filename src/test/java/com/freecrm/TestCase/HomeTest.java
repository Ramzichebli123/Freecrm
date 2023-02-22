package com.freecrm.TestCase;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.BaseTest.Base;
import com.freecrm.PageObject.HomePage;
import com.freecrm.PageObject.LoginPage;

public class HomeTest extends Base {

	public HomeTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	LoginPage loginPage ;
	HomePage homePage ;

	@BeforeMethod
	public void beforAnnyTest() throws IOException {
		setUp();
		loginPage = new LoginPage();
		homePage = loginPage.authentifier();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void addNewContact() {
		homePage.mouveToElement();
		homePage.newContact();
		Assert.assertTrue(homePage.userIsDisplayed());
		System.out.println("l'utilisateur est bien enregistrer");
	}

	@Test
	public void getAlertBox() {
		homePage.clickAlert();
		System.out.println(homePage.textAlert());
		Assert.assertTrue((homePage.textAlert()).contains("Please enter a first name"));
		homePage.checkAlert();
	}

}
