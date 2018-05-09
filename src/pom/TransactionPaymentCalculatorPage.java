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

public class TransactionPaymentCalculatorPage extends BasePage {

	public TransactionPaymentCalculatorPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}


	@FindBy(id="igtxtctl00_FC_PH_txtNoOfPayment")
	private WebElement numberOfPayments;
	
	@FindBy(id="ctl00_FC_PH_txtInceptionDate_input")
	private WebElement commencementDate;
	
	@FindBy(id="ctl00_FC_PH_cboPaymentFrequency_cboComboBoxControl")
	private WebElement paymentFrequency;
	
	@FindBy(id="igtxtctl00_FC_PH_txtNoOfInceptionPayment")
	private WebElement numberOfPaymentsOnCommencement;
	
	@FindBy(id="igtxtctl00_FC_PH_txtDueDay")
	private WebElement dueDay;
	
	@FindBy(id="ctl00_FC_PH_cboPaymentStructure_cboComboBoxControl")
	private WebElement paymentStructure;
	
	@FindBy(id="igtxtctl00_FC_PH_txtRegularPayment_txtWebCurrencyEdit")
	private WebElement regularPayment;
	
	@FindBy(id="igtxtctl00_FC_PH_txtInceptionPayment_txtWebCurrencyEdit")
	private WebElement commencementPayment;
	
	
	
	@FindBy(id="igtxtctl00_FC_PH_txtCustomerGuaranteeCustomerRisk_txtWebCurrencyEdit")
	private WebElement customerRisk;
	
	@FindBy(id="igtxtctl00_FC_PH_txtLessorRisk_txtWebCurrencyEdit")
	private WebElement lessorRisk;
	
	@FindBy(id="igtxtctl00_FC_PH_txtThirdPartyGuaranteeThirdPartyRisk_txtWebCurrencyEdit")
	private WebElement thirdPartyRisk;
	
	@FindBy(id="igtxtctl00_FC_PH_txtCustomerResidualInsurancePremium_txtWebCurrencyEdit")
	private WebElement residualValueInsurance;
	
	
	@FindBy(id="ctl00_FT_PH_cmdGeneratePayments_cmdButtonControl")
	private WebElement generatePaymentButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;
	
	@FindBy(id="igtxtctl00_FC_PH_txtPricingResidual_txtWebCurrencyEdit")
	private WebElement pricingResidual;
	
	@FindBy(id="igtxtctl00_FC_PH_txtResidualBooked_txtWebCurrencyEdit")
	private WebElement residualBooked;
	
	@FindBy(id="ctl00_FC_PH_chkFloatRateLease")
	private WebElement floatRateLease;
	
	
	@FindBy(id="ctl00_FC_PH_TxtFloatRateEffectiveDate_input")
	private WebElement floatRateEffectiveDate;
	
	
	@FindBy(id="ctl00_FC_PH_cboFloatRateIndex_cboComboBoxControl")
	public WebElement floatRateIndex;
	
	
	@FindBy(id="ctl00_FC_PH_cboDayCountMethod_cboComboBoxControl")
	private WebElement floatRateDayCountMethod;

	
	@FindBy(id="ctl00_FC_PH_cboNonbusinessDayRule_cboComboBoxControl")
	private WebElement nonBusinessDayRule;
	
	
	@FindBy(id="igtxtctl00_FC_PH_txtEffectiveRateLeadUnits")
	private WebElement effectiveRateLeadUnits;
	

	@FindBy(id="igtxtctl00_FC_PH_txtEffectiveRateDayofMonth")
	private WebElement effectiveRateDayOfMonth;
	
	@FindBy(id="igtxtctl00_FC_PH_txtOtherUpfrontPayment_txtWebCurrencyEdit")
	private WebElement otherUpfrontPayment;
	
	
	
	
	public void enterOtherUpfrontPayment(String upfrontamount)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(otherUpfrontPayment));
		otherUpfrontPayment.clear();
		otherUpfrontPayment.sendKeys(upfrontamount);
	}
	
	
	
	public void clickFloatRateLease()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(floatRateLease));
		floatRateLease.click();
	}
	
	
	public void enterFloatRateEffectiveDate(String date)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(floatRateEffectiveDate));
		floatRateEffectiveDate.clear();
		floatRateEffectiveDate.sendKeys(date);
	}
	
	
	public void selectFloatRateIndex(String index)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(floatRateIndex));
		Select se = new Select(floatRateIndex);
		se.selectByVisibleText(index);
	}
	
	
	public void selectDayCountMethod(String index1)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(floatRateDayCountMethod));
		Select se = new Select(floatRateDayCountMethod);
		se.selectByVisibleText(index1);
	}
	
	public void selectNonBusinessDayRule(String index2)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(nonBusinessDayRule));
		Select se = new Select(nonBusinessDayRule);
		se.selectByVisibleText(index2);
	}
	
	public void enterEffectiveRateDayOfMonth(String day)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(effectiveRateDayOfMonth));
		effectiveRateDayOfMonth.clear();
		effectiveRateDayOfMonth.sendKeys(day);
	}
	
	
	
	public void enterEffectiveRateLeadUnits(String rate)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(effectiveRateLeadUnits));
		effectiveRateLeadUnits.clear();
		effectiveRateLeadUnits.sendKeys(rate);
	}

	
	public void enterPricingResidual(String pricingresidual)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(pricingResidual));
		pricingResidual.clear();
		pricingResidual.sendKeys(pricingresidual);
	}
	
	public void enterRsidualBooked(String ResidualBooked)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(residualBooked));
		residualBooked.clear();
		residualBooked.sendKeys(ResidualBooked);
	}

	
	public void enterNumberOfPayments(String noOfPayments)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(numberOfPayments));
		numberOfPayments.clear();
		numberOfPayments.sendKeys(noOfPayments);
	}
	
	public void enterCommencementDate(String date)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(commencementDate));
		commencementDate.clear();
		commencementDate.sendKeys(date);
	}
	
	public void selectPaymentStructure(String structure)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(paymentStructure));
		Select se = new Select(paymentStructure);
		se.selectByVisibleText(structure);
	}

	public void selectPaymentFrequency(String frequency)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(paymentFrequency));
		Select se = new Select(paymentFrequency);
		se.selectByVisibleText(frequency);
	}
	 	
	public void enterNumberCommencementPayments(String noOfCommencementPayment)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(numberOfPaymentsOnCommencement));
		numberOfPaymentsOnCommencement.clear();
		numberOfPaymentsOnCommencement.sendKeys(noOfCommencementPayment);
	}
	
	
	public void enterDueDay(String day)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(dueDay));
		dueDay.clear();
		dueDay.sendKeys(day);
	}
	
	
	public void enterCommencementPayment(String CommencementPayment)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(commencementPayment));
		commencementPayment.clear();
		commencementPayment.sendKeys(CommencementPayment);
	}
	
	public void enterRegularPayment(String payment)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(regularPayment));
		regularPayment.clear();
		regularPayment.sendKeys(payment);
	}
	
	
	public void enterCustomerRisk(String customerrisk)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(customerRisk));
		customerRisk.clear();
		customerRisk.sendKeys(customerrisk);
	}
	
	
	public void enterLessorRisk(String lessorrisk)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(lessorRisk));
		lessorRisk.clear();
		lessorRisk.sendKeys(lessorrisk);
	}
	
	public void enterThirdPartyRisk(String thirdpartyrisk)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(thirdPartyRisk));
		thirdPartyRisk.clear();
		thirdPartyRisk.sendKeys(thirdpartyrisk);
	}
	
	
	public void enterResidualValueInsurance(String residualvalueinsurance)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(residualValueInsurance));
		residualValueInsurance.clear();
		residualValueInsurance.sendKeys(residualvalueinsurance);
	}
	
	
	public void clickCloseButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(closeButton));
		closeButton.click();
	}
	
	public void clickSaveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(saveButton));
		saveButton.click();
	}
	
	public void clickGeneratePaymentsButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(generatePaymentButton));
		generatePaymentButton.click();
	}

	
}
