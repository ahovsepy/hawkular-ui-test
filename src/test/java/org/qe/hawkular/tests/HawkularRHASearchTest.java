package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumLocalWebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.*;
import org.qe.hawkular.page.*;
import org.testng.annotations.Test;

public class HawkularRHASearchTest extends HawkularSeleniumLocalWebDriver {

	public WebDriver hawkularLogin() throws Exception {
		WebDriver driver = createLocalDriver();

		driver.get(HawkularSeleniumWebDriver.hawkularUrl);
		System.out.println(driver.getTitle());

		HawkularLoginPage loginPage = new HawkularLoginPage(driver);

		loginPage.verifyLoginTitle();

		loginPage = new HawkularLoginPage(driver);
		loginPage.loginAs(HawkularRegistrationPageConstants.username2,
				HawkularRegistrationPageConstants.password2);

		return driver;
	}

	@Test
	public void hawkularSearchKnowledgeBaseTest() throws Exception {
		WebDriver driver = hawkularLogin();
		HawkularAppServerPage appServer = new HawkularAppServerPage(driver);

		appServer.navigateToRHATab();
		appServer.navigateToRHASearchTab();

		HawkularRedHatAccessPage rha = new HawkularRedHatAccessPage(driver);
		rha.switchFrameFocus();
		rha.loginHere();
		rha.switchFrameFocus(true);
		HawkularRHASearchPage rhaSearch = new HawkularRHASearchPage(driver);
		rhaSearch.switchFrameFocus();
		rhaSearch.search("asd");
		
		rha.logoutHere();
		driver.close();
	}

}
