package org.qe.hawkular.tests;

import org.openqa.selenium.WebDriver;
import org.qe.hawkular.driver.HawkularSeleniumWebDriver;
import org.qe.hawkular.element.HawkularLoginPageConstants;
import org.qe.hawkular.element.HawkularManagementConsolePageConstants;
import org.qe.hawkular.element.HawkularRegistrationPageConstants;
import org.qe.hawkular.page.HawkularLoginPage;
import org.qe.hawkular.page.HawkularRegistrationPage;
import org.qe.hawkular.util.HawkularDataProvider;
import org.qe.hawkular.util.HawkularUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.saucelabs.testng.SauceOnDemandTestListener;

@Listeners({ SauceOnDemandTestListener.class })
public class HawkularRegistrationTest extends HawkularSeleniumWebDriver {

    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularRegistrationBasicTest(String browser, String version,
            String os) throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularRegistrationBasicTest" + os + browser + version);

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        loginPage.navigateToRegistration();

        HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
        regPage.register(HawkularRegistrationPageConstants.generateUsername(),
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.generateEmail(),
                HawkularRegistrationPageConstants.firstName,
                HawkularRegistrationPageConstants.lastName);
        regPage.verifyRegCompleted();
        driver.quit();
    }
    
    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularRegistrationMismatchPasswordsTest(String browser, String version,
            String os) throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularRegistrationMismatchPasswordsTest" + os + browser + version);

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        loginPage.navigateToRegistration();

        HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
        regPage.register(HawkularRegistrationPageConstants.generateUsername(),
                HawkularRegistrationPageConstants.wrongPassword,
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.generateEmail(),
                HawkularRegistrationPageConstants.firstName,
                HawkularRegistrationPageConstants.lastName);
        regPage.verifyMismatchPasswords();
        driver.quit();
    }
    
    
    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularRegistrationNoPasswordsTest(String browser, String version,
            String os) throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularRegistrationNoPasswordsTest" + os + browser + version);

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        loginPage.navigateToRegistration();

        HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
        regPage.register(HawkularRegistrationPageConstants.generateUsername(),
                "",
                "",
                HawkularRegistrationPageConstants.generateEmail(),
                HawkularRegistrationPageConstants.firstName,
                HawkularRegistrationPageConstants.lastName);
        regPage.verifyNoPasswords();
        driver.quit();
    }
    
    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularRegistrationNoEmailTest(String browser, String version,
            String os) throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularRegistrationNoEmailTest" + os + browser + version);

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        loginPage.navigateToRegistration();

        HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
        regPage.register(HawkularRegistrationPageConstants.generateUsername(),
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.password,
                "",
                HawkularRegistrationPageConstants.firstName,
                HawkularRegistrationPageConstants.lastName);
        regPage.verifyNoEmail();
        driver.quit();
    }
    
    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularRegistrationNoFirstNameTest(String browser, String version,
            String os) throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularRegistrationNoFirstNameTest" + os + browser + version);

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        loginPage.navigateToRegistration();

        HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
        regPage.register(HawkularRegistrationPageConstants.generateUsername(),
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.email,
                "",
                HawkularRegistrationPageConstants.lastName);
        regPage.verifyNoFirstName();
        driver.quit();
    }

    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularRegistrationNoLastNameTest(String browser, String version,
            String os) throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularRegistrationNoLastNameTest" + os + browser + version);

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        loginPage.navigateToRegistration();

        HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
        regPage.register(HawkularRegistrationPageConstants.generateUsername(),
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.email,
                HawkularRegistrationPageConstants.firstName,
                "");
        regPage.verifyNoLastName();
        driver.quit();
    }
    
    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularRegistrationNoUserNameTest(String browser, String version,
            String os) throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularRegistrationNoUserNameTest" + os + browser + version);

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        loginPage.navigateToRegistration();

        HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
        regPage.register("",
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.password,
                HawkularRegistrationPageConstants.email,
                HawkularRegistrationPageConstants.firstName,
                HawkularRegistrationPageConstants.lastName);
        regPage.verifyNoUsername();
        driver.quit();
    }
    
    @Test(dataProvider = "browsersAndOs", dataProviderClass = HawkularDataProvider.class)
    public void hawkularRegistrationPasswordMinLengthTest(String browser, String version,
            String os) throws Exception {
        WebDriver driver = createDriver(browser, version, os,
                "hawkularRegistrationPasswordMinLengthTest" + os + browser + version);

        driver.get(HawkularSeleniumWebDriver.hawkularUrl);
        System.out.println(driver.getTitle());

        HawkularLoginPage loginPage = new HawkularLoginPage(driver);
        loginPage.navigateToRegistration();

        HawkularRegistrationPage regPage = new HawkularRegistrationPage(driver);
        regPage.register(HawkularRegistrationPageConstants.generateUsername(),
                HawkularRegistrationPageConstants.wrongPassword,
                HawkularRegistrationPageConstants.wrongPassword,
                HawkularRegistrationPageConstants.email,
                HawkularRegistrationPageConstants.firstName,
                HawkularRegistrationPageConstants.lastName);
        regPage.verifyPasswordMinLength();
        driver.quit();
    }
    

}
