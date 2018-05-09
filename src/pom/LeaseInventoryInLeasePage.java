package pom;

import org.openqa.selenium.By;
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

public class LeaseInventoryInLeasePage extends BasePage  
{
	@FindBy(id="ctl00_FC_PH_cmdImport_cmdImportButton")
	private WebElement importButton;

	@FindBy(xpath="//*[@id=\'ctl00xFCxPHxgrdProfilexgrdList_rc_0_0\']/nobr/input")
	private WebElement selectCheckBox;

	@FindBy(xpath="//*[@id=\'ctl00xFCxPHxgrdProfilexgrdList_rc_0_2\']/nobr/input")
	private WebElement primaryAsset;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement PageSaveButton;
	
	@FindBy(css = "#ctl00xFCxPHxgrdProfilexgrdList_rc_0_1 > nobr")
	private WebElement assetID;
	
	@FindBy(id="ctl00_FT_PH_cmdSaveContinue_cmdButtonControl")
	private WebElement saveAndContinue;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_AssignmentListControl_fields")
	private WebElement assignmentControlDropDown;
	
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_txtCurrency_ALB15rRrrRr0rRr0rRr3")
	private WebElement enterValue;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_ALB_InvoiceGroup1_txtInvoiceGroupID")
	private WebElement enterInvoiceGroup;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_AssignmentListControl_entryButtons")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_cmdAssign_cmdButtonControl")
	private WebElement assignButton;
	
	
	@FindBy(id="igtxtctl00_FC_PH_grdProfile_grdProfileLWGridEditor_Controls46")
	private WebElement residualBookedAmountClick;
	
	@FindBy(id="ctl00_FC_PH_grdProfile_lnkAllCP")
	private WebElement selectAllButton;
	
	

	public LeaseInventoryInLeasePage(WebDriver driver, ExtentTest test) 
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public String clickOnImportButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.visibilityOf(importButton));
		String currentWindow = driver.getWindowHandle();
		importButton.click();
		SwitchControlToNextWindow sc= new SwitchControlToNextWindow();
		sc.waitForWndows(driver, currentWindow); //Control is being changed to new window
		return currentWindow;
	}
	
	public void clickOnPageSaveButton() throws InterruptedException
	{
		WebDriverWait wt= new WebDriverWait(driver, 300);
		wt.until(ExpectedConditions.titleIs("Assets In Lease"));
		PageSaveButton.click();
	}
	public void selectAsset()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(selectCheckBox));
		selectCheckBox.click();
	}
	
	public void selectPrimaryAsset()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(primaryAsset));
		primaryAsset.click();
	}
	
	public String getAssetID()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(assetID));
		String InventoryID = assetID.getText();
		return InventoryID;
			
	}
	
	public void clickSaveAndContinue()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(saveAndContinue));
		saveAndContinue.click();
	}
	
	public void selectResidualBookedAmount() 
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(assignmentControlDropDown));
		Select select = new Select(assignmentControlDropDown);
		select.selectByIndex(1);
	}
	
	public void selectOTPDepreciationAmount() 
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(assignmentControlDropDown));
		Select select = new Select(assignmentControlDropDown);
		select.selectByIndex(1);
	}
	
	public void selectInvoiceGroup() 
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(assignmentControlDropDown));
		Select select = new Select(assignmentControlDropDown);
		select.selectByIndex(2);
	}
	
	
	public void enterValue(String value) 
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(enterValue));
		enterValue.clear();
		enterValue.sendKeys(value);
		
	}
	
	
	public void enterInvoiceGroupValue(String IGvalue) 
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(enterInvoiceGroup));
		enterInvoiceGroup.sendKeys(IGvalue);
		
	}
	
	public void clickOnAddButton() 
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(addButton));
		addButton.click();
		
	}
	
	public void clickOnAssignButton() 
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(assignButton));
		assignButton.click();
		
	}
	
	public void clickOnSelectAllButton() 
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(selectAllButton));
		selectAllButton.click();
		
	}

	
	public void enterResidualBookedAmount(String residualbookedamount, String inventoryAlias )
	{
		WebElement ResidualBookedAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[43]"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(ResidualBookedAmount));
		ResidualBookedAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(residualBookedAmountClick));
		residualBookedAmountClick.clear();
		residualBookedAmountClick.sendKeys(residualbookedamount);
	}
	

	
	public void enterResidualBookedAmountForSalvage(String residualbookedamount, String inventoryAlias )
	{
		WebElement ResidualBookedAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[48]"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(ResidualBookedAmount));
		ResidualBookedAmount.click();
		wait.until(ExpectedConditions.elementToBeClickable(residualBookedAmountClick));
		residualBookedAmountClick.clear();
		residualBookedAmountClick.sendKeys(residualbookedamount);
	}

	
	public void checkPrimaryAsset(String inventoryAlias )
	{
		WebElement PrimaryAssetCheckBox = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[3]"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(PrimaryAssetCheckBox));
		PrimaryAssetCheckBox.click();

	}
	
	
	
}
