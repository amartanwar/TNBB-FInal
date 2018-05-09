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
import generic.SystemDate;

public class AssetProfilePage extends BasePage
{
	@FindBy(id="ctl00_FC_PH_txtAlias")
	private WebElement alias;
	
	@FindBy(id="ctl00_FC_PH_txtAcquisitionDate_input")
	private WebElement acquiredDate;
	
	@FindBy(id="ctl00_FC_PH_cboInventoryTypeID_cboComboBoxControl")
	private WebElement type;
	
	@FindBy(id="ctl00_FC_PH_cboUpfitMakeID_cboComboBoxControl")
	private WebElement assetcategory;
	
	@FindBy(id="ctl00_FC_PH_txtCustomerID")
	private WebElement accountNumber;
	
	@FindBy(id="ctl00_FC_PH_txtFactorCategoryID")
	private WebElement factorCategory;
	
	@FindBy(id="ctl00_FC_PH_cboIndustryTypeID_cboComboBoxControl")
	private WebElement industryType;
	
	@FindBy(id="ctl00_FC_PH_cboTaxResponsibilityId_cboComboBoxControl")
	private WebElement propertyTaxResposibility;
	
	@FindBy(id="ctl00_FC_PH_txtLocationCode")
	private WebElement locationCode;
	
	@FindBy(id="ctl00_F_PH_txtLocationEffectiveFromDate_input")
	private WebElement effectiveDate;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_FC_PH_txtLocationEffectiveFromDate_input")
	private WebElement locationEffectiveDate;
	
	@FindBy(id="ctl00_FC_PH_cboInventoryStatusID_cboComboBoxControl")
	private WebElement status;
	
	@FindBy(id="igtxtctl00_FC_PH_txtOriginalCost_txtWebCurrencyEdit")
	private WebElement originalCost;
	
	@FindBy(id="ctl00_FC_PH_chkTaxExempt")
	private WebElement taxExempt;
	
	@FindBy(id="ctl00_FC_PH_cboTaxExemptionReason_cboComboBoxControl")
	private WebElement taxExemptReason;
	
	
	
	
	

	public AssetProfilePage(WebDriver driver,ExtentTest test) 
	{
		
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void enterAlias(String un)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(alias));
		alias.clear();
		alias.sendKeys(un);
	}
	
	public void enterAcquiredDate()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(acquiredDate));
		acquiredDate.sendKeys(SystemDate.currentDate());
	}
	
	public void enterAcquiredDate(String date)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(acquiredDate));
		acquiredDate.sendKeys(date);
	}
	
	public void selectAssetType(String assetType)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(type));
		Select se =new Select(type);
		se.selectByVisibleText(assetType);
		
	}
	
	public void selectAssetcategory(String ascategory)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(assetcategory));
		Select se= new Select(assetcategory);
		se.selectByVisibleText(ascategory);
	}
	
	public void selectpropertyTaxResposibility(String propeTaxResposibility)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(propertyTaxResposibility));
		Select se= new Select(propertyTaxResposibility);
		se.selectByVisibleText(propeTaxResposibility);
	}
	
	public void enterAccountNumber(String acNumber)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(accountNumber));
		accountNumber.sendKeys(acNumber);
	}
	
	public void selectFactorCategory(String fcCategory)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(factorCategory));
		factorCategory.sendKeys(fcCategory);
	}
	
	public void enterLocationCode(String locCode)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(locationCode));
		locationCode.sendKeys(locCode);
	}
	
	public void enterEffectiveDate()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(effectiveDate));
		effectiveDate.sendKeys(SystemDate.currentDate());
	}
	
	public void selectIndustryType(String industrytype)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(industryType));
		Select se =new Select(industryType);
		se.selectByVisibleText(industrytype);	
	}
	
	public void clickOnSave()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void enterLocationEffectiveDate(String date)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(locationEffectiveDate));
		locationEffectiveDate.clear();
		locationEffectiveDate.sendKeys(date);
	}
	
	public void selectStatus(String Status)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(status));
		Select se =new Select(status);
		se.selectByVisibleText(Status);
		
	}
	
	public void enterOriginalCost(String cost)
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(originalCost));
		originalCost.clear();
		originalCost.sendKeys(cost);
	}
	
	public void selectTaxExemptReason()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(taxExemptReason));
		Select se =new Select(taxExemptReason);
		se.selectByIndex(1);
		
	}
	
	public void clickOnTaxExemptCheckBox()
	{
		WebDriverWait wt= new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(taxExempt));
		taxExempt.click();
	}
	
	
}
