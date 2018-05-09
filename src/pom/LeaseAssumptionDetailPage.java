package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class LeaseAssumptionDetailPage extends BasePage{

	public LeaseAssumptionDetailPage(WebDriver driver, ExtentTest test) {
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="ctl00_FC_PH_txtPostDate_input")
	private WebElement postDate;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;
	
	@FindBy(id="ctl00_NB_PH_UCLeaseAssumptionLink_cboAssumptionStatus_cboComboBoxControl")
	private WebElement assumptionStatus;
	
	@FindBy(id="ctl00_NB_PH_UCLeaseAssumptionLink_cmdSave_cmdButtonControl")
	private WebElement globalSaveButton;
	
	
	
	public void clickOnSaveButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
	}
	
	
	public void clickOnGlobalSaveButton() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(globalSaveButton));
		globalSaveButton.click();
	}
	
	public void selectAssumptionStatus() 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(assumptionStatus));
		Select se = new Select(assumptionStatus);
		se.selectByIndex(2);
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
