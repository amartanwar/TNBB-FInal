package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class PayoffQuotePage extends BasePage{
	
	
	public PayoffQuotePage(WebDriver driver,ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(id="ctl00_FC_PH_txtDueDate_input")
	private WebElement dueDate;
	
	@FindBy(id="igtxtctl00_FC_PH_txtBasePayOffAmount_txtWebCurrencyEdit")
	private WebElement basePayoff;
	
	@FindBy(id="igtxtctl00_FC_PH_txtDiscountRateForPV")
	private WebElement discountRateForPV;
	
	@FindBy(id="ctl00_FC_PH_btnCalculatePV_cmdButtonControl")
	private WebElement calculatePV;

	@FindBy(id="igtxtctl00_FC_PH_txtBaseBuyOutAmount_txtWebCurrencyEdit")
	private WebElement baseBuyout;
	
	@FindBy(id="ctl00_FT_PH_cmdSaveContinue_cmdButtonControl")
	private WebElement saveAndContinueButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	public void clickOnSaveAndContinueButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton));
		saveAndContinueButton.click();	
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();	
	}
	
	public void enterDueDate(String date)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(dueDate));
		dueDate.clear();
		dueDate.sendKeys(date);
	}
	
	public void enterBasePayoff(String payoffAmount)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(basePayoff));
		basePayoff.clear();
		basePayoff.sendKeys(payoffAmount);
	}
	
	public void enterBaseBuyout(String buyoutAmount)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(baseBuyout));
		baseBuyout.clear();
		baseBuyout.sendKeys(buyoutAmount);
	}
	
	public void handleAlert()
	{
		
			try
			{
				
				WebDriverWait wt=new WebDriverWait(driver, 1);
				wt.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
			}
			catch (Exception e)
			{
				
			}
		
	}
	
	
	
	
	
	

}
