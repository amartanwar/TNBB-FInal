package moduleLevelTestScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import generic.BaseTest;
import pom.AssetListPage;
import pom.AssetMenuPage;
import pom.AssetProfilePage;
import java.util.Map;

public class AssetCreation extends BaseTest
{
	@Test
	public void assetCreation(WebDriver driver, ExtentTest test,Map<String, String> map) throws Exception
	{
		test=reports.createTest("Asset Creation","This test will create the asset for the test data");
		
		AssetMenuPage assetmenupage= new AssetMenuPage(driver,test);
		assetmenupage.clickOnAssetMenu();
		assetmenupage.clickOnAssetProfile();
		
		// Asset List page
		AssetListPage assetlistpage= new AssetListPage(driver, test);
		assetlistpage.clickOnaddButton();
		
		// Asset Profile page
		AssetProfilePage assetprofilepage= new AssetProfilePage(driver, test);
		assetprofilepage.enterAlias(map.get("AssetAlias"));	
		assetprofilepage.enterAcquiredDate(map.get("Acquired Date "));
		assetprofilepage.selectAssetcategory(map.get("Asset category"));
		assetprofilepage.selectAssetType(map.get("Asset Type"));
		assetprofilepage.selectStatus(map.get("Asset Status"));
		
		if((map.get("Asset Status")).equalsIgnoreCase("Investor"))
		{
			assetprofilepage.enterOriginalCost(map.get("Investor Asset Original Cost"));
		}
		assetprofilepage.enterAccountNumber(map.get("Account Number"));
		assetprofilepage.selectpropertyTaxResposibility(map.get("property Tax Resposibility"));
		assetprofilepage.selectFactorCategory(map.get("Factor Category"));
		assetprofilepage.enterLocationCode(map.get("Location Code"));
		assetprofilepage.enterLocationEffectiveDate(map.get("Location Effective Date"));
		assetprofilepage.selectIndustryType(map.get("Industry Type"));
		
		if(map.get("Is Tax Exempt").equalsIgnoreCase("1"))
		{
			//assetprofilepage.clickOnTaxExemptCheckBox();
			assetprofilepage.selectTaxExemptReason();
		}
		
		else
		{	
			Boolean i = driver.findElement(By.id("ctl00_FC_PH_chkTaxExempt")).isSelected();
			int j = i ? 1 : 0;
			
			if(j==1)
			{
			assetprofilepage.clickOnTaxExemptCheckBox();
			}
		}
		
		
		
		
		assetprofilepage.clickOnSave();
		assetprofilepage.verfyTittle("Asset List", "Title is matching");
		test.log(Status.PASS, "Asset create successfully");
	}
}
