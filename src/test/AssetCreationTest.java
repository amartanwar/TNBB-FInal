package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import generic.BaseTest;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetProfilePage;
import java.util.Map;

public class AssetCreationTest extends BaseTest
{
	@Test
	public void assetCreation(WebDriver driver, ExtentTest test,Map<String, String> map) throws Exception
	{
		test=reports.createTest("assetCreation","This test will create the asset for test data");
		AssetMenuPage assetmenupage= new AssetMenuPage(driver,test);
		assetmenupage.clickOnAssetMenu();
		assetmenupage.clickOnAssetProfile();
		
		AssetListPage assetlistpage= new AssetListPage(driver, test);
		assetlistpage.clickOnaddButton();
		
		AssetProfilePage assetprofilepage= new AssetProfilePage(driver, test);
		assetprofilepage.enterAlias(map.get("AssetAlias"));
		
		assetprofilepage.enterAcquiredDate(map.get("Acquired Date "));

		assetprofilepage.selectAssetcategory(map.get("Asset category"));
		assetprofilepage.selectAssetType(map.get("Asset Type"));
		
		assetprofilepage.enterAccountNumber(map.get("Account Number"));
		
		assetprofilepage.selectpropertyTaxResposibility(map.get("property Tax Resposibility"));
		assetprofilepage.selectFactorCategory(map.get("Factor Category"));
		
		assetprofilepage.enterLocationCode(map.get("Location Code"));
		
		assetprofilepage.enterLocationEffectiveDate(map.get("Location Effective Date"));
		
		assetprofilepage.selectIndustryType(map.get("Industry Type"));
		
		assetprofilepage.clickOnSave();
		
		assetprofilepage.verfyTittle("Asset List", "Title is matching");
		test.log(Status.PASS, "asset create successfully");
	}

	
	
}
