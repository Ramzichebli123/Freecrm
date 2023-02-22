package com.freecrm.BaseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public Base() throws IOException {
		prop = new Properties();
		FileInputStream file = new FileInputStream("D:\\eclipse workspace\\Freecrm\\src\\test\\java\\com\\freecrm\\Configuration\\config.properties");
		prop.load(file);
	}
	
	
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
	}

}
