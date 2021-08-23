package com.ecom.automation.stepdef;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import com.ecom.automation.base.Base;
import com.ecom.automation.config.PropertyFileReader;
import com.ecom.automation.framework.Browser;
import com.ecom.automation.util.PathHelper;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	private static Logger log = Logger.getLogger(Hooks.class);
	
	@Before//belongs to cucumber, ie before very scenario
	public void setUp(Scenario scenario){
	PropertyConfigurator.configure(PathHelper.getResourcePath("/src/main/resources/ConfigurationFile/log4j.properties"));
	log.info("Scenario Started: "+scenario.getName());
	Base.reader=new PropertyFileReader();
	Browser.startBrowser();//doesnt need to return as it can be void method as we are 
	//setting base.driver=newchromedriver
	Browser.maximize();
	}
	@After
	public void closeBrowser(Scenario scenario){
	if(scenario.isFailed()){
	scenario.embed(Browser.takeScreenshot(), "image/png");
	}
	log.info("Scenario Completed: "+scenario.getName());
	log.info("Scenario Status is: "+scenario.getStatus());
	Base.driver.quit();
	}

}
