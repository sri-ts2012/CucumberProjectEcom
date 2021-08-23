package com.ecom.automation.pages;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.automation.base.Base;
import com.ecom.automation.framework.Elements;

import cucumber.api.DataTable;

public class RegisterPage {
	
	public RegisterPage()
	{
		PageFactory.initElements(Base.driver,this);
	}
	
	@FindBy(css="input#input-firstname")
	public static WebElement firstName;
	
	
	@FindBy(xpath="//input[contains(@name,'lastname')]")
	public static WebElement lastName;
	
	
	@FindBy(css="input[id$='email']")
	public static WebElement email;
	@FindBy(id="input-telephone")
	public static WebElement telephone;
	
	@FindBy(xpath="//input[starts-with(@name,'pass')]")
	public static WebElement password;
	
	@FindBy(css="input[name='confirm']")
	public static WebElement passwordConfirm;
	
	@FindBy(xpath="//input[contains(@name,'agree')]")
	public static WebElement privacyPolicy;
	
	@FindBy(css="input.btn.btn-primary")
	public static WebElement continueButton;
	
	//css:input.btn.btn-primary or input[type='submit'][value='Continue']
	//xpath://input[starts-with(@value,'Continue')]
	@FindBy(linkText="Register")
	public static WebElement registerbreadcrumb;
	
	@FindBy(css="input[id='input-firstname']+div")//sibling to firstname textbox
	public static WebElement firstNameWarning;
	
	@FindBy(css="input[id='input-lastname']+div")//sibling
	public static WebElement lastNameWarning;
	
	
	@FindBy(css="input[id$='email']+div")
	public static WebElement emailWarning;
	
	@FindBy(css="input[id='input-telephone']+div")
	public static WebElement telephoneWarning;
	
	@FindBy(css="input[id='input-password']+div")
	public static WebElement passwordWarning;
	
	@FindBy(css="div[class$='alert-dismissible']")
	public static WebElement mainWarning;
	
	@FindBy(css="input[name='newsletter'][value='1']")
	public static WebElement subscribeNewsletter;
	
	public static void enterAllDetails(DataTable details, String detailsType)
	{
		Map<String,String> map= details.asMap(String.class, String.class);
		Elements.TypeText(RegisterPage.firstName, map.get("FirstName"));
		//map.get(key) will retireve the value from the register.feature file
		Elements.TypeText(RegisterPage.lastName, map.get("LastName"));
	//	Elements.TypeText(RegisterPage.email,System.currentTimeMillis()+map.get("Email"));
		Elements.TypeText(RegisterPage.telephone, map.get("Telephone"));
		Elements.TypeText(RegisterPage.password,map.get("Password"));
		Elements.TypeText(RegisterPage.passwordConfirm, map.get("Password"));
			if(detailsType.equals("duplicate"))   
			{
				Elements.TypeText(RegisterPage.email,map.get("Email"));
			}
			else
			{
				Elements.TypeText(RegisterPage.email,System.currentTimeMillis()+map.get("Email"));
			}

	}
	
	
	
	/*public static void enterDuplicateDetails(DataTable dupDetails)
	{
		Map<String,String> map= dupDetails.asMap(String.class, String.class);
		Elements.TypeText(RegisterPage.firstName, map.get("FirstName"));
		//map.get(key) will retireve the value from the register.feature file
		Elements.TypeText(RegisterPage.lastName, map.get("LastName"));
		//shd be duplicate email m so remove the timestamp
		Elements.TypeText(RegisterPage.email,map.get("Email"));
		Elements.TypeText(RegisterPage.telephone, map.get("Telephone"));
		Elements.TypeText(RegisterPage.password,map.get("Password"));
		Elements.TypeText(RegisterPage.passwordConfirm, map.get("Password"));
			   
	}*/
	

}
