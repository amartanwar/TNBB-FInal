package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;
import generic.SwitchControlToNextWindow;

public class AssetLocationAndInvoiceGroupMappingPage extends BasePage {

	public AssetLocationAndInvoiceGroupMappingPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="ctl00_FC_PH_cmdCloneLocation_cmdButtonControl")
	private WebElement cloneLocation;
	
	@FindBy(id="ctl00_FC_PH_grdAssetLocationIG_AssignmentListControl_fields")
	private WebElement assignmentSelectDropDown;
	
	@FindBy(id="ctl00_FC_PH_grdAssetLocationIG_LocationTemplateUC1_cmdImportLocationCode_cmdImportButton")
	private WebElement locationImportButton;
	
	@FindBy(id="ctl00_FC_PH_grdAssetLocationIG_InvoiceGroupUC0_cmdImportInvoiceGroup_cmdImportButton")
	private WebElement invoiceGroupImportButton;
	
	@FindBy(id="ctl00_FC_PH_grdAssetLocationIG_AssignmentListControl_entryButtons")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FC_PH_grdAssetLocationIG_lnkAllCP")
	private WebElement selectAllButton;
	
	@FindBy(id="ctl00_FC_PH_grdAssetLocationIG_cmdAssign_cmdButtonControl")
	private WebElement assignButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	
	public void clickOnSaveButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	
	public void selectNewInvoiceGroup() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(assignmentSelectDropDown));
		Select se = new Select(assignmentSelectDropDown);
		se.selectByIndex(1);
		
	}
	
	public void selectNewLocation() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(assignmentSelectDropDown));
		Select se = new Select(assignmentSelectDropDown);
		se.selectByIndex(2);
		
	}
	
	public String importNewInvoiceGroup() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(invoiceGroupImportButton));
		
		String IcurrentWindow = driver.getWindowHandle();
		invoiceGroupImportButton.click();
		SwitchControlToNextWindow sc = new SwitchControlToNextWindow();
		sc.waitForWndows(driver, IcurrentWindow);
		return IcurrentWindow;
	}
	
	
	public String importNewLocation() throws InterruptedException 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(locationImportButton));
		
		String lcurrentWindow = driver.getWindowHandle();
		locationImportButton.click();
		SwitchControlToNextWindow sc = new SwitchControlToNextWindow();
		sc.waitForWndows(driver, lcurrentWindow);
		return lcurrentWindow;
	}

	
	public void clickOnAddButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	public void clickOnAssignButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(assignButton));
		assignButton.click();
	}
	
	public void clickOnSelectAllButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(selectAllButton));
		selectAllButton.click();
	}
	
	public void clickOnCloneLocation() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(cloneLocation));
		cloneLocation.click();
	}
	
}
