package moduleLevelTestScripts;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import generic.BaseTest;
import pom.AssetLocationSetupListPage;
import pom.AssetLocationSetupPage;
import pom.AssetMenuPage;
import pom.CollectionGroupListPage;
import pom.CollectionGroupSetupPage;
import pom.ContactAddressListPage;
import pom.ContactAddressSetupPage;
import pom.ContactPersonListPage;
import pom.ContactPersonSetupPage;
import pom.CustomerListPage;
import pom.CustomerMenuPage;
import pom.CustomerProfilePage;
import pom.InvoiceGroupListPage;
import pom.InvoiceGroupSetupPage;
import pom.TaxAreaIDListPage;

public class CustomerCreation extends BaseTest
{
	@Test
	public void customercreation(WebDriver driver, ExtentTest test,Map<String, String> map) throws Exception
	{
		test=reports.createTest("Customer Creation","This test will create the customer for the test data");
		
		/*PortFolioManagementMenu portfoliomanagementmenu = new PortFolioManagementMenu(driver, test);
		portfoliomanagementmenu.clickPortFolioManagement();*/
		
		CustomerMenuPage customermenupage= new CustomerMenuPage(driver,test);
		customermenupage.openCustomerProfile();
		
		// Customer List page
		CustomerListPage customerlistpage= new CustomerListPage(driver, test);
		customerlistpage.clickOnAddButton();
		// Customer Profile page
		CustomerProfilePage customerprofilepage = new CustomerProfilePage(driver, test);
		customerprofilepage.enterAccountNumber(map.get("Account Number"));
		System.out.println(map.get("NAICS Code"));
		customerprofilepage.selectNAICSCode();
		
		if(Integer.parseInt(map.get("Is Individual"))==0)
		{
			customerprofilepage.enterCompanyName(map.get("Company Name"));
			customerprofilepage.selectOwnerShipPattern(map.get("OwnerShip Pattern"));
		}
		else
		{
			customerprofilepage.checkIndividualCheckBox();
			customerprofilepage.enterFirstName(map.get("First Name"));
			customerprofilepage.enterLastName(map.get("Last Name"));
			customerprofilepage.enterDateOfBirth(map.get("Date of Birth"));
		}
		
		customerprofilepage.enterTaxID(map.get("Tax Id"));
		
		customerprofilepage.selectOriginationChannel(map.get("Origination Channel"));
		
		customerprofilepage.enterSocialSecurityNumber(map.get("Social Security Number"));
		customerprofilepage.selectCIPDocumentSource(map.get("CIP Document Source"));
		customerprofilepage.selectStatus(map.get("Status"));
		customerprofilepage.selectSICCode(map.get("SIC Code"));
		String customerprofilewindow = customerprofilepage.clickOnFirstNameImportButton();
		
		
		ContactPersonListPage contactpersonlistpage = new ContactPersonListPage(driver, test);
		contactpersonlistpage.clickOnAddButon();
		
		ContactPersonSetupPage contactpersonsetuppage= new ContactPersonSetupPage(driver, test);
		contactpersonsetuppage.enterLastName(map.get("Contact Person Last Name"));
		contactpersonsetuppage.enterFirstName(map.get("Contact Person First Name"));
		contactpersonsetuppage.enteremailID(map.get("Contact Person Email Id"));
		String contactpersonsetupWindow = contactpersonsetuppage.clickOnAddressImportButton(customerprofilewindow);
		
		ContactAddressListPage contactaddresslistpage = new ContactAddressListPage(driver, test);
		contactaddresslistpage.clickOnAddButton();
		
		ContactAddressSetupPage ContactAddressSetupPage = new ContactAddressSetupPage(driver,test);
		ContactAddressSetupPage.enterAddress(map.get("Contact Person Address"));
		ContactAddressSetupPage.enterCity(map.get("Contact Person City"));
		ContactAddressSetupPage.enterState(map.get("Contact Person State"));
		ContactAddressSetupPage.enterPostalCode(map.get("Contact Person Postal Code"));
		ContactAddressSetupPage.clickOnSaveAndSelectButton(contactpersonsetupWindow);
		test.log(Status.PASS, "Address setup successfully");
		
		contactpersonsetuppage.clickOnContactTypes();
		contactpersonsetuppage.clickOnSaveAndSelect(customerprofilewindow);

		test.log(Status.PASS, "Contact person setup successfully");
		Thread.sleep(1000);
		customerprofilepage.clickOnSaveButton();
		customerprofilepage.handleAlert();
		customerprofilepage.verfyTittle("Customer List", "Title is Matching");
		test.log(Status.PASS, "Customer created successfully and Customer Account Number - "+map.get("Account Number"));
		
		
		//Creating Collection Group
		customermenupage.openCollectionGroupSetup();
	//	customerlistpage.enterAccountNumber(map.get("Account Number"));
	//	customerlistpage.clickOnsearchButton();
		customerlistpage.clickOnSelectButton();
		
		CollectionGroupListPage collectiongrouplistpage = new CollectionGroupListPage(driver, test);
		collectiongrouplistpage.clickOnAddButton();
		
		CollectionGroupSetupPage collectiongroupsetuppage = new CollectionGroupSetupPage(driver, test);
		collectiongroupsetuppage.enterCollectionGroupName(map.get("Collection Group Name"));
		collectiongroupsetuppage.clickDefault();
		String CollectionGroupSetupWindow =  collectiongroupsetuppage.clickOnContactPersonAddButton();
		
		contactpersonlistpage.clickOnSelectButton(CollectionGroupSetupWindow);
		collectiongroupsetuppage.clickOnContactPersonSaveButton();
		collectiongroupsetuppage.clickOnSaveButton();
		
		
		test.log(Status.PASS, "Collection Group setup successfully");
		
		// Creating Invoice Group
		customermenupage.openInvoiceGroupSetup();
	//	customerlistpage.enterAccountNumber(map.get("Account Number"));
   //	customerlistpage.clickOnsearchButton();
		customerlistpage.clickOnSelectButton();
		
		InvoiceGroupListPage invoicegrouplistpage = new InvoiceGroupListPage(driver, test);
		invoicegrouplistpage.clickOnAddButton();
		
		InvoiceGroupSetupPage invoicegroupsetuppage = new InvoiceGroupSetupPage(driver, test);
		invoicegroupsetuppage.enterInvoiceGroupName(map.get("Invoice Group Name"));
		invoicegroupsetuppage.clickPrimaryGroup();
		invoicegroupsetuppage.selectDueDay(map.get("Invoice Due Day"));
		invoicegroupsetuppage.enterCollectionGroupName(map.get("Collection Group Name"));
		String invoicegroupsetupwindow =  invoicegroupsetuppage.clickOnFirstNameImportButton();
	
		contactpersonlistpage.clickOnSelectButton(invoicegroupsetupwindow);
		invoicegroupsetuppage.clickOnSaveButton();
		invoicegrouplistpage.clickOnCloseButton();
		test.log(Status.PASS, "Invoice Group setup successfully");
		
		for(int i=1;i<=Integer.parseInt(map.get("Count of Location Codes"));i++)
		{
			AssetMenuPage assetmenupage = new AssetMenuPage(driver, test);
			assetmenupage.openAssetLocationSetup();
			AssetLocationSetupListPage assetlocationsetuplistpage = new AssetLocationSetupListPage(driver, test);
			assetlocationsetuplistpage.clickOnAddButton();
			
			AssetLocationSetupPage assetlocationsetuppage = new AssetLocationSetupPage(driver, test);
			assetlocationsetuppage.selectEntityType(map.get("Entity Type"+i));
			assetlocationsetuppage.enterEntityUniqueID(map.get("Account Number"));
			assetlocationsetuppage.enterLocationCode(map.get("Asset Location Code"+i));
			assetlocationsetuppage.enterAddress(map.get("Asset Address"+i));
			assetlocationsetuppage.enterCity(map.get("Asset city"+i));
			assetlocationsetuppage.selectSatate(map.get("Asset State"+i));
			assetlocationsetuppage.enterCounty(map.get("Asset County"+i));
			assetlocationsetuppage.enterPostalCode(map.get("Asset Postal Code"+i));
			assetlocationsetuppage.clickOnDefaultButton();
			String assetlocationsetupwindow = assetlocationsetuppage.clickOnTaxAreaIDImportButton();
			
			TaxAreaIDListPage taxareaidlistpage = new TaxAreaIDListPage(driver, test);
			taxareaidlistpage.clickOnSelectButton(assetlocationsetupwindow);
			assetlocationsetuppage.enterTaxAreaLocationEffectiveDate(map.get("Location Effective Date"+i));
			assetlocationsetuppage.clickOnSaveButton();
			assetlocationsetuppage.handleAlert();
			
			assetlocationsetuplistpage.clickOnCloseButton();
			//assetlocationsetuppage.verfyTittle("Asset Location Setup Listt", "Title is Matching");
		}
		
		test.log(Status.PASS, "Asset Location setup successfully");

	}

}
