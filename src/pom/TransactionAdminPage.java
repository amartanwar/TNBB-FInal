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

public class TransactionAdminPage extends BasePage{

	public TransactionAdminPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_FC_PH_cboCashReceiptGLTemplateLease_cboGLTransaction")
	private WebElement receiptCashGLTemplate;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_FC_PH_cboBankProductCode_cboComboBoxControl")
	private WebElement bankProductCode;
	
	@FindBy(id="ctl00_FC_PH_cboCollateralCode_cboComboBoxControl")
	private WebElement collateralCode;
	
	@FindBy(id="ctl00_FC_PH_CboLoanPurposeCode_cboComboBoxControl")
	private WebElement loanPurposeCode;
	
	@FindBy(id="ctl00_FC_PH_CboResidualResponsibility_cboComboBoxControl")
	private WebElement remarketingResposibility;

	@FindBy(id="ctl00_FC_PH_ChkGenerateInterimRent")
	private WebElement generateInterimRent;
	
	@FindBy(id="ctl00_FC_PH_ChkGenerateInterimInterest")
	private WebElement generateInterimInterest;
	
	@FindBy(id="ctl00_FC_PH_cboInterimRentalGLTemplate_cboGLTransaction")
	private WebElement interimRentGLTemplate;

	@FindBy(id="ctl00_FC_PH_CboInterimRentBillingType_cboComboBoxControl")
	private WebElement interimRentBillingCycle;

	@FindBy(id="ctl00_FC_PH_cboInterimInterestGLTemplate_cboGLTransaction")
	private WebElement interimInterestGLTemplate;

	@FindBy(id="ctl00_FC_PH_CboInterimInterestBillingType_cboComboBoxControl")
	private WebElement interimInterestBillingCycle;

	@FindBy(id="igtxtctl00_FC_PH_txtFloatRateBaseAmount")
	private WebElement interimInterestBaseRate;

	@FindBy(id="igtxtctl00_FC_PH_txtSpread")
	private WebElement interimInterestSpread;

	@FindBy(id="ctl00_FC_PH_cboInterimInterestDayCountConvention_cboComboBoxControl")
	private WebElement dayCountConvention;

	@FindBy(id="ctl00_FC_PH_ChkEnterResidualsAtAssetLevel")
	private WebElement enterResidualAtAssetLevel;
	

	public boolean verifyEnterResidualAtAssetLevelCheckBoxChecked()
	{
		boolean x = enterResidualAtAssetLevel.isSelected();	
		return x;
	}
	
	
	public void clickOnEnterResidualAtAssetLevel()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(enterResidualAtAssetLevel));
		enterResidualAtAssetLevel.click();
	}

	public void selectReceiptCashGLTemplate(String template)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(receiptCashGLTemplate));
		Select se = new Select(receiptCashGLTemplate);
		se.selectByVisibleText(template);
	}
	
	public void clickSaveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	public void selectBankProductCode(String template1)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(bankProductCode));
		Select se = new Select(bankProductCode);
		se.selectByVisibleText(template1);
	}
	
	public void selectCollateralCode(String template2)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(collateralCode));
		Select se = new Select(collateralCode);
		se.selectByVisibleText(template2);
	}
	
	public void selectLoanPurposeCode(String template3)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(loanPurposeCode));
		Select se = new Select(loanPurposeCode);
		se.selectByVisibleText(template3);
	}
	
	public void selectRemarketingResponsibility(String remarketing)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(remarketingResposibility));
		Select se = new Select(remarketingResposibility);
		se.selectByVisibleText(remarketing);
	}

	
	public void selectInterimRentGLTemplate(String rentGLTemplate)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(interimRentGLTemplate));
		Select se = new Select(interimRentGLTemplate);
		se.selectByVisibleText(rentGLTemplate);
	}

	public void selectInterimInterestGLTemplate(String interestGLTemplate)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(interimInterestGLTemplate));
		Select se = new Select(interimInterestGLTemplate);
		se.selectByVisibleText(interestGLTemplate);
	}
	
	
	public void selectInterimRentBillingType(String rentBillingType)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(interimRentBillingCycle));
		Select se = new Select(interimRentBillingCycle);
		se.selectByVisibleText(rentBillingType);
	}
	
	
	public void selectInterimInterestBillingType(String interestBillingType)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(interimInterestBillingCycle));
		Select se = new Select(interimInterestBillingCycle);
		se.selectByVisibleText(interestBillingType);
	}
	
	
	
	public void clickOnGenerateInterimRent()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(generateInterimRent));
		generateInterimRent.click();
	}
	
	
	public void clickOnGenerateInterimInterest()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(generateInterimInterest));
		generateInterimInterest.click();
	}
	
	public boolean verifyInterimInterestCheckBoxChecked()
	{
		
		boolean x = generateInterimInterest.isSelected();
		return x;

	}
	
	public boolean verifyInterimRentCheckBoxChecked()
	{
		
		boolean x = generateInterimRent.isSelected();
		return x;

	}

	public void enterBaseRate(String baseRate)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(interimInterestBaseRate));
		interimInterestBaseRate.clear();
		interimInterestBaseRate.sendKeys(baseRate);
	}
	
	
	
	public void enterSpread(String spread)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(interimInterestSpread));
		interimInterestSpread.clear();
		interimInterestSpread.sendKeys(spread);
	}
	
	
	
	public void selectDayCountConvention(String DayCountConvention)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(dayCountConvention));
		Select se = new Select(dayCountConvention);
		se.selectByVisibleText(DayCountConvention);
	}

	
}
