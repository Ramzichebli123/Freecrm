package com.freecrm.PageObject;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.freecrm.BaseTest.Base;

public class HomePage extends Base {
	
	
public HomePage() throws IOException{
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//a[@title='Contacts']")
private WebElement contact;

@FindBy(xpath="//a[contains(text(),'New Contact')]")
private WebElement newcontact;

@FindBy(xpath="//select[@name='title']")
private WebElement titre;

@FindBy(name="first_name")
private WebElement name;

@FindBy(name="surname")
private WebElement lastname;

@FindBy(name="client_lookup")
private WebElement company;

@FindBy(name="department")
private WebElement departement;

@FindBy(xpath="//input[@value='Save']")
private WebElement save;

@FindBy(xpath="(//td[@class='tabs_header'])[1]")
private WebElement user;

/**
 * @return the user
 */
public WebElement getUser() {
	return user;
}

/**
 * @param user the user to set
 */
public void setUser(WebElement user) {
	this.user = user;
}

/**
 * @return the titre
 */
public WebElement getTitre() {
	return titre;
}

/**
 * @param titre the titre to set
 */
public void setTitre(WebElement titre) {
	this.titre = titre;
}

/**
 * @return the contact
 */
public WebElement getContact() {
	return contact;
}

/**
 * @param contact the contact to set
 */
public void setContact(WebElement contact) {
	this.contact = contact;
}

/**
 * @return the newcontact
 */
public WebElement getNewcontact() {
	return newcontact;
}

/**
 * @param newcontact the newcontact to set
 */
public void setNewcontact(WebElement newcontact) {
	this.newcontact = newcontact;
}

/**
 * @return the name
 */
public WebElement getName() {
	return name;
}

/**
 * @param name the name to set
 */
public void setName(WebElement name) {
	this.name = name;
}

/**
 * @return the lastname
 */
public WebElement getLastname() {
	return lastname;
}

/**
 * @param lastname the lastname to set
 */
public void setLastname(WebElement lastname) {
	this.lastname = lastname;
}

/**
 * @return the company
 */
public WebElement getCompany() {
	return company;
}

/**
 * @param company the company to set
 */
public void setCompany(WebElement company) {
	this.company = company;
}

/**
 * @return the departement
 */
public WebElement getDepartement() {
	return departement;
}

/**
 * @param departement the departement to set
 */
public void setDepartement(WebElement departement) {
	this.departement = departement;
}

/**
 * @return the save
 */
public WebElement getSave() {
	return save;
}

/**
 * @param save the save to set
 */
public void setSave(WebElement save) {
	this.save = save;
}

public void mouveToElement() {
	driver.switchTo().frame("mainpanel");
	Actions act = new Actions(driver);
	act.moveToElement(getContact()).build().perform();
	act.moveToElement(getNewcontact()).click().build().perform();
}
public void newContact() {
	Select select = new Select(getTitre());
	select.selectByIndex(3);
	getName().sendKeys("Ramzi");
	getLastname().sendKeys("CHEBLI");
	getCompany().sendKeys("Improve Software");
	getDepartement().sendKeys("QA");
	getSave().click();
}
public boolean userIsDisplayed() {
	return getUser().isDisplayed();
}

public void clickAlert() {
	mouveToElement();
	getSave().click();
}
public String textAlert() {
	return (driver.switchTo().alert().getText());
}
public void checkAlert() {
	driver.switchTo().alert().accept();
}



}
