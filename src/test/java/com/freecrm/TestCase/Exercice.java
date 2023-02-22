package com.freecrm.TestCase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercice {

	public static WebDriver driver;

	@BeforeMethod
	public void beforAnyTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.expertunisie.com/");
	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

	@Test(dataProvider = "Mydata")
	public void Verification(String xpath) throws InterruptedException {

		WebElement domaines = driver.findElement(By.cssSelector("li#menu-item-212"));
		Actions action = new Actions(driver);
		action.moveToElement(domaines).build().perform();
		WebElement testlogiciel = driver.findElement(By.cssSelector("li#menu-item-225"));
		action.moveToElement(testlogiciel).click().build().perform();

		try {
			List<WebElement> liste = driver.findElements(By.xpath("//div[@class='how_it_works no_border ']"));
			for (int i = 1; i <= liste.size(); i++) {
				System.out.println("l'element " + i);
				Thread.sleep(2000);
				try {
					List<WebElement> liste2 = driver.findElements(By.xpath("//div[@class='how_it_works no_border ']"));
					liste2.get(i).click();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				WebElement items = driver.findElement(By.xpath(xpath));
				System.out.println(items.isDisplayed());
				driver.navigate().back();
				Thread.sleep(1000);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@DataProvider
	public Object[][] Mydata() {
		Object[][] data = new Object[1][1];
		data[0][0] = "//h2[contains(text(),'Certification')]";
		return data;
	}
}
