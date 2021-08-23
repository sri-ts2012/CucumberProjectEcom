package com.ecom.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.automation.base.Base;

public class SuccessPage {
	
	public SuccessPage()
	{
		PageFactory.initElements(Base.driver,this);
	}
	
	@FindBy(linkText="Success")
	public static WebElement successBreadCrumb;

}
