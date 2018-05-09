package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class TransactionBriefPage extends BasePage {
	
	public TransactionBriefPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="ctl00_FC_PH_CboOriginationChannel_cboComboBoxControl")
	private WebElement originationChannel;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_FC_PH_ChkSyndicated")
	private WebElement syndicated;
	
	@FindBy(id="igtxtctl00_FC_PH_TxtFundingSource")
	private WebElement fundingSource;
	
	@FindBy(id="igtxtctl00_FC_PH_TxtFundingSourceNumForDeal")
	private WebElement dealSource;
	
	
	public void selectOriginationChannel(String originationChannelValue)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(originationChannel));
				
		org.openqa.selenium.support.ui.Select se = new org.openqa.selenium.support.ui.Select(originationChannel);
		se.selectByVisibleText(originationChannelValue);	
	}
	
	public void clickOnSaveButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
				
	}
	
	public void enterFundingSource(String FundingSource)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(fundingSource));
		fundingSource.sendKeys(FundingSource);
				
	}
	
	public void clickOnSyndicatedCheckBox()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(syndicated));
		syndicated.click();
				
	}
	
	public void enterDealSource(String DealSource)
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(dealSource));
		dealSource.sendKeys(DealSource);
				
	}
	
	
	public void verifyingSyndicatedCheckBoxAndClicking()
	{
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(syndicated));
		Boolean status = syndicated.isSelected();
		int i = status ? 1 : 0;
		
		if(i==0)
		{
			syndicated.click();
		}
		
		else
		{
			System.out.println("Already Syndicated Check Box is selected");
		}
		
	}
	

}
