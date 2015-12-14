package org.qe.hawkular.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qe.hawkular.element.hawkularNavigateNetworkTopologyConstants;
import org.openqa.selenium.interactions.Actions;
import org.qe.hawkular.util.HawkularUtils;

/**
 * @author pyadav
 */

public class hawkularNavigateNetworkTopologyPage {
	
public final WebDriver driver;

public hawkularNavigateNetworkTopologyPage(WebDriver driver) {

    this.driver = driver;

}
	
	
	
	By clickTopology = hawkularNavigateNetworkTopologyConstants.clickTopology;
	By imageServers = hawkularNavigateNetworkTopologyConstants.imageServers;
	By imageApps = hawkularNavigateNetworkTopologyConstants.imageApps;
	By imageDatasources = hawkularNavigateNetworkTopologyConstants.imageDatasources;
	By datasourceTopology = hawkularNavigateNetworkTopologyConstants.datasourceTopology;
	By deploymentTopology = hawkularNavigateNetworkTopologyConstants.deploymentTopology;
	By verifyDeployment = hawkularNavigateNetworkTopologyConstants.verifyDeployment;
	
	
	
	public void navigateToTopology() {
        HawkularUtils utils = new HawkularUtils(driver);
        utils.navigateTo(clickTopology);
        utils.waitForElementPresent(imageServers);
        utils.waitForElementPresent(imageApps);
        utils.waitForElementPresent(imageDatasources);
        
        // TO DO Graph navigation test
        
        
        utils.waitForElementPresent(datasourceTopology);
        
    }

	/*
	 * TODO: Resolve issue with doubleclick involving svg elements in topology graphs.
	 */
    public void verifyTopology(){
		
		
		
		HawkularUtils utils = new HawkularUtils(driver);			
		utils.waitForElementPresent(deploymentTopology);		
		WebElement deployment= driver.findElement(deploymentTopology);		
		Actions action = new Actions(driver);	 
		action.doubleClick(deployment);
		
		//action.perform();
		
		
		
		//utils.waitForElementPresent(verifyDeployment);
		
	}
}
