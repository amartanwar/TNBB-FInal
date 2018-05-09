package pom;

import java.awt.AWTException;

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

public class PayoffAssetSelectionAndAssignmentPage extends BasePage{
	
	
	public PayoffAssetSelectionAndAssignmentPage(WebDriver driver,ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="ctl00_FC_PH_txtQuoteName")
	private WebElement payOffQuoteName;
	
	@FindBy(id="ctl00_FC_PH_cboPayOffQuoteTerminationType_cboComboBoxControl")
	private WebElement terminationType;
	
	@FindBy(id="ctl00_FT_PH_cmdSaveAndContinue_cmdButtonControl")
	private WebElement saveAndContinueButton;
	
	@FindBy(id="ctl00_FT_PH_cmdSave_cmdButtonControl")
	private WebElement saveButton;

	@FindBy(id="ctl00_FT_PH_cmdClose_cmdButtonControl")
	private WebElement closeButton;
	
	@FindBy(id="ctl00_FC_PH_grdList_lnkAllCP")
	private WebElement selectAllButton;
	
	@FindBy(id="ctl00_FC_PH_grdList_AssignmentListControl_fields")
	private WebElement assignmentDropDownButton;
	
	@FindBy(id="ctl00_FC_PH_schSearchControl_ashAdvancedSearch_QuoteInventoryStatus_cboInventoryStatus")
	private WebElement statusButton;
	
	@FindBy(id="ctl00_FC_PH_grdList_AssignmentListControl_entryButtons")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FC_PH_grdList_cmdAssign_cmdButtonControl")
	private WebElement assignButton;
	
	
	public void clickOnSaveAndContinue()
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
	
	
	public void enterPayOffQuoteName(String name)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(payOffQuoteName));
		payOffQuoteName.clear();
		payOffQuoteName.sendKeys(name);
		
	}
	
	public void selectTerminationType(String type)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(terminationType));
		Select select = new Select(terminationType) ;
		select.selectByVisibleText(type);
		
	}
	
	public void clickOnSelectAll()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(selectAllButton));
		selectAllButton.click();
		
	}
	
	public void selectAssignmentDropDown()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(assignmentDropDownButton));
		Select select = new Select(assignmentDropDownButton) ;
		select.selectByIndex(1);
		
	}
	
	public void selectStatusDropDown(String status)
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(statusButton));
		Select select = new Select(statusButton) ;
		select.selectByVisibleText(status);
		
	}
	
	
	public void clickOnAddButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(addButton));
		addButton.click();
		
	}
	
	public void clickOnAssignButton()
	{
		WebDriverWait wt=new WebDriverWait(driver, 60);
		wt.until(ExpectedConditions.elementToBeClickable(assignButton));
		assignButton.click();
		
	}
	
	public void selectCheckBoxAtAssetLevel(String inventoryAlias) throws AWTException, InterruptedException
	{
		WebElement fmvAmount = driver.findElement(By.xpath("//td[@uv="+"'"+inventoryAlias+"'"+"]/../td[1]"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(fmvAmount));
		fmvAmount.click();

//		Thread.sleep(3000);
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_TAB);
//		robot.keyRelease(KeyEvent.VK_TAB);
//		Thread.sleep(3000);
//		robot.keyPress(KeyEvent.VK_DOWN);
//		robot.keyRelease(KeyEvent.VK_DOWN);
//		
		


		//nbor/td/td[@uv="+"'"+inventoryAlias+"'"+"]
		//nbor/td/td[@uv="203878"]
		
		//td[@uv='203878']
		
		//td[@uv='203878']/../td[1]
	}

	
}
