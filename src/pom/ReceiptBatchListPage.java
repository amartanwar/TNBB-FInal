package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import generic.BasePage;

public class ReceiptBatchListPage extends BasePage
{
	@FindBy(id="ctl00_FT_PH_cmdAdd_cmdButtonControl")
	private WebElement addButton;
	
	@FindBy(id="ctl00_FC_PH_schSearchControl_bshBasicSearch_BatchNameUC0_txtBatchName")
	private WebElement batchName;
	
	@FindBy(id="ctl00_FC_PH_schSearchControl_cmdSearch_cmdButtonControl")
	private WebElement searchButton;
	
	@FindBy(id="ctl00_FT_PH_cmdPost_cmdButtonControl")
	private WebElement postButton;
	
	@FindBy(xpath ="//*[@id=\"ctl00_GlobalInstructionBox_DisplayArea\"]/font/a" )
	private WebElement jobID;
	
	public ReceiptBatchListPage(WebDriver driver, ExtentTest test) 
	{
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddButton()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(addButton));
	 //   String ReceiptBatchListWindow = driver.getWindowHandle();
	    addButton.click();
	    
	 //   SwitchControlToNextWindow switchcontroltonextwindow = new SwitchControlToNextWindow();
	 //   switchcontroltonextwindow.waitForWndows_MultipleWindows(driver, receiptPostingWindow, ReceiptBatchListWindow);
	    
	  //  return ReceiptBatchListWindow;

	}

	public void enterBatchName(String BatchName)
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(batchName));
	    batchName.sendKeys(BatchName);
	}
	
	public void clickOnSearchButton()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(searchButton));
	    searchButton.click();
	}
	
	public void clickOnPostButton()
	{
		WebDriverWait wt1= new WebDriverWait(driver, 60);
	    wt1.until(ExpectedConditions.elementToBeClickable(postButton));
	    postButton.click();
	}
	
	public void clickOnJobID()
	{
		WebDriverWait wt=new WebDriverWait(driver, 15);
		wt.until(ExpectedConditions.elementToBeClickable(jobID));
		jobID.click();	
	}
	
	
}
