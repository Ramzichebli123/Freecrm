package com.freecrm.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.freecrm.BaseTest.Base;
import com.freecrm.PageObject.HomePage;
import com.freecrm.PageObject.LoginPage;

public class LoginTest extends Base {
	public LoginTest() throws IOException {
		super();
	}

	LoginPage loginPage;
	HomePage homePage;

	@BeforeMethod
	public void beforeAnnyTest() throws IOException {
		setUp();
		loginPage = new LoginPage();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void url() {
		Assert.assertEquals(prop.getProperty("URL"), loginPage.getURL(), "la page n'est pas affiché");
		System.out.println("nous sommes bien dans la page login");
	}

	@Test(priority = 2)
	public void Image() {
		Assert.assertTrue(loginPage.image());
		System.out.println("l'image est affiché dans la page login");
	}

	@Test(priority = 3)
	public void LogIn() throws IOException {
		try {
			homePage = loginPage.authentifier();
			Assert.assertNotEquals(prop.getProperty("URL"), loginPage.getURL(),
					"merci de verifier votre mail ou mot de passe");
			System.out.println("Vous étiez bien connectés");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
