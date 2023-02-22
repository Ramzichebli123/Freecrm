package com.freecrm.PageObject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.freecrm.BaseTest.Base;

public class LoginPage extends Base {
	
	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@src='https://classic.freecrm.com/img/logo@2x.png']")
	WebElement image ;
	@FindBy(name="username")
	private WebElement mail ;
	
	@FindBy(name="password")
	private WebElement password ;
	
	@FindBy(css="input[value='Login']")
	private WebElement submit ;
	 
	/**
	 * @return the image
	 */
	public WebElement getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(WebElement image) {
		this.image = image;
	}

	/**
	 * @return the mail
	 */
	public WebElement getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(WebElement mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public WebElement getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(WebElement password) {
		this.password = password;
	}

	/**
	 * @return the submit
	 */
	public WebElement getSubmit() {
		return submit;
	}

	/**
	 * @param submit the submit to set
	 */
	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}

	public boolean image() {
		return (getImage().isDisplayed());
		
	}
	public String getURL() {
		String URL = driver.getCurrentUrl();
		return URL;
	}
	public HomePage authentifier() throws IOException {
		getMail().sendKeys(prop.getProperty("User"));
		getPassword().sendKeys(prop.getProperty("Pwd"));
		getSubmit().click();
		return new HomePage();
	}
	
	
	

}
