package pom;

import org.openqa.selenium.Alert;
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

public class LeaseAssumptionParamentPage extends BasePage {

	
	public LeaseAssumptionParamentPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_FC_PH_cboAssumptionReason_cboComboBoxControl")
	private WebElement assumptionReason;
	
	@FindBy(id="ctl00_FT_PH_cmdContinue_cmdButtonControl")
	private WebElement continueButton;
	
	@FindBy(id="igtxtctl00_FC_PH_txtAccountNumber")
	private WebElement newAccountNumber;
	
	@FindBy(id="igtxtctl00_FC_PH_txtNewInvoiceGroup")
	private WebElement newInvoiceGroup;
	
	
	public void selectAssumptionReason(String reason)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(assumptionReason));
		Select se = new Select(assumptionReason);
		se.selectByVisibleText(reason);
		
	}

	
	public void selectPayment(String paymentnumber)
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(assumptionReason));
		
		int EffectivePaymentNumber = (Integer.parseInt(paymentnumber))-1;
		
		WebElement paymentNumber = driver.findElement(By.id("ctl00xFCxPHxgrdPaymentListxgrdList_rc_"+EffectivePaymentNumber+"_1"));
		paymentNumber.click();
		
	}
	
	public void clickOnContinueButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
		continueButton.click();
	}
	
	public void enterNewAccountNumber(String accountNumber) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(newAccountNumber));
		newAccountNumber.sendKeys(accountNumber);
	}
	
	public void enterNewInvoiceGroup(String invoiceGroup) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(newInvoiceGroup));
		newInvoiceGroup.sendKeys(invoiceGroup);
	}
	
	public void handlePopup1()
	{
		for (int i=1;i<=1;i++)
		{
			try
			{
				
				WebDriverWait wt=new WebDriverWait(driver, 10);
				wt.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
			}
			catch (Exception e)
			{
				
			}
		}
		
	}
	
}
