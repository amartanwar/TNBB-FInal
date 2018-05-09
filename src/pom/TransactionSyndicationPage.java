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

public class TransactionSyndicationPage extends BasePage
{


	public TransactionSyndicationPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ctl00_FC_PH_cboSyndicationActivationGL_cboGLTransaction")
	private WebElement syndicationGLTemplate;
	
	@FindBy(id = "ctl00_FC_PH_LtrToArGLTemplateUC_cboGLTransaction")
	private WebElement ltrToARGLTemplate;
	
	
	@FindBy(id = "ctl00_FC_PH_cboReceiptCashGLTemplate_cboGLTransaction")
	private WebElement receiptCashGLTemplate;
	
	@FindBy(id = "ctl00_FC_PH_OTPARGLTemplateUC_cboGLTransaction")
	private WebElement oTPARGLTemplate;
	
	@FindBy(id = "igtxtctl00_FC_PH_txtServiceFeeAmount_txtWebCurrencyEdit")
	private WebElement syndicationFee;
	
	@FindBy(id = "ctl00_FC_PH_txtFundingDate_input")
	private WebElement fundingDate;
	
	@FindBy(id = "igtxtctl00_FC_PH_txtSyndicationProceeds_txtWebCurrencyEdit")
	private WebElement netInvestorFundedAmount;
	
	@FindBy(id = "ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public void selectSyndicationGLTemplate(String template)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(syndicationGLTemplate));
		Select se = new Select(syndicationGLTemplate);
		se.selectByVisibleText(template);
	}
	
	public void selectLTRToARGLTemplate(String template)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(ltrToARGLTemplate));
		Select se = new Select(ltrToARGLTemplate);
		se.selectByVisibleText(template);
	}
	
	public void selectOTPARGLTemplate(String template)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(oTPARGLTemplate));
		Select se = new Select(oTPARGLTemplate);
		se.selectByVisibleText(template);
	}
	
	public void selectReceiptCashGLTemplate(String template)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(receiptCashGLTemplate));
		Select se = new Select(receiptCashGLTemplate);
		se.selectByVisibleText(template);
	}
	
	public void enterSyndicationFee(String fee)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(syndicationFee));
		syndicationFee.clear();
		syndicationFee.sendKeys(fee);
	}
	
	public void enterFundingDate(String date)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(fundingDate));
		fundingDate.clear();
		fundingDate.sendKeys(date);
	}
	
	public void enterNetInvestorFundedAmount(String amount)
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(netInvestorFundedAmount));
		netInvestorFundedAmount.clear();
		netInvestorFundedAmount.sendKeys(amount);
	}
	
	
	
	public void clickOnSaveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
		
	}
	


}
