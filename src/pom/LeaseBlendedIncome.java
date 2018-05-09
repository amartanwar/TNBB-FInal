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

public class LeaseBlendedIncome extends BasePage
{
				
	@FindBy(id="ctl00_FT_PH_cmdLeaseClose_cmdButtonControl")
	private WebElement closeButton;
	
	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement frontEndCloseButton;
				
				
	@FindBy(id="ctl00_FC_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FC_PH_cboCode_cboComboBoxControl")
	private WebElement blendedCode;
	
	@FindBy(id="ctl00_FC_PH_txtBlendedName")
	private WebElement blendedName;
	
	@FindBy(id="igtxtctl00_FC_PH_txtBlendedAmount_txtWebCurrencyEdit")
	private WebElement blendedAmount;
	
	@FindBy(id="igtxtctl00_FC_PH_txtInventoryID")
	private WebElement inventoryID;
	
	@FindBy(id="ctl00_FC_PH_cboInvoiceGroupingOptionID_cboInvoiceOption")
	private WebElement invoiceOption;
	
	@FindBy(id="ctl00_FC_PH_txtDueDate_input")
	private WebElement dueDate;
	
	@FindBy(id="ctl00_FC_PH_chkIsAssetBased")
	private WebElement assetBasedCheckBox;
	
	@FindBy(id="ctl00_FC_PH_chkIsChargeBack")
	private WebElement chargeBack;
	
	@FindBy(id="ctl00_FC_PH_cmdSave_cmdButtonControl")
	public WebElement saveButton;
	
	
	@FindBy(id="ctl00_FC_PH_cmdView_cmdButtonControl")
	public WebElement editButton;
	
	@FindBy(id="ctl00_FC_PH_cmdInventoryID_cmdImportButton")
	public  WebElement importButton;
	

	public LeaseBlendedIncome(WebDriver driver, ExtentTest test)
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCloseButton()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		closeButton.click();
	}
	
	public void clickOnFrontEndCloseButton()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(editButton));
		frontEndCloseButton.click();
	}
	
	public void addBlendedIncome(String name,String amount, String index)
	{
		WebDriverWait wt1 =new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(blendedCode));
		Select se = new Select(blendedCode);
		String in = index;
		int index1 = Integer.parseInt(in);		
		se.selectByIndex(index1);
		wt.until(ExpectedConditions.visibilityOf(blendedName));
		blendedName.sendKeys(name);
		wt.until(ExpectedConditions.visibilityOf(blendedAmount));
		blendedAmount.clear();
		blendedAmount.sendKeys(amount);
		
	}
	
	
	public void addBlendedIncomeWithAsset(String name,String amount, String InventoryID, String index)
	{
		WebDriverWait wt1 =new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(blendedCode));
		Select se = new Select(blendedCode);
		String in = index;
		int index1 = Integer.parseInt(in);	
		se.selectByIndex(index1);
		wt.until(ExpectedConditions.visibilityOf(blendedName));
		blendedAmount.clear();
		blendedName.sendKeys(name);
		wt.until(ExpectedConditions.visibilityOf(blendedAmount));
		blendedAmount.sendKeys(amount);
		wt.until(ExpectedConditions.visibilityOf(inventoryID));
		inventoryID.sendKeys(InventoryID);
	}	
		
		
	public void addBlendedIncomeChargeBack(String name,String amount,String date, String code)
	{
		WebDriverWait wt1 =new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		wt1.until(ExpectedConditions.elementToBeClickable(blendedCode));
		Select se = new Select(blendedCode);
		se.selectByVisibleText(code);
		blendedName.sendKeys(name);
		wt1.until(ExpectedConditions.elementToBeClickable(blendedAmount));
		blendedAmount.clear();
		blendedAmount.sendKeys(amount);
		wt1.until(ExpectedConditions.elementToBeClickable(invoiceOption));
		Select se1 = new Select(invoiceOption);
		se1.selectByIndex(1);
		wt1.until(ExpectedConditions.elementToBeClickable(dueDate));
		dueDate.sendKeys(date);
		
	}
	
	public void addBlendedIncomeChargeBack(String name,String amount, String code)
	{
		WebDriverWait wt1 =new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		wt1.until(ExpectedConditions.elementToBeClickable(blendedCode));
		Select se = new Select(blendedCode);
		se.selectByVisibleText(code);
		blendedName.sendKeys(name);
		wt1.until(ExpectedConditions.elementToBeClickable(blendedAmount));
		blendedAmount.clear();
		blendedAmount.sendKeys(amount);
	}
	
	public void addBlendedIncomeChargeBackWithAssetBackEnd(String name,String amount,String Inventoryalias,String date, String index) throws InterruptedException
	{
		WebDriverWait wt1 =new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		wt1.until(ExpectedConditions.elementToBeClickable(blendedCode));
		Select se = new Select(blendedCode);
		System.out.println(index);
		se.selectByVisibleText(index);
		wt1.until(ExpectedConditions.elementToBeClickable(blendedName));
		blendedName.sendKeys(name);
		wt1.until(ExpectedConditions.elementToBeClickable(blendedAmount));
		blendedAmount.clear();
		blendedAmount.sendKeys(amount);
		
		
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(importButton));
		String currentWindowhandle = driver.getWindowHandle();
		importButton.click();
		SwitchControlToNextWindow sc = new SwitchControlToNextWindow();
		sc.waitForWndows(driver, currentWindowhandle);
		AssetListPage assetlistpage= new AssetListPage(driver, test);
		assetlistpage.searchByAlias(Inventoryalias);
		assetlistpage.clickOnSearchButton();
		assetlistpage.selectGridCheckBox();
		assetlistpage.clickOnSelectExportButton(currentWindowhandle);
		
		Select se1 = new Select(invoiceOption);
		se1.selectByIndex(1);
		dueDate.sendKeys(date);
	}
	
	public void addBlendedIncomeChargeBackWithAssetFrontEnd(String name,String amount,String Inventoryalias, String index) throws InterruptedException
	{
		WebDriverWait wt1 =new WebDriverWait(driver, 60);
		wt1.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		wt1.until(ExpectedConditions.elementToBeClickable(blendedCode));
		Select se = new Select(blendedCode);
		System.out.println(index);
		se.selectByVisibleText(index);
		wt1.until(ExpectedConditions.elementToBeClickable(blendedName));
		blendedName.sendKeys(name);
		wt1.until(ExpectedConditions.elementToBeClickable(blendedAmount));
		blendedAmount.clear();
		blendedAmount.sendKeys(amount);
		/*wt1.until(ExpectedConditions.elementToBeClickable(inventoryID));
		inventoryID.sendKeys(InventoryID);*/
		
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(importButton));
		String currentWindowhandle = driver.getWindowHandle();
		importButton.click();
		SwitchControlToNextWindow sc = new SwitchControlToNextWindow();
		sc.waitForWndows(driver, currentWindowhandle);

		
		AssetListPage assetlistpage= new AssetListPage(driver, test);
		assetlistpage.searchByAlias(Inventoryalias);
		assetlistpage.clickOnSearchButton();
		assetlistpage.selectGridCheckBox();
		assetlistpage.clickOnSelectExportButton(currentWindowhandle);
		
	}
	
	
	public void saveBlendedItem()
	{
		WebDriverWait wt =new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
	}
}
