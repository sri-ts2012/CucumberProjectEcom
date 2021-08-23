package com.ecom.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.automation.base.Base;

public class HeadersSection {
	
	public HeadersSection(){
		PageFactory.initElements(Base.driver, this);
	}
	
	@FindBy(xpath="//span[text()=\"My Account\"]")
	//actually xpath code is ://span[text()="My Account"]
	//but double quotes inside is not allowed so put like the above line =\"My Account\"]
	public static WebElement myAccountLink;
	
	@FindBy(css="a[href*=\"register\"]")
	public static WebElement register;

	
	

}
