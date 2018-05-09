package moduleLevelTestScripts;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;

import pom.AssetListPage;
import pom.LeaseInventoryInLeasePage;
import pom.OriginationMenu;
import pom.VendorInvoiceAssets;
import pom.VendorInvoiceEntryHome;
import pom.VendorInvoiceListPage;
import pom.VendorInvoiceOtherCostPage;
import pom.VendorInvoiceProfilePage;
import pom.VendorMenu;

public class VendorInvoiceCreation {

	
	
	
	public void vendorInvoiceScript(WebDriver driver, ExtentTest test, Map<String,String> map) throws InterruptedException
	{
		// Enter Origination Menu
		OriginationMenu originationmenu = new OriginationMenu(driver, test);
		originationmenu.clickoriginationinstallation();

		//VendorInvoice
		VendorMenu vendormenu = new VendorMenu(driver, test);
		vendormenu.clickVendorMenu();
		vendormenu.clickInvoiceManagementLink();
		
		//Vendor Invoice list page
		VendorInvoiceListPage vendornvoicelistpage = new VendorInvoiceListPage(driver, test);
		vendornvoicelistpage.clickAddButton();
		
		// Vendor Invoice profile page
		VendorInvoiceProfilePage vendorinvoiceprofilepage = new VendorInvoiceProfilePage(driver, test);
		vendorinvoiceprofilepage.enterCustomerNumber(map.get("Account Number"));
		vendorinvoiceprofilepage.selectGLTemplate(map.get("GL Template"));
		vendorinvoiceprofilepage.enterVendorNumber(map.get("Vendor"));
		vendorinvoiceprofilepage.entervendorInvoiceNumber(map.get("Vendor Invoice Number"));
		vendorinvoiceprofilepage.enterInvoiceTotal(map.get("Invoice Total"));
		vendorinvoiceprofilepage.enterNumberOfAssets(map.get("Total Number Of Assets"));
		vendorinvoiceprofilepage.enterTotalAquisitionCost(map.get("Total Acquisition Cost"));
		vendorinvoiceprofilepage.clickOnSaveButton();
		
		// Inventory in Lease page
		LeaseInventoryInLeasePage leaseinventoryinleasepage = new LeaseInventoryInLeasePage(driver, test);
		for(int i=1;i<=Integer.parseInt(map.get("Total Number Of Assets"));i++)
		{
			String beforewindow4 = leaseinventoryinleasepage.clickOnImportButton();
			
			AssetListPage assetlistpage= new AssetListPage(driver, test);
			assetlistpage.searchByAlias(map.get("InventoryAlias"+i));
			assetlistpage.clickOnSearchButton();
			assetlistpage.clickOnCurrentAll();
			assetlistpage.clickOnSelectExportButton(beforewindow4);											
			leaseinventoryinleasepage.clickSaveAndContinue();
		}
		
		// Providing Acquisition cost at the asset level
		VendorInvoiceAssets vendorinvoiceassets = new VendorInvoiceAssets(driver, test);
		for(int j=0;j<Integer.parseInt(map.get("Total Number Of Assets"));j++)
			{
				WebElement AcquisitionCost = driver.findElement(By.id("ctl00xFCxPHxgrdProfilexgrdList_rc_"+j+"_7"));
				AcquisitionCost.click();
				WebElement AcquisitionCostClick = driver.findElement(By.id("igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls6"));
				AcquisitionCostClick.clear();
				AcquisitionCostClick.sendKeys(map.get("Amount"+(j+1)));
			}
		vendorinvoiceassets.clickSaveButton();
		
		// Vendor Invoice cost page
		VendorInvoiceOtherCostPage vendorinvoiceothercostPage = new VendorInvoiceOtherCostPage(driver, test);
		vendorinvoiceothercostPage.clickCloseButton();
		
		VendorInvoiceEntryHome vendorinvoiceentryhome = new VendorInvoiceEntryHome(driver, test);
		vendorinvoiceentryhome.changeBookingStatus();
		vendorinvoiceentryhome.clickjustSaveButton();
	}
}
