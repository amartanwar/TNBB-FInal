package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeasePaymentSchedulePage extends BasePage
{
	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;

	@FindBy(id="ctl00_FC_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	
	@FindBy(id="ctl00_FC_PH_cmdClear_cmdButtonControl")
	private WebElement clearButton;
	
	
	@FindBy(id="ctl00_FC_PH_cmdSavePayment_cmdButtonControl")
	private WebElement firstSaveButton;
	
	@FindBy(id="ctl00_FC_PH_cmdSave_cmdButtonControl")
	private WebElement secondSave;
	
	
	@FindBy(id="igtxtctl00_FC_PH_txtPaymentAmount_txtWebCurrencyEdit")
	private WebElement paymentAmount;
	
	@FindBy(id="igtxtctl00_FC_PH_txtPaymentNumber")
	private WebElement numberOfPayments;
	
	@FindBy(id="igtxtctl00_FC_PH_txtRentalExecutoryFeeAmount_txtWebCurrencyEdit")
	private WebElement rentalExecutoryFeeAmount;
	
	
	@FindBy(id="igtxtctl00_FC_PH_txtNonRentalExecutoryFeeAmount_txtWebCurrencyEdit")
	private WebElement rentalNonExecutoryFeeAmount;
	
//(xpath=".//*[@id='ctl00xFCxPHxgrdListxgrdList_r_3']/td/nobr")

	

	public LeasePaymentSchedulePage(WebDriver driver, ExtentTest test)
	{
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnCloseButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.elementToBeClickable(closeButton));
		closeButton.click();
	}

	public void clickOnClearButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.elementToBeClickable(clearButton));
		clearButton.click();
	}

	public void clickOnAddButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt= new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.elementToBeClickable(firstSaveButton));
		firstSaveButton.click();
	}
	
	public void enterPaymentAmount(String amount)
	{
		WebDriverWait wt= new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.elementToBeClickable(paymentAmount));
		paymentAmount.clear();
		paymentAmount.sendKeys(amount);
	}
	
	
	public void enterNumberOfPayments(String noofpayments)
	{
		WebDriverWait wt= new WebDriverWait(driver, 20);
		wt.until(ExpectedConditions.elementToBeClickable(numberOfPayments));
		numberOfPayments.clear();
		numberOfPayments.sendKeys(noofpayments);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
