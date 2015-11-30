package org.qe.hawkular.util;

import org.apache.regexp.recompile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.testng.Assert;

/**
 * Utility class for methods: to navigate to a location or wait for if element is present or not.
 *
 */

public class HawkularUtils {

	WebDriver driver;

	public HawkularUtils(WebDriver driver) {
		this.driver = driver;
	}

	public boolean assertTitle(String title) {
		return driver.getTitle().equals(title);
	}

	public void navigateTo(By navigationLink) {
		waitForElementPresent(navigationLink);
		driver.findElement(navigationLink).click();
	}
	
	public void sendKeysTo(By navigationLink, CharSequence ... cs) {
		waitForElementPresent(navigationLink);
		driver.findElement(navigationLink).sendKeys(cs);
	}

	public boolean waitForElementPresent(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
		return driver.findElement(element).isDisplayed();
	}

	public void waitForElementNotPresent(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
	}
	
	public void assertElementPresent(By element) {
		Assert.assertTrue(waitForElementPresent(element));
	}

}
