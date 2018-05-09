package test;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetValueAndStatusChangePage;


public class AssetValueNonZeroChange extends BaseTest {
	
	@Test
	public void assetValueChange() throws InterruptedException
	{
		test=reports.createTest("assetValueChange","Creating Asset Value change entry");
		AssetMenuPage assetmenupage = new AssetMenuPage(driver, test);
		
		assetmenupage.clickOnAssetMenu();
		assetmenupage.clickOnvalueAndStatusChanges();
		
		assetmenupage.clickOnNonZero();
		
		AssetListPage assetlistpage = new AssetListPage(driver, test);
		
		assetlistpage.searchByAlias("alias-1");
		
		assetlistpage.clickOnSearchButton();
		
	    assetlistpage.selectGridCheckBox();
		
		assetlistpage.clickONSelectButton();
		
		AssetValueAndStatusChangePage assetvalueandstatuschangepage = new AssetValueAndStatusChangePage(driver, test);
		
		assetvalueandstatuschangepage.selectGLTemplate();
		
		assetvalueandstatuschangepage.selectGridCheckBox();
		
		assetvalueandstatuschangepage.selectAssignmentOperator();
		
		assetvalueandstatuschangepage.enterCostOfAsset("2000");
		
		assetvalueandstatuschangepage.clickOnAddButton();
		
		assetvalueandstatuschangepage.clickOnAssignmentButton();
		
		assetvalueandstatuschangepage.clickOnSaveButton();
		
		assetvalueandstatuschangepage.handlePopup();

		
	}

}
